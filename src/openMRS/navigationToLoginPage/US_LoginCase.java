package openMRS.navigationToLoginPage;

import openMRSUtility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

        loginPageCredential.loginUsername.clear();
        loginPageCredential.loginPassword.clear();

        loginPageCredential.loginUsername.sendKeys(username);
        loginPageCredential.loginPassword.sendKeys(password);
        switch (username) {
            case "Test1":
                firstThree();
            case "Test2":
                firstThree();
            case "Test3":
                firstThree();
            case "Test4":
                lastTwo();
            case "Test5":
                lastTwo();
            case "admin":
        }
    }

    @DataProvider
    Object[][] userCredentials() {
        Object[][] loginCredentials = {
                {"Test1", ""},
                {"Test2", ""},
                {"Test3", "Admin123"},
                {"Test4", "Admin123"},
                {"Test5", "Admin123"},
                {"admin", "admin123"},
        };
        return loginCredentials;
    }

    public static void firstThree() {
        navigationToLoginPage loginPageCredential = new navigationToLoginPage();
        wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
        actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
        Assert.assertTrue(loginPageCredential.loginErrorMessage.getText().contains("You must choose a location!"), "Location seçildi.");
    }

    public static void lastTwo() {
        navigationToLoginPage loginPageCredential = new navigationToLoginPage();
        wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
        actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
        Assert.assertTrue(loginPageCredential.loginErrorMessage.getText().contains("You must choose a location!"), "Location seçildi.");

    }
    public static void successfullLogin(){
        navigationToLoginPage loginPageCredential = new navigationToLoginPage();
        actionDriver.moveToElement(loginPageCredential.inpatientWardLocation).click().build().perform();
        actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
    }
}
