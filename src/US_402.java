import openMRSUtility.BaseDriverParameter;
import openMRSUtility.Login_POM;
import openMRSUtility.MyFunc;
import openMRSUtility.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US_402 extends BaseDriverParameter {
    @Test(priority = 1)
    @Parameters("BrowserType")
    public void verifyNavigation() {
        Login_POM loginPageCredential = new Login_POM();

        driver.get("https://openmrs.org/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='zak-button']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='zak-button']")));
        loginPageCredential.demoLink.click();

        wait.until(ExpectedConditions.urlContains("g%C3%B6steri"));

        action.scrollToElement(loginPageCredential.demoButton).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(loginPageCredential.demoButton));
        wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.demoButton));
        action.scrollToElement(loginPageCredential.demoButton).moveToElement(loginPageCredential.demoButton).click().build().perform();

        wait.until(ExpectedConditions.visibilityOf(loginPageCredential.loginIcon));
        Assert.assertTrue(loginPageCredential.loginText.getText().toLowerCase().equalsIgnoreCase("logın"), "Login'e geçilemedi.");
    }

    @Test(dataProvider = "userCredentials", priority = 2)
    public void loginToSiteWithError(String username, String password) {
        Login_POM loginPageCredential = new Login_POM();
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods reusableMethods= new ReusableMethods();

        wait.until(ExpectedConditions.visibilityOf(loginPageCredential.loginUsername));
        wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginUsername));

        loginPageCredential.loginUsername.sendKeys(username);
        loginPageCredential.loginPassword.sendKeys(password);

        switch (username) {
            case "Test1":
                reusableMethods.locationError();
                break;
            case "Test2":
                reusableMethods.locationError();
                break;
            case "Test3":
                reusableMethods.locationError();
                break;
            case "Test4":
                reusableMethods.usernameAndPasswordError();
                break;
            case "Test5":
                reusableMethods.usernameAndPasswordError();
                break;
            case "Test6":
                reusableMethods.usernameAndPasswordError();
                break;
            case "admin":
                wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
                reusableMethods.randomSelection();
                action.moveToElement(loginPageCredential.loginButton).click().build().perform();
                wait.until(ExpectedConditions.urlContains("referenceapplication"));
                Assert.assertTrue(driver.getCurrentUrl().contains("referenceapplication"), "Başarıyla geçilemedi.");
                softAssert.assertAll();
                break;
        }
    }

    @DataProvider
    Object[][] userCredentials() {
        Object[][] loginCredentials = {
                {"Test1", "admin123",false},
                {"Test2", "admin123",false},
                {"Test3", "Admin123",false},
                {"Test4", "Admin123",false},
                {"Test5", "Admin123",false},
                {"Test6", "admin123",false},
        };
        return loginCredentials;
    }
}