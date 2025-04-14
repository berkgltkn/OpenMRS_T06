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
    public WebElement loginButton;
    @FindBy(id = "sessionLocationError")
    public WebElement loginErrorMessage;
    @FindBy(id = "error-message")
    public WebElement loginErrorMessageInvalid;
    @FindBy(css = "ul[id='sessionLocation']> li")
    public WebElement selectionList;
}
