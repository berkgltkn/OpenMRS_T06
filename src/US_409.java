import openMRSUtility.BaseDriverParameter;
import Pages.Login_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class US_409 extends BaseDriverParameter {
    @Test(priority = 1)
    @Parameters("BrowserType")
    public void loginToAccount() {
        Login_POM loginCredentials = new Login_POM();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        wait.until(ExpectedConditions.elementToBeClickable(loginCredentials.loginUsername));

        loginCredentials.loginUsername.sendKeys("admin");
        loginCredentials.loginPassword.sendKeys("Admin123");
        loginCredentials.inpatientWardButton.click();
        loginCredentials.loginButton.click();

        wait.until(ExpectedConditions.urlContains("referenceapplication"));
        Assert.assertTrue(driver.getCurrentUrl().contains("referenceapplication"), "Siteye başarılı şekilde geçilemedi.");
    }

    @Test(priority = 2, dependsOnMethods = {"loginToAccount"})
    public void navigationToTheList() {
        Login_POM loginCredentials = new Login_POM();
        action.moveToElement(loginCredentials.findPatientRecord).click().build().perform();
        wait.until(ExpectedConditions.urlContains("findpatient"));
        Assert.assertTrue(driver.getCurrentUrl().contains("findpatient"), "Findpatient'a başarılı şekilde geçilemedi.");
    }

    @Test(priority = 3, dependsOnMethods = {"navigationToTheList"})
    public void findThePatient() {
        Login_POM loginCredentials = new Login_POM();
        WebElement firstPatient = driver.findElement(By.cssSelector("tbody[role='alert'][aria-live='polite'][aria-relevant='all']> *:nth-child(1) >*:nth-child(1)"));
        WebElement secondPatient = driver.findElement(By.cssSelector("tbody[role='alert'][aria-live='polite'][aria-relevant='all']> *:nth-child(2) >*:nth-child(1)"));

        String firstPatientId = firstPatient.getText();
        String secondPatientId = secondPatient.getText();

        String cleanFirst = firstPatientId.replace("Recent", "");
        String cleanSecond = secondPatientId.replace("Recent", "");

        driver.navigate().to("https://o2.openmrs.org/openmrs/referenceapplication/home.page");
        wait.until(ExpectedConditions.urlContains("referenceapplication"));
        Assert.assertTrue(driver.getCurrentUrl().contains("referenceapplication"), "Ana web sayfasına dönemedi");

        action.moveToElement(loginCredentials.dataManagement).click().build().perform();
        wait.until(ExpectedConditions.urlContains("dataManagement"));

        action.moveToElement(loginCredentials.mergeThePatientRecords).click().build().perform();
        wait.until(ExpectedConditions.urlContains("mergePatients"));

        loginCredentials.firstPatientToMerge.sendKeys(cleanFirst);
        loginCredentials.secondPatientToMerge.sendKeys(cleanSecond);

        action.moveToElement(loginCredentials.confirmButton, 100, -100).click().build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("confirm-button")));
        action.moveToElement(loginCredentials.confirmButton).click().build().perform();
        wait.until(ExpectedConditions.urlContains("mergePatients"));
        Assert.assertTrue(driver.getCurrentUrl().contains("mergePatients"), "Başarı ile sayfaya geçildi.");

        action.scrollToElement(loginCredentials.errorMesseageForMerge).build().perform();
        Assert.assertTrue(loginCredentials.errorMesseageForMerge.getText().contains("Merging cannot be"), "Uyarı mesajı doğru verilemedi.");
        loginCredentials.secondPatientForChoose.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("confirm-button")));
        action.scrollToElement(loginCredentials.confirmButton).moveToElement(loginCredentials.confirmButton).click().build().perform();

        wait.until(ExpectedConditions.urlContains("patientdashboard"));

        List<String> patientIds = Arrays.asList(cleanFirst, cleanSecond);
        List<WebElement> patientElements = Arrays.asList(loginCredentials.firstPatientID, loginCredentials.secondPatientID);

        for (int i = 0; i < patientElements.size(); i++) {
            Assert.assertTrue(patientElements.get(i).getText().contains(patientIds.get(i)), "ID uyuşmadı: " + patientIds.get(i));
        }
    }
}
