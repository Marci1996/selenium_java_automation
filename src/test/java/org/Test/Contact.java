package org.Test;

import org.Pages.ContactUsPage;
import org.Pages.LoginPage;
import org.Webdriver.driverSetUp;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Contact extends driverSetUp {

    private static final Logger log = LoggerFactory.getLogger(Contact.class);
    protected WebDriver driver;

    private ContactUsPage contPage;
    private LoginPage loginPage;


    @Before
    public void setup() {
        getWebdriver();
        driver = super.driver;

        loginPage = new LoginPage(driver);
        contPage = new ContactUsPage(driver);

    }


    // test case 6
    @Test
    public void ContactUsForm() {
        loginPage.acceptCookie();
        loginPage.clickOnContactBtn();
        Assert.assertTrue(contPage.titleVisibility());
        contPage.inputOfForm("name", "user");
        contPage.inputOfForm("email", "user@gmail.com");
        contPage.inputOfForm("subject", "userSubject");
        contPage.inputOfForm("message", "userContact");
        contPage.uploadFile();
        contPage.clickOnSubmitBtn();
        contPage.acceptAlertMsg();
        contPage.isSuccessMessageDisplayed();
        loginPage.selectAnOptionFromMenu("/");
    }

    @After
    public void TearDown() {
        driver.quit();
    }
}
