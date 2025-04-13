package openMRSUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTool extends BaseDriver {
    public static Actions actionDriver = new Actions(driver);
    public static void waitForVisibilityAndClick(WebElement foundLocator){
        wait.until(ExpectedConditions.visibilityOf(foundLocator));
        wait.until(ExpectedConditions.elementToBeClickable(foundLocator));
        actionDriver.moveToElement(foundLocator).click().build().perform();
    }
}
