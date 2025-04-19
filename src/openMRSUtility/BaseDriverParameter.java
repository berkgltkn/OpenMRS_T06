package openMRSUtility;

import Pages.Login_POM;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseDriverParameter {
    public static Logger LogTutma = LogManager.getLogger();
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Login_POM loginPageCredential;
    public static ReusableMethods reusableMethods;

    @BeforeClass
    @Parameters("BrowserType")
    public void Setup(String browserTipi) {
        switch (browserTipi.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        action= new Actions(driver);
        loginPageCredential = new Login_POM();
        reusableMethods= new ReusableMethods();
        LogTutma.info("Başlangıç değişkenleri driver,wait,log tanımlandı ve başlatıldı");
    }

    @AfterClass
    public void TearDown() {
        MyFunc.wait(3);
        driver.quit();
        LogTutma.info("Driver kapatıldı");
        LogTutma.warn("Driver kapatılamadı.");
    }

    @BeforeMethod
    public void BeforeMetod() {
        LogTutma.info("Metod başladı");
        LogTutma.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
    }

    @AfterMethod
    public void AfterMetod(ITestResult sonuc) throws IOException // tesin sonuç ve isim bilgisini olduğu değişkeni
    {
        LogTutma.info(sonuc.getName() + ",  Metod Bitti" + " Sonuc=" + (sonuc.getStatus() == 1 ? "Passed" : "Failed"));
        LogTutma.warn("WARN : Metod bitti, hata oluşmuş olsa idi bu şekilde eklenebilir.Bir if kontrolü ile");

        if (sonuc.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String testMethodName = sonuc.getName();

            String dest = System.getProperty("user.dir") + "/screenshots/" + testMethodName + "_" + timeStamp + ".png";
            File destination = new File(dest);

            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved: " + dest);
        }
    }
}