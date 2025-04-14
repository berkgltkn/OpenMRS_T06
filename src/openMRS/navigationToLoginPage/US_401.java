package openMRS.navigationToLoginPage;

import openMRSUtility.BaseDriver;
import openMRSUtility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class US_401 extends BaseDriver {
    @Test(priority = 1)
    public void verifyNavigation() {
        Login_POM loginPageCredential = new Login_POM();
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
    }

    @Test(dataProvider = "userCredentials", priority = 2, dependsOnMethods = {"verifyNavigation"})
    public void loginWithError(String username, String password) {
        SoftAssert softAssert = new SoftAssert();
        Login_POM loginPageCredential = new Login_POM();
        MyFunc myfunc = new MyFunc();

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
            case "admin":
                wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
                myfunc.randomSelection();
                actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
                wait.until(ExpectedConditions.urlContains("referenceapplication"));
                Assert.assertTrue(driver.getCurrentUrl().contains("referenceapplication"),"Başarıyla geçilemedi.");
                softAssert.assertAll();
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