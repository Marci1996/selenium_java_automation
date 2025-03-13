package org.StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cucumber.Page.ContactUsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ContactUsSteps {
    WebDriver driver;
    ContactUsPage cPage;


    @Before
    public void setup() {
        this.driver = HooksCucumber.getDriver();
        cPage = new ContactUsPage(driver);
    }

    @Then("User verifies that Get In Touch description is visible")
    public void userVerifiesThatGetInTouchDescriptionIsVisible() {
        Assert.assertTrue(cPage.titleVisibility());
    }

    @When("User enters the following information within the contact page form")
    public void userEntersTheFollowingInformationWithinTheContactPageForm(DataTable dTable) {
        List<List<String>> data = dTable.asLists(String.class);
        for (List<String> row : data) {
            cPage.SendInputForContactForm(row.get(0), row.get(1));
        }
    }

    @And("User uploads a file")
    public void userUploadsAFile() {
        cPage.uploadFile();
    }

    @And("User clicks on the okay button from the form")
    public void userClicksOnTheOkayButtonFromTheForm() {
        cPage.clickOnSubmitBtn();
    }

    @Then("User accepts the alert window")
    public void userAcceptsTheAlertWindow() {
        cPage.acceptAlertMsg();
    }

    @And("Successful message about the form fill")
    public void successfulMessageAboutTheFormFill() {
        cPage.isSuccessMessageDisplayed();
    }


}


