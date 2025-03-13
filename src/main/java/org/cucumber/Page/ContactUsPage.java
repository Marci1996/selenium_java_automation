package org.cucumber.Page;

import org.cucumber.Helper.Navigation;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactUsPage {

    protected WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".status.alert.alert-success")
    private WebElement successMessage;

    @FindBy(css = ".title.text-center")
    private WebElement title;

    @FindBy(id = "form-section")
    private WebElement contactForm;

    @FindBy(name = "submit")
    private WebElement submitBtn;

    @FindBy(name = "upload_file")
    private WebElement uploadFileBtn;

    public boolean titleVisibility() {
        return title.isDisplayed();
    }

    /*
    public boolean titleVisibility() {
        return title.isDisplayed() && Objects.equals(title.getText().trim(), "Get In Touch");
    }

     */

    public List<WebElement> inputsWithinContactForm() {
        return contactForm.findElements(By.xpath(".//input  | .//textarea"));
    }

    public void SendInputForContactForm(String dataQa, String value) {
        List<WebElement> inputs = inputsWithinContactForm();
        for (WebElement input : inputs) {
            if(Objects.equals(input.getAttribute("data-qa"),  dataQa)) {
               input.sendKeys(value);
            }
        }
    }

    public List <String> inputsWithinContactFormValues() {
        List <WebElement> elements = inputsWithinContactForm();
        List <String> result = new ArrayList<>();
        for (WebElement element : elements) {
            result.add(element.getText());
        }
        for (String s : result) {
            System.out.println(s);
        }
        return result;
    }



    public void clickOnSubmitBtn() {
        Navigation nav = new Navigation(driver);
        nav.scrollToTheBottomTop(driver, "bottom");
        submitBtn.click();
    }

    public void uploadFile() {
        uploadFileBtn.sendKeys("C:/Users/Orsibaba/IdeaProjects/automation/src/test/java/text.txt");
    }

    public void acceptAlertMsg() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }



}