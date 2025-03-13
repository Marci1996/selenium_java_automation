package org.StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cucumber.Page.LoginPage;
import org.cucumber.Page.RegistrationPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginP;
    RegistrationPage regPage;


    @Before
    public void setUpBeforeActions() {
        this.driver = HooksCucumber.getDriver();
        loginP = new LoginPage(driver);
        regPage = new RegistrationPage(driver);

    }


    @Given("User accepts cookies")
    public void userAcceptsCookies() {
        loginP.acceptCookie();
    }

    @And("User verifies that home page is visible successfully")
    public void userVerifiesThatHomePageIsVisibleSuccessfully() {
        String ExpectedTitle = "Automation Exercise";
        String ActualTitle = loginP.getTitle();

        Assert.assertEquals(ActualTitle, ExpectedTitle);
    }

    @When("User clicks on {string} button from top menu")
    public void userClicksOnSignupLoginButton(String option) {
        loginP.selectAnOptionFromMenu(option);
    }

    @Then("User verifies that Login to your account is visible")
    public void userVerifiesThatLoginToYourAccountIsVisible() {
        Assert.assertTrue(loginP.isSignUpVerificationVisible());
    }

    @When("^User enters \"([^\"]*)\" email address and password$")
    public void userEntersCorrectEmailAddressAndPassword(String validInvalid) {
        loginP.fillCredentialsForLogin(validInvalid);
    }

    @And("User clicks {string}")
    public void userClicksLoginButton(String button) throws InterruptedException {
        loginP.clickButtonFromLoginSignUpContainer(button);
    }

    @Then("User verifies that Logged in as username is visible")
    public void userVerifiesThatLoggedInAsUsernameIsVisible() throws IOException {
        Assert.assertTrue(loginP.isLoggedInAsVisible());
    }


    @Then("User clicks Delete Account button")
    public void userClicksDeleteAccountButton() {

    }

    @Then("User Verifies that ACCOUNT DELETED! is visible")
    public void userVerifiesThatAccountDeletedIsVisible() {
    }

    @Then("Description about the option to create new sign up visible")
    public void DescriptionAboutTheOptionToCreateNewSignUpVisible() {
        Assert.assertTrue(loginP.isSignUpVerificationVisible());
    }

    @When("User enters the signUp credentials")
    public void userEntersTheSignUpCredentials() throws IOException {
        loginP.fillSignUpCredentials();
    }

    @When("User enters the following information within the registration form")
    public void userEntersTheFollowingInformationWithinTheRegistrationForm(DataTable dtable) {
        List<List<String>> data = dtable.asLists(String.class);

        int howManyRow = data.size();

        for (int i = 0; i < howManyRow; i++) {
            if (i == 0) {
                regPage.selectGender(data.get(i).get(i + 1));
            } else if (i == howManyRow - 1) {
                regPage.fillOutDateOfBirthFields(data.get(data.size() - 1).get(1));
            } else {
                regPage.sendInputForRegistrationForm(data.get(i).get(0), data.get(i).get(1));
            }
        }
    }

    @And("User marks the checkbox with {string} name")
    public void userMarksTheCheckBox(String checkboxName) {
        Map<String, String> checkboxMap = new HashMap<>();
        checkboxMap.put("Sign up for our newsletter!", "newsletter");
        checkboxMap.put("Receive special offers from our partners!", "optin");

        String checkboxId = checkboxMap.get(checkboxName);
        if (checkboxId != null) {
            regPage.markTheCheckBox(checkboxId);
        } else {
            throw new IllegalArgumentException("Invalid name added for the checkbox " + checkboxName);
        }
    }


    @And("User fills the following details as well within the registration form")
    public void userFillsTheFollowingDetailsAsWellWithinTheRegistrationForm(DataTable dtable) {
        List<List<String>> data = dtable.asLists(String.class);
        for (List<String> datum : data) {
            if (!Objects.equals(datum.get(0), "Country")) {
                regPage.sendInputForRegistrationForm(datum.get(0), datum.get(1));
            } else {
                regPage.selectCountry(datum.get(1));
            }
        }

    }

    @And("User clicks on create account button")
    public void userClicksONCreateAccountButton() {
        regPage.clickOnCreateAccountButton();
    }


}

