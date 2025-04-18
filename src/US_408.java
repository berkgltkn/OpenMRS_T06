import openMRSUtility.BaseDriver;
import openMRSUtility.Login_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US_408 extends BaseDriver {

    @Test(priority = 1)
    public void loginToAccount() {
        Login_POM loginCredentials = new Login_POM();
        driver.get("https://o2.openmrs.org/openmrs/login.htm");
        wait.until(ExpectedConditions.elementToBeClickable(loginCredentials.loginUsername));

        loginCredentials.loginUsername.sendKeys("admin");
        loginCredentials.loginPassword.sendKeys("Admin123");
        loginCredentials.inpatientWardButton.click();
        loginCredentials.loginButton.click();

        wait.until(ExpectedConditions.urlContains("referenceapplication"));
        Assert.assertTrue(driver.getCurrentUrl().contains("referenceapplication"), "Siteye başarılı şekilde geçilemedi.");
    }

    @Test(priority = 2, dependsOnMethods = {"loginToAccount"})
    public void navigationToTheList() {
        Login_POM loginCredentials = new Login_POM();
        actionDriver.moveToElement(loginCredentials.findPatientRecord).click().build().perform();
        wait.until(ExpectedConditions.urlContains("findpatient"));
        Assert.assertTrue(driver.getCurrentUrl().contains("findpatient"), "Findpatient'a başarılı şekilde geçilemedi.");
    }

    @Test(priority = 3, dependsOnMethods = {"navigationToTheList"})
    public void findThePatient() {
        Login_POM loginCredentials = new Login_POM();

        String infoText = loginCredentials.leftCornerInfoPage.getText();
        String[] parts=infoText.split(" ");
        int totalPages =Integer.parseInt(parts[5]);

        WebElement pageLinksLocator = driver.findElement(By.cssSelector("#patient-search-results-table_paginate span a"));
        List<WebElement> pageLinks = driver.findElements((By) pageLinksLocator);
        int pagesCount = pageLinks.size();

        WebElement patientRows = driver.findElement(By.cssSelector("#patient-search-results-table tbody tr"));
        int patientsTotal = 0;

        for (int i = 0; i < pagesCount; i++) {
            List<WebElement> links = driver.findElements((By) pageLinksLocator);
            links.get(i).click();
            List<WebElement> patientsOnSite = driver.findElements((By) patientRows);
            patientsTotal += patientsOnSite.size();
        }
        Assert.assertTrue(patientsTotal == totalPages, " Doğru oranda sayı bulanamadı");
        System.out.println(patientsTotal);
        System.out.println(totalPages);
    }
}