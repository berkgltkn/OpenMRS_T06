import openMRSUtility.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class US_403 extends BaseDriver {
    @Test
    public void LogoutSystem() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }
}
