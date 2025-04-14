import openMRS.navigationToLoginPage.US_LoginCase;
import openMRSUtility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class US_407 extends BaseDriver {
    US_LoginCase usLoginCase=new US_LoginCase();
    @Test
    public void PatientDeletion(){
        usLoginCase.verifyNavigation();
        WebElement usurname=driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(usurname));
        usurname.sendKeys("admin");
        WebElement password=driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Admin123");
        WebElement location=driver.findElement(By.id("Inpatient Ward"));
        wait.until(ExpectedConditions.elementToBeClickable(location));
        location.click();
        WebElement loginButton=driver.findElement(By.id("loginButton"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        WebElement findPatientButton= driver.findElement(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        wait.until(ExpectedConditions.elementToBeClickable(findPatientButton));
        findPatientButton.click();
        WebElement searchBox= driver.findElement(By.id("patient-search"));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("100M9M");
        WebElement patient= driver.findElement(By.xpath("//*[text()='100M9M']"));
        wait.until(ExpectedConditions.visibilityOf(patient));
        patient.click();

    }
}
