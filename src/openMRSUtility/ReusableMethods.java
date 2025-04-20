package openMRSUtility;

import Pages.Login_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static openMRSUtility.BaseDriverParameter.driver;
import static openMRSUtility.BaseDriverParameter.wait;

public class ReusableMethods {
    Login_POM loginPageCredential = new Login_POM();
    SoftAssert softAssert = new SoftAssert();
    public static Actions actionDriver = new Actions(driver);

    public static void randomSelection() {
        List<WebElement> locationList = driver.findElements(By.cssSelector("ul[id='sessionLocation'] > li"));
        int randomNumberForElements = MyFunc.RandomSayiVer(locationList.size());
        WebElement randomElement = locationList.get(randomNumberForElements);

        wait.until(ExpectedConditions.elementToBeClickable(randomElement));
        wait.until(ExpectedConditions.visibilityOf(randomElement));
        actionDriver.moveToElement(randomElement).click().build().perform();
    }

    public void locationError(){
        wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
        actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
        softAssert.assertTrue(loginPageCredential.loginErrorMessage.getText().contains("You must choose a location!"), "Location seçildi.");
        driver.navigate().refresh();
    }
    public void usernameAndPasswordError(){
        wait.until(ExpectedConditions.elementToBeClickable(loginPageCredential.loginButton));
        randomSelection();
        actionDriver.moveToElement(loginPageCredential.loginButton).click().build().perform();
        softAssert.assertTrue(loginPageCredential.loginErrorMessageInvalid.getText().contains("Invalid username"), "Password şifre doğru");
        driver.navigate().refresh();
    }
}
