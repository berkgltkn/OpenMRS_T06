package Pages;

import openMRSUtility.BaseDriverParameter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class patientRegistration_POM extends BaseDriverParameter {
    public patientRegistration_POM() {
        PageFactory.initElements(BaseDriverParameter.driver, this);
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

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(id = "Isolation Ward")
    public WebElement isolationWard;

    @FindBy(id = "Laboratory")
    public WebElement laboratory;

    @FindBy(id = "Outpatient Clinic")
    public WebElement outpatientClinic;

    @FindBy(id = "Pharmacy")
    public WebElement pharmacy;

    @FindBy(id = "Registration Desk")
    public WebElement registrationDesk;

    @FindBy(className = "col-12")
    public WebElement registerIcon;

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    public WebElement registerAPatientBtn;

    @FindBy(name = "givenName")
    public WebElement given;

    @FindBy(name = "middleName")
    public WebElement middleName;

    @FindBy(name = "familyName")
    public WebElement familyName;

    @FindBy(id = "next-button")
    public WebElement nextButton;

    @FindBy(css = "option[value='F']")
    public WebElement genderFemale;

    @FindBy(name = "birthdateDay")
    public WebElement birthDateDay;

    @FindBy(css = "select[name='birthdateMonth'] > option[value='8']")
    public WebElement birthDateMonth;

    @FindBy(name = "birthdateYear")
    public WebElement birthDateYear;

    @FindBy(css = "input[name='address1']")
    public WebElement address1;

    @FindBy(css = "input[name='cityVillage']")
    public WebElement cityVillage;

    @FindBy(css = "input[name='stateProvince']")
    public WebElement stateProvince;

    @FindBy(css = "input[name='country']")
    public WebElement country;

    @FindBy(css = "input[name='postalCode']")
    public WebElement postalCode;

    @FindBy(css = "input[name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(css = "select[name='relationship_type'] > option[data-val='Parent']")
    public WebElement relationshipTypeParent;

    @FindBy(css = "select[name='relationship_type'] > option[data-val='Child']")
    public WebElement relationshipTypeChild;

    @FindBy(css = "input[placeholder='Person Name']")
    public WebElement personName;

    @FindBy(css = "i.icon-plus-sign.edit-action")
    public WebElement plusIcon;

// @FindBy(css = "div[class='identifiers'] > span[class='idValue']")
// public WebElement ID;

    @FindBy(id = "submit")
    public WebElement confirm;

    @FindBy(css = "[class='float-sm-right'] > span")
    public WebElement confirmedID;

    @FindBy(css = "h1[class='mt-0 mb-2 name'] > span[class='labeled'] > span[class='PersonName-givenName']")
    public WebElement confirmedName;

    @FindBy(css = "h1[class='mt-0 mb-2 name'] > span[class='labeled'] > span[class='PersonName-middleName']")
    public WebElement confirmedMiddle;

    @FindBy(css = "h1[class='mt-0 mb-2 name'] > span[class='labeled'] > span[class='PersonName-familyName']")
    public WebElement confirmedFamilyName;
}

