package org.Test;

import org.Pages.LoginPage;
import org.Webdriver.driverSetUp;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Login_Logout_Register extends driverSetUp {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        getWebdriver();
        driver = super.driver;
        loginPage = new LoginPage(driver);
    }


    // testcase2
    @Test
    public void LoginUserWithCorrectEmailAndPassowrd() throws IOException {
        loginPage.acceptCookie();
        loginPage.clickOnlogin_signupButton();
        Assert.assertTrue(loginPage.isLoginToYourAccountDescriptionVisible());
        loginPage.fillEmailAddress();
        loginPage.fillPassword();
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isLoggedInAsVisible());

    }

    // testcase3
    @Test
    public void LoginUserWithIncorrectEmailAndpassword() {
        loginPage.acceptCookie();
        loginPage.clickOnlogin_signupButton();
        loginPage.fillEmailAddress();
        loginPage.fillIncorrectPassword();
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isWrongLoginMessageAppears());


    }

    // testcase4
    @Test
    public void LogoutUser() {
        loginPage.loginHappyPath();
        loginPage.clickLogOutButton();

    }

    // testcase5
    @Test
    public void RegisterUserWithExistingEmail() throws IOException {
        loginPage.acceptCookie();
        loginPage.clickOnlogin_signupButton();
        Assert.assertTrue(loginPage.isSignUpVerificationVisible());
        loginPage.fillSignUpName();
        loginPage.fillSignUpEmail("notNew");
        loginPage.clickOnSignUpButton();
        Assert.assertTrue(loginPage.isAlreadyExistingErrorMessageDisplayed());
    }


    @After
    public void tearDown() {
        super.tearDown();
    }




}