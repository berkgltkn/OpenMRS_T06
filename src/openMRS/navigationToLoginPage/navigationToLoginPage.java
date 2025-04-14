package openMRS.navigationToLoginPage;

import openMRSUtility.BaseDriver;
import openMRSUtility.WebTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class navigationToLoginPage extends BaseDriver {
    public navigationToLoginPage() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "a[class='zak-button']")
    public WebElement demoLink;
    @FindBy(css = "a[href='https://demo.openmrs.org/openmrs/login.htm']")
    public WebElement demoButton;
    @FindBy(css = "i[class='icon-lock small']")
    public WebElement loginIcon;
    @FindBy(css = "legend[class='w-auto']")
    public WebElement loginText;
    @FindBy(id = "username")
    public WebElement loginUsername;
    @FindBy(id = "password")
    public WebElement loginPassword;
    @FindBy(id = "loginButton")
    public WebElement login;

    public void enterTheDemoSite() {
        driver.get("https://openmrs.org/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='zak-button']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='zak-button']")));
        demoLink.click();

        wait.until(ExpectedConditions.urlContains("g%C3%B6steri"));

        actionDriver.scrollToElement(demoButton).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(demoButton));
        wait.until(ExpectedConditions.elementToBeClickable(demoButton));
        actionDriver.scrollToElement(demoButton).moveToElement(demoButton).click().build().perform();

        wait.until(ExpectedConditions.visibilityOf(loginIcon));
    }

    public boolean loginPageDisplayed() {
        return loginText.getText().toLowerCase().equalsIgnoreCase("logın");
    }
}
