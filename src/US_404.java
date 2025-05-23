import openMRSUtility.BaseDriverParameter;
import openMRSUtility.MyFunc;
import Pages.patientRegistration_POM;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class US_404 extends BaseDriverParameter {
    @Test
    @Parameters("BrowserType")
    public void patientRegistration() {
        patientRegistration_POM register = new patientRegistration_POM();

        driver.get("https://openmrs.org/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='zak-button']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='zak-button']")));
        register.demoLink.click();

        action.scrollToElement(register.demoButton).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(register.demoButton));
        wait.until(ExpectedConditions.elementToBeClickable(register.demoButton));
        action.scrollToElement(register.demoButton).moveToElement(register.demoButton).click().build().perform();

        wait.until(ExpectedConditions.visibilityOf(register.loginIcon));
        Assert.assertTrue(register.loginText.getText().toLowerCase().equalsIgnoreCase("logın"), "Login'e geçilemedi.");

        register.loginUsername.sendKeys("admin");
        register.loginPassword.sendKeys("Admin123");
        register.pharmacy.click();
        register.loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(register.registerAPatientBtn));
        wait.until(ExpectedConditions.elementToBeClickable(register.registerAPatientBtn));
        register.registerAPatientBtn.click();

        wait.until(ExpectedConditions.visibilityOf(register.given));
        register.given.sendKeys("Jane");
        register.middleName.sendKeys("Annie");
        register.familyName.sendKeys("Parker");
        register.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(register.genderFemale));
        wait.until(ExpectedConditions.elementToBeClickable(register.genderFemale));
        register.genderFemale.click();
        register.nextButton.click();

        register.birthDateDay.sendKeys("20");
        register.birthDateMonth.click();
        register.birthDateYear.sendKeys("1985");
        register.nextButton.click();

        register.address1.sendKeys("456 Oak St, Dallas, TX");
        register.cityVillage.sendKeys("Dallas");
        register.stateProvince.sendKeys("Texas");
        register.country.sendKeys("USA");
        register.postalCode.sendKeys("45687");
        register.nextButton.click();

        register.phoneNumber.sendKeys("5552345678");
        register.nextButton.click();

        register.relationshipTypeParent.click();
        register.personName.sendKeys("John Doe");
        register.plusIcon.click();

        register.relationshipTypeChild.click();
        register.personName.sendKeys("Olivia Johnson");
        register.nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(register.confirm));
        wait.until(ExpectedConditions.elementToBeClickable(register.confirm));
        register.confirm.click();

        wait.until(ExpectedConditions.visibilityOf(register.confirmedID));

        String finalID = register.confirmedID.getText();
        System.out.println("finalID = " + finalID);

        String name = register.confirmedName.getText();
        String middle = register.confirmedMiddle.getText();
        String familyName = register.confirmedFamilyName.getText();
        System.out.println(name + " " + middle + " " + familyName);
    }
}
