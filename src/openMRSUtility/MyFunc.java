package openMRSUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static openMRSUtility.BaseDriver.driver;
import static openMRSUtility.BaseDriver.wait;
import static openMRSUtility.WebTool.actionDriver;


public class MyFunc {
    Login_POM loginPageCredential = new Login_POM();
    SoftAssert softAssert = new SoftAssert();

    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int RandomSayiVer(int min, int max)
    {
        return  (int)(Math.random()* (max-min) )+ min;
    }

    public static int RandomSayiVer(int max)
    {
        return  (int)(Math.random()* max);
    }

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
