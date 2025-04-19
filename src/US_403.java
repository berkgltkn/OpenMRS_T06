import openMRSUtility.BaseDriverParameter;
import openMRSUtility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class US_403 extends BaseDriverParameter {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void Setup() {
        LogTutma.info("Log Tutma işlemi başladı");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        LogTutma.info("Başlangıç değişkenleri driver,wait,log tanımlandı ve başlatıldı");

        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }

    @Test(groups = {"Smoke"})
    public void LoginSystem() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        WebElement username = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Admin123");

        WebElement location = driver.findElement(By.id("Inpatient Ward"));
        wait.until(ExpectedConditions.elementToBeClickable(location));
        location.click();

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    @Test(groups = {"Logout"})
    public void LogoutSystem() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='nav-item logout']/a")));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout butonu görünmüyor!");
        logoutButton.click();

        String actualTitle = driver.getTitle();
        if (actualTitle.equalsIgnoreCase("Login")) {
            System.out.println("Başarıyla login sayfasına dönüldü.");
        } else {
            System.out.println("Login sayfası başlığı beklenenle uyuşmuyor. Gerçek başlık: " + actualTitle);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    }

    @AfterClass
    public void TearDown() {
        MyFunc.wait(3);
        driver.quit();
        LogTutma.info("Driver kapatıldı");
        LogTutma.warn("Driver kapatılamadı.");
    }
}