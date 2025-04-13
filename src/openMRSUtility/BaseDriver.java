package openMRSUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseDriver {
   public static Logger LogTutma = LogManager.getLogger();
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actionDriver;

    @BeforeClass
    public void Setup() {
        LogTutma.info("Log Tutma işlemi başladı");
        driver = new ChromeDriver();
        actionDriver = new Actions(driver);
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
    public void AfterMetod(ITestResult sonuc) // tesin sonuç ve isim bilgisini olduğu değişkeni
    {
       LogTutma.info(sonuc.getName() + ",  Metod Bitti" + " Sonuc=" + (sonuc.getStatus() == 1 ? "Passed" : "Failed"));
       LogTutma.warn("WARN : Metod bitti, hata oluşmuş olsa idi bu şekilde eklenebilir.Bir if kontrolü ile");
    }


}
