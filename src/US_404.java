import openMRSUtility.BaseDriver;
import openMRSUtility.patientRegistration_POM;
import org.junit.Test;

public class US_404 extends BaseDriver {
    @Test
    public void patientRegistration() {
        patientRegistration_POM register = new patientRegistration_POM();

        driver.get("https://openmrs.org/en/");

    }
}
