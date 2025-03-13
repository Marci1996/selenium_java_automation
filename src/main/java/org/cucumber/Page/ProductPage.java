package org.cucumber.Page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage {
    protected WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    @And("The products list is visible")
    public void theProductsListIsVisible() {

    }


    @Then("User clicks on 'View Product' of first product")
    public void userClicksOnViewProductOfFirstProduct() {

    }


    @Then("User is landed to product detail page")
    public void userIsLandedToProductDetailPage() {

    }


    @And("Verify that the following data is visible")
    public void verifyThatTheFollowingDataIsVisible() {

    }

}
