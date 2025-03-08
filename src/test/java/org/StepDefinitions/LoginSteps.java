package org.StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.cucumber.Page.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginP;


    @Before
    public void setUpBeforeActions() {
        this.driver = HooksCucumber.getDriver();
        loginP = new LoginPage(driver);
    }


    @Then("User accepts cookies")
    public void userAcceptsCookies() {
        loginP.acceptCookie();
    }

    @Then("User verifies that home page is visible successfully")
    public void userVerifiesThatHomePageIsVisibleSuccessfully() {
        String ExpectedTitle = "Automation Exercise - Signup / Login";
        String ActualTitle = loginP.getTitle();
        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

    @And("User clicks on {string} button from top menu")
    public void userClicksOnSignupLoginButton(String option) {
        loginP.selectAnOptionFromMenu(option);
    }

    @Then("User verifies that Login to your account is visible")
    public void userVerifiesThatLoginToYourAccountIsVisible() {
        Assert.assertTrue(loginP.isSignUpVerificationVisible());
    }

    @Then("^User enters \"([^\"]*)\" email address and password$")
    public void userEntersCorrectEmailAddressAndPassword(String validInvalid) {
        loginP.fillCredentialsForLogin(validInvalid);
    }

    @And("User clicks {string}")
    public void userClicksLoginButton(String button) throws InterruptedException {
        loginP.clickButtonFromLoginSignUpContainer(button);
    }

    @Then("User verifies that Logged in as username is visible")
    public void userVerifiesThatLoggedInAsUsernameIsVisible() throws IOException {
        System.out.println("User verifies that Logged in as username is visible");
        Assert.assertTrue(loginP.isLoggedInAsVisible());
    }


    @Then("User clicks Delete Account button")
    public void userClicksDeleteAccountButton() {

    }

    @Then("User Verifies that ACCOUNT DELETED! is visible")
    public void userVerifiesThatAccountDeletedIsVisible() {
    }

    @And("Description about the option to create new sign up visible")
    public void DescriptionAboutTheOptionToCreateNewSignUpVisible() {
        Assert.assertTrue(loginP.isSignUpVerificationVisible());
    }

    @And("User enters the signUp credentials")
    public void userEntersTheSignUpCredentials() {

    }


}

