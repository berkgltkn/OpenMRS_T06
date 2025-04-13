package openMRS.navigationToLoginPage;

import openMRSUtility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_LoginCase extends BaseDriver {
    @Test(priority=1)
    public void verifyNavigation(){
        navigationToLoginPage loginPage=new navigationToLoginPage();
        loginPage.enterTheDemoSite();
        Assert.assertTrue(loginPage.loginPageDisplayed(),"Login Page'e geçilemedi.");
    }
}
