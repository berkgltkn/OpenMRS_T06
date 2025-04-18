package openMRSUtility;

import openMRSUtility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class Login_POM extends BaseDriver {
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
    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWardButton;

    //NextPhaseOfPOM

    @FindBy(css = "div[id='apps']> *:nth-child(1)")
    public WebElement findPatientRecord;

    @FindBy(css = "div[class='dataTables_info']")
    public WebElement totalNumberList;

    //NextPhasePOM

    @FindBy(css = "a[id='patient-search-results-table_last']")
    public WebElement lastButton;

    @FindBy(css = "div[id='apps']> *:nth-child(7)")
    public WebElement dataManagement;

    @FindBy(id = "coreapps-mergePatientsHomepageLink-app")
    public WebElement mergeThePatientRecords;

    @FindBy(id = "patient1-text")
    public WebElement firstPatientToMerge;

    @FindBy(id = "patient2-text")
    public WebElement secondPatientToMerge;

    @FindBy(id = "confirm-button")
    public WebElement confirmButton;

    @FindBy(xpath = "(//div[@class='messages-container'])[2]//h1")
    public WebElement errorMesseageForMerge;

    @FindBy(id = "second-patient")
    public WebElement secondPatientForChoose;

    @FindBy(css = "div[class='float-sm-right']> *:nth-child(2)")
    public WebElement firstPatientID;

    @FindBy(css = "div[class='float-sm-right']> *:nth-child(3)")
    public WebElement secondPatientID;

    //Next Phase Pom

    @FindBy(css = "div[id='apps']> *:nth-child(5)")
    public WebElement appointmentScheduleButton;

    @FindBy(css = "div[id='apps']> *:nth-child(3)> *:nth-child(1)")
    public WebElement manageAppointments;

    @FindBy(id = "patient-search")
    public WebElement searchForPatient;

    @FindBy(xpath = "//*[@id='patient-search-results-table']/tbody/tr/td[1]")
    public WebElement idForTheIdentifier;

    @FindBy(xpath = "//*[@id=\"time-zone-warning\"]/div/div/p")
    public WebElement errorMesseageForAppointment;

    @FindBy(id = "patient-search-results-table_info")
    public WebElement leftCornerInfoPage;

    @FindBy(css = "#patient-search-results-table tbody tr")
    public WebElement patientsOnList;
}
