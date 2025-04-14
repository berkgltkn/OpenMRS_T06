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
    }
}
