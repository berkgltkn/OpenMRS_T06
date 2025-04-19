import openMRSUtility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_406 extends BaseDriverParameter {

    @Test(priority = 1)
    @Parameters("BrowserType")
    public void patientSearch() {

        driver.get("https://demo.openmrs.org/openmrs/login.htm");

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
        searchBox.sendKeys("100HNY");

        WebElement patientRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//tbody//tr/td[contains(text(),'100HNY')]/span[contains(text(),'Recent')]")));
        patientRow.click();

        WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/openmrs/index.htm']")));
        homeButton.click();

        WebElement findPatientButton2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")));
        findPatientButton2.click();

        WebElement searchBox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("patient-search")));
        searchBox2.clear();
        searchBox2.sendKeys("Emma Hostert");

        WebElement noResultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("td.dataTables_empty")));

        Assert.assertEquals("No matching records found", noResultMessage.getText());
    }
}