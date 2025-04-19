import openMRSUtility.BaseDriver;
import openMRSUtility.patientRegistration_POM;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class US_404 extends BaseDriver {
    @Test
    public void patientRegistration() {
        patientRegistration_POM register = new patientRegistration_POM();

        driver.get("https://openmrs.org/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='zak-button']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='zak-button']")));
        register.demoLink.click();

        actionDriver.scrollToElement(register.demoButton).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(register.demoButton));
        wait.until(ExpectedConditions.elementToBeClickable(register.demoButton));
        actionDriver.scrollToElement(register.demoButton).moveToElement(register.demoButton).click().build().perform();

        wait.until(ExpectedConditions.visibilityOf(register.loginIcon));
        Assert.assertTrue(register.loginText.getText().toLowerCase().equalsIgnoreCase("logın"), "Login'e geçilemedi.");

        register.loginUsername.sendKeys("admin");
        register.loginPassword.sendKeys("Admin123");
        register.pharmacy.click();
        register.loginButton.click();

    }
}
