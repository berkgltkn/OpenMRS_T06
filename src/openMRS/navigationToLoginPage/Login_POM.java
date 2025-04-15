package openMRS.navigationToLoginPage;

import openMRSUtility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_POM extends BaseDriver {
    public Login_POM() {
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
}
