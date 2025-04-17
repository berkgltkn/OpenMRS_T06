import openMRSUtility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class US_406 extends BaseDriver {
@Test
public void pattientlist() {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();

    driver.get("https://o2.openmrs.org/openmrs/login.htm");

    WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    username.sendKeys("admin");

    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("Admin123");

    WebElement location = wait.until(ExpectedConditions.elementToBeClickable(By.id("Inpatient Ward")));
    location.click();

    WebElement loginButton = driver.findElement(By.id("loginButton"));
    loginButton.click();

    WebElement findPatientButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")));
    findPatientButton.click();

    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("patient-search")));
    searchBox.clear();
    searchBox.sendKeys("1000A8");

    WebElement patientRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//tr/td[contains(text(),'1000A8')]/following-sibling::td[contains(text(),'Thomas López')]")));
    patientRow.click();

}
}
