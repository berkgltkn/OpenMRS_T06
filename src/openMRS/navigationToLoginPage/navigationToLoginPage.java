package openMRS.navigationToLoginPage;

import openMRSUtility.BaseDriver;
import openMRSUtility.WebTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class navigationToLoginPage extends BaseDriver {
     By demoLink = By.cssSelector("a[class='zak-button']");
     By demoButton = By.cssSelector("a[href='https://demo.openmrs.org/openmrs/login.htm']");
     By loginIcon = By.cssSelector("i[class='icon-lock small']");
     By loginText = By.cssSelector("legend[class='w-auto']");

    public void enterTheDemoSite() {
        driver.get("https://openmrs.org/en/");

        WebTool.waitForVisibilityAndClick(driver.findElement(demoLink));

        wait.until(ExpectedConditions.urlContains("g%C3%B6steri"));

        actionDriver.scrollToElement(driver.findElement(demoButton)).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(demoButton));
        wait.until(ExpectedConditions.elementToBeClickable(demoButton));
        actionDriver.scrollToElement(driver.findElement(demoButton)).moveToElement(driver.findElement(demoButton)).click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginIcon));
    }
    public boolean loginPageDisplayed(){
        WebElement text=driver.findElement(loginText);
        return text.getText().toLowerCase().equalsIgnoreCase("logın");
    }
}
