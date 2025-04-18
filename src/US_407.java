
import openMRS.navigationToLoginPage.Login_POM;
import openMRS.navigationToLoginPage.US_402;
import openMRSUtility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class US_407 extends BaseDriver {
    @Test(groups = {"Smoke Test", "PatientManagement"})
    public void PatientDeletion() {
        US_402 a=new US_402();
        a.verifyNavigation();
        WebElement usurname = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(usurname));
        usurname.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Admin123");
        WebElement location = driver.findElement(By.id("Inpatient Ward"));
        wait.until(ExpectedConditions.elementToBeClickable(location));
        location.click();
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        WebElement findPatientButton = driver.findElement(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        wait.until(ExpectedConditions.elementToBeClickable(findPatientButton));
        findPatientButton.click();
        WebElement searchBox = driver.findElement(By.id("patient-search"));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys("1000A8");
        WebElement patient = driver.findElement(By.xpath("//*[text()='1000A8']"));
        wait.until(ExpectedConditions.visibilityOf(patient));
        patient.click();
        WebElement deleteButton = driver.findElement(By.xpath("(//div[@class='col-11 col-lg-10'])[8]"));
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
        WebElement reason = driver.findElement(By.id("delete-reason"));
        wait.until(ExpectedConditions.visibilityOf(reason));
        reason.sendKeys("ıncorrect");
        WebElement confirm = driver.findElement(By.xpath("(//button[text()='Confirm'])[4]"));
        wait.until(ExpectedConditions.elementToBeClickable(confirm));
        confirm.click();
    }
}
