package org.StepDefinitions;

import io.cucumber.java.Before;
import org.cucumber.Page.LoginPage;
import org.cucumber.Page.ProductPage;
import org.cucumber.Page.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class ProductSteps {
    WebDriver driver;
    LoginPage loginP;
    ProductPage productP;


    @Before
    public void setUpBeforeActions() {
        this.driver = HooksCucumber.getDriver();
        loginP = new LoginPage(driver);
        productP = new ProductPage(driver);
    }


}
