package openMRSUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseDriverParameter {

    // aşağısını SDET8 den aldık
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    @Parameters("BrowserTipi")
    public void Setup(String browserTipi)
    {
        // seleniumdaki static yani başlangıç kısımlar konacak
        switch (browserTipi.toLowerCase()){
            case "firefox": driver=new FirefoxDriver(); break;
            case "edge": driver=new EdgeDriver(); break;
            default : driver=new ChromeDriver();
        }
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 5 sn mühlet: elementi bulma mühleti
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        LoginTest();
    }

    public void LoginTest()
    {
        System.out.println("Login Test başladı");
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        MyFunc.wait(2);

        WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("testng1@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("123qweasd");

        WebElement loginBtn=driver.findElement(By.xpath("//*[@value='Login']"));
        loginBtn.click();

        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        Assert.assertTrue(driver.getTitle().equals("My Account"), "Login olunamadı");

        System.out.println("Login Test bitti");
    }


    @AfterClass
    public void TearDown()
    {
        // seleniumdaki BekleKapat
        MyFunc.wait(3);
        driver.quit();  // bütün açılmış windowları kapatır
    }


}
