import openMRSUtility.BaseDriver;
import openMRSUtility.Login_POM;
import openMRSUtility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US_401 extends BaseDriver {
    @Test(dataProvider = "userCredentials", priority = 1, dependsOnMethods = {"verifyNavigation"})
    public void verifyNavigation(String username, String password) {
        Login_POM loginPageCredential = new Login_POM();
        SoftAssert softAssert = new SoftAssert();
        MyFunc myfunc = new MyFunc();

        driver.get("https://openmrs.org/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='zak-button']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='zak-button']")));
        loginPageCredential.demoLink.click();

        wait.until(ExpectedConditions.urlContains("g%C3%B6steri"));

        actionDriver.scrollToElement(loginPageCredential.demoButton).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(loginPageCredential.demoButton));
        wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.demoButton));
        actionDriver.scrollToElement(loginPageCredential.demoButton).moveToElement(loginPageCredential.demoButton).click().build().perform();

        wait.until(ExpectedConditions.visibilityOf(loginPageCredential.loginIcon));
        Assert.assertTrue(loginPageCredential.loginText.getText().toLowerCase().equalsIgnoreCase("logın"), "Login'e geçilemedi.");

        wait.until(ExpectedConditions.visibilityOf(loginPageCredential.loginUsername));
        wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginUsername));

        loginPageCredential.loginUsername.sendKeys(username);
        loginPageCredential.loginPassword.sendKeys(password);

        switch (username) {
            case "Test1":
                myfunc.locationError();
                break;
            case "Test2":
                myfunc.locationError();
                break;
            case "Test3":
                myfunc.locationError();
                break;
            case "Test4":
                myfunc.usernameAndPasswordError();
                break;
            case "Test5":
                myfunc.usernameAndPasswordError();
                break;
            case "Test6":
                myfunc.usernameAndPasswordError();
                break;
        }
    }

    @DataProvider
    Object[][] userCredentials() {
        Object[][] loginCredentials = {
                {"Test1", "admin123"},
                {"Test2", "admin123"},
                {"Test3", "Admin123"},
                {"Test4", "Admin123"},
                {"Test5", "Admin123"},
                {"Test6", "admin123"},
        };
        return loginCredentials;
    }
}