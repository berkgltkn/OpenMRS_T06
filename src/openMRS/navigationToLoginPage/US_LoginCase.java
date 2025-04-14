package openMRS.navigationToLoginPage;

import openMRSUtility.BaseDriver;
import openMRSUtility.MyFunc;
import openMRSUtility.WebTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_LoginCase extends BaseDriver {
    @Test(priority = 1)
    public void verifyNavigation() {
        navigationToLoginPage loginPageCredential = new navigationToLoginPage();
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
        Assert.assertTrue(loginPageCredential.loginText.getText().toLowerCase().equalsIgnoreCase("logın"), "Login'e geçilemediş.");
    }

    @Test(dataProvider = "userCredentials", priority = 2, dependsOnMethods = {"verifyNavigation"})
    public void loginWithError(String username, String password) {
        navigationToLoginPage loginPageCredential = new navigationToLoginPage();
        wait.until(ExpectedConditions.visibilityOf(loginPageCredential.loginUsername));
        wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginUsername));

        loginPageCredential.loginUsername.sendKeys(username);
        loginPageCredential.loginPassword.sendKeys(password);

        switch (username) {
            case "Test1":
                wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
                actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
                Assert.assertTrue(loginPageCredential.loginErrorMessage.getText().contains("You must choose a location!"), "Location seçildi.");
                driver.navigate().refresh();
                break;
            case "Test2":
                wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
                actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
                Assert.assertTrue(loginPageCredential.loginErrorMessage.getText().contains("You must choose a location!"), "Location seçildi.");
                driver.navigate().refresh();
                break;
            case "Test3":
                wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
                actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
                Assert.assertTrue(loginPageCredential.loginErrorMessage.getText().contains("You must choose a location!"), "Location seçildi.");
                driver.navigate().refresh();
                break;
            case "Test4":
                wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
                randomSelection();
                actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
                Assert.assertTrue(loginPageCredential.loginErrorMessageInvalid.getText().contains("Invalid username"), "Password şifre doğru");
                driver.navigate().refresh();
                break;
            case "Test5":
                wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
                randomSelection();
                actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
                Assert.assertTrue(loginPageCredential.loginErrorMessageInvalid.getText().contains("Invalid username"), "Password şifre doğru");
                driver.navigate().refresh();
                break;
            case "admin":
                randomSelection();
                actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
                wait.until(ExpectedConditions.urlContains("referenceapplication"));
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
                {"admin", "Admin123"},
        };
        return loginCredentials;
    }
    public static void randomSelection() {
        List<WebElement> locationList = driver.findElements(By.cssSelector("ul[id='sessionLocation'] > li"));
        int randomNumberForElements = MyFunc.RandomSayiVer(locationList.size());
        WebElement randomElement = locationList.get(randomNumberForElements);

        wait.until(ExpectedConditions.elementToBeClickable(randomElement));
        wait.until(ExpectedConditions.visibilityOf(randomElement));
        actionDriver.moveToElement(randomElement).click().build().perform();
    }
}
