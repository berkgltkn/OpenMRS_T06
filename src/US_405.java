import openMRSUtility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_405 extends BaseDriver {
    @Test
public void MyAccountTest(){
        driver.get("https://o2.openmrs.org/openmrs/login.htm");

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

        wait.until(ExpectedConditions.urlContains("home.page"));

        WebElement adminIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.nav-item.identifier")));
        Actions actions = new Actions(driver);
        actions.moveToElement(adminIcon).pause(10).perform();

        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/openmrs/adminui/myaccount/myAccount.page']")));
        wait.until(ExpectedConditions.elementToBeClickable(myAccount));
        myAccount.click();

        wait.until(ExpectedConditions.urlContains("myAccount"));
        Assert.assertTrue(driver.getCurrentUrl().contains("myAccount"));

        WebElement changePassword =driver.findElement(By.xpath("//a[@href='/openmrs/adminui/myaccount/changePassword.page']"));
        wait.until(ExpectedConditions.elementToBeClickable(changePassword));
        changePassword.click();

        driver.get("https://o2.openmrs.org/openmrs/adminui/myaccount/myAccount.page");

        WebElement myLangueges=driver.findElement(By.xpath("//a[@href='/openmrs/adminui/myaccount/changeDefaults.page']"));
        wait.until(ExpectedConditions.elementToBeClickable(myLangueges));
        myLangueges.click();
 }
}
