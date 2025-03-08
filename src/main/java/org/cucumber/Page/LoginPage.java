package org.cucumber.Page;

import org.cucumber.Helper.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LoginPage {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver instance is null something is wrong with setup");
        } else {
            this.driver = driver;
            PageFactory.initElements(driver, this);

        }
    }

    @FindBy(css = "input[data-qa=login-email]")
    private WebElement emailAddressField;

    @FindBy(css = "input[data-qa=login-password]")
    private WebElement passwordField;

    @FindBy(css = "button[data-qa=login-button]")
    private WebElement loginButton;

    @FindBy(css = "button[data-qa=signup-button]")
    private WebElement signUpButton;


    @FindBy(css = "input[data-qa=signup-name]")
    private WebElement signUpNameField;

    @FindBy(css = "input[data-qa=signup-email]")
    private WebElement signUpEmailField;

    @FindBy(css = "button[aria-label='Beleegyezés']")
    private WebElement cookieConsentButton;

    @FindBy(xpath = "//img[@alt='Website for automation practise']")
    private WebElement automationImage;

    @FindBy(xpath = "//div[@class='login-form']/h2")
    private WebElement loginToYourAccountDescription;

    @FindBy(xpath = ".//p[contains(text(), 'Your email or password is incorrect!')]")
    private WebElement wrongLoginMessage;

    // @FindBy(xpath = "//a[@href='/Contact us']")
    @FindBy(xpath = "//li[last()]")
    private WebElement contactUsButton;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logOutButton;

    @FindBy(xpath = "//ul[contains(@class,'navbar-nav')]/li[last()]")
    private WebElement loggedInAs;

    @FindBy(xpath = "//h2[contains(text(), 'New User Signup!')]")
    private WebElement signupVerification;

    @FindBy(xpath = "//p[contains(text(), 'Email Address already exist!')]")
    private WebElement alreadyExistingErrorMessage;

    @FindBy(className = "col-sm-8")
    private WebElement menu;


    public List<WebElement> menuItems() {
       return menu.findElements(By.xpath(".//li"));

    }


    public void selectAnOptionFromMenu(String href) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElements(menuItems()));

        for (WebElement item : items) {
            if (Objects.equals(item.getText(), href)) {
                System.out.println(item.getText());
                item.click();
                return;
            }
        }

        throw new NoSuchElementException("Item with the added href attribute is not available: " + href);
    }



    public void fillEmailAddress() {
        emailAddressField.sendKeys("marci12345678956@gmail.com");
    }

    public void fillPassword() {
        passwordField.sendKeys("password96");
    }

    public void fillIncorrectPassword() {
        passwordField.sendKeys("password96+");
    }

    public void fillCredentialsForLogin(String validOrNot) {
        if(validOrNot.equalsIgnoreCase("valid")) {
            fillEmailAddress();
            fillPassword();
        }
        else if(validOrNot.equalsIgnoreCase("invalid")){
            fillEmailAddress();
            fillIncorrectPassword();
        }
    }

    public boolean isWrongLoginMessageAppears() {
        return wrongLoginMessage.isDisplayed();
    }

    public void clickButtonFromLoginSignUpContainer(String button) {
        if(button.equalsIgnoreCase("login-button")) {
            loginButton.click();
        }
        else if(button.equalsIgnoreCase("signup-button")) {
            signUpButton.click();
        }
    }



    public void acceptCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieConsentButton));
        cookieButton.click();
    }

    public void clickOnContactBtn() {
        contactUsButton.click();
    }



    public void loginHappyPath() {
        acceptCookie();
      //  clickOnLoginSignupButton();
        fillEmailAddress();
        fillPassword();
        clickButtonFromLoginSignUpContainer("login-button");
    }



    public boolean isLoggedInAsVisible() throws IOException {
        StringBuilder sb = new StringBuilder();
        FileHandler fh = new FileHandler();
        String pre = "Logged in as";
        String post = fh.fileReader("C:/Users/Orsibaba/IdeaProjects/automation/src/test/java/data.properties", "name");
        sb.append(pre).append(" ").append(post);
        System.out.println(sb);
        return Objects.equals(sb.toString(), loggedInAs.getText());
    }

    public void clickLogOutButton() {
        logOutButton.click();
    }

    public boolean isLoginToYourAccountDescriptionVisible() {
        return loginToYourAccountDescription.isDisplayed();
    }

    public boolean isSignUpVerificationVisible() {
        return signupVerification.isDisplayed();
    }

    public void fillSignUpName() {
        signUpNameField.sendKeys("marci12345");
    }

    public void fillSignUpEmail(String newOrNot) throws IOException {
        FileHandler fh = new FileHandler();
        String email = fh.fileReader("C:/Users/Orsibaba/IdeaProjects/automation/src/test/java/data.properties", "emailAddress");

        if (Objects.equals(newOrNot, "notNew")) {
            signUpEmailField.sendKeys(email);
        } else {
            signUpEmailField.sendKeys(email + "*");
        }
    }

    public void clickOnSignUpButton() {
        signUpButton.click();
    }

    public boolean isAlreadyExistingErrorMessageDisplayed() {
        return alreadyExistingErrorMessage.isDisplayed();
    }

    public void escapeFromTheDriver() {
        driver.quit();
    }


    public String getTitle() {
       return driver.getTitle();
    }


}
