package org.cucumber.Page;

import org.cucumber.Helper.Navigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegistrationPage {

    protected WebDriver driver;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "login-form")
    private WebElement registrationForm;


    @FindBy(id = "days")
    private WebElement dayOfTheBirthDay;

    @FindBy(id = "months")
    private WebElement monthOfTheBirthDay;

    @FindBy(id = "years")
    private WebElement yearOfTheBirthDay;

    @FindBy(id = "uniform-id_gender1")
    private WebElement male;

    @FindBy(id = "uniform-id_gender2")
    private WebElement female;

    @FindBy(xpath = ".//button[data-qa='create-account']")
    private WebElement createAccountButton;


    public List<String> birthDayToParts(String birthday) {

        List<String> result = new ArrayList<>();
        StringBuilder part = new StringBuilder();

        for (int i = 0; i < birthday.length(); i++) {
            if (birthday.charAt(i) == '.') {
                result.add(part.toString());
                part = new StringBuilder();
            } else {
                part.append(birthday.charAt(i));
            }
            if(i == birthday.length()-1) {
                result.add(part.toString());
            }
        }
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }

        return result;

    }

    public void fillOutDateOfBirthFields(String dateOfBirth) {
        List<String> partsOfTheBirthDate = birthDayToParts(dateOfBirth);

        if (partsOfTheBirthDate.size() != 3) {
            throw new IllegalArgumentException("Invalid date format added in the feature file -> Expected format: '1.10.2010'");
        }

        for (int i = 0; i < partsOfTheBirthDate.size(); i++) {
            Select select;
            String part = partsOfTheBirthDate.get(i);

            if (i == 0) {
                if (!part.matches("\\d+")) {
                    throw new NumberFormatException("Day must be a number");
                }
                select = new Select(dayOfTheBirthDay);
            } else if (i == 1) {
                if (!part.matches("\\d+") || Integer.parseInt(part) > 12 || Integer.parseInt(part) < 1) {
                    throw new IllegalArgumentException("Month should be a number value between 1-12");
                }
                select = new Select(monthOfTheBirthDay);
            } else {
                if (!part.matches("\\d+")) {
                    throw new NumberFormatException("Year must be a number");
                }
                select = new Select(yearOfTheBirthDay);
            }

            select.selectByValue(part);
        }
    }


    public void sendInputForRegistrationForm(String idOfTheElement, String value) {
        if (Objects.equals(idOfTheElement, "name")) {
            driver.findElement(By.id(idOfTheElement)).clear();
            driver.findElement(By.id(idOfTheElement)).sendKeys(value);
        }
        driver.findElement(By.id(idOfTheElement)).sendKeys(value);
    }

    public void selectGender(String mrOrMrs) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if (mrOrMrs.equalsIgnoreCase("Mr.")) {
            wait.until(ExpectedConditions.elementToBeClickable(male));
            male.click();
        }
        if (mrOrMrs.equalsIgnoreCase("Mrs.")) {
            wait.until(ExpectedConditions.elementToBeClickable(female));
            female.click();
        }
    }

    public void selectCountry(String country) {
        Select select = new Select(driver.findElement(By.id("country")));
        select.selectByValue(country);
    }

    public void markTheCheckBox(String checkboxId) {
        Navigation nav = new Navigation(driver);
        WebElement checkbox = driver.findElement(By.id(checkboxId));
        nav.scrollToTheElement(driver, checkbox);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }


}

