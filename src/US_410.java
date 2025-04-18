import openMRSUtility.BaseDriver;
import openMRSUtility.Login_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_410 extends BaseDriver {
    @Test(priority = 1)
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
    @Test(priority = 2,dependsOnMethods = {"loginToAccount"})
    public void appointmentAssignment(){
        Login_POM loginCredentials = new Login_POM();
        actionDriver.moveToElement(loginCredentials.findPatientRecord).click().build().perform();
        wait.until(ExpectedConditions.urlContains("findpatient"));
        Assert.assertTrue(driver.getCurrentUrl().contains("findpatient"), "Findpatient'a başarılı şekilde geçilemedi.");

        WebElement firstPatient = driver.findElement(By.cssSelector("tbody[role='alert'][aria-live='polite'][aria-relevant='all']> *:nth-child(1) >*:nth-child(1)"));
        String firstPatientId = firstPatient.getText();
        String cleanFirst = firstPatientId.replace("Recent", "");
        driver.navigate().to("https://o2.openmrs.org/openmrs/referenceapplication/home.page");
        wait.until(ExpectedConditions.urlContains("referenceapplication"));
        Assert.assertTrue(driver.getCurrentUrl().contains("referenceapplication"), "Ana web sayfasına dönemedi");

        actionDriver.moveToElement(loginCredentials.appointmentScheduleButton).click().build().perform();
        wait.until(ExpectedConditions.urlContains("appointments"));
        Assert.assertTrue(driver.getCurrentUrl().contains("appointments"),"Sayfaya geçilemedi.");

        actionDriver.moveToElement(loginCredentials.manageAppointments).click().build().perform();
        wait.until(ExpectedConditions.urlContains("coreapps"));
        Assert.assertTrue(driver.getCurrentUrl().contains("coreapps"),"Sayfaya geçilemedi.");

        actionDriver.moveToElement(loginCredentials.searchForPatient).sendKeys(cleanFirst).build().perform();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='patient-search-results-table']/tbody/tr/td[1]"),cleanFirst));
        actionDriver.moveToElement(loginCredentials.idForTheIdentifier).click().build().perform();

        wait.until(ExpectedConditions.urlContains("manageAppointments"));
        Assert.assertTrue(loginCredentials.errorMesseageForAppointment.getText().contains("Coordinated Universal Time"));
    }
}