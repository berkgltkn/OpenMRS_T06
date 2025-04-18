
import openMRSUtility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class US_407 extends BaseDriver {
    @Test(groups = {"Smoke Test", "PatientManagement"})
    public void PatientDeletion() {
        US_408 a = new US_408();
        a.loginToAccount();
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
