package org.Pages;

import org.Helper.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class LoginPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
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

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginSignupButton;

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
       return menu.findElements(By.xpath(".//li/a"));
    }

    public void selectAnOptionFromMenu(String href) {
        List<WebElement> items = menuItems();
        for (WebElement item : items) {
            if(Objects.equals(item.getAttribute("href"), href)) {
                item.click();
            }
        }
    }


    public void clickOnLoginSignupButton() {
        loginSignupButton.click();
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

    public boolean isWrongLoginMessageAppears() {
        return wrongLoginMessage.isDisplayed();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void acceptCookie() {
        cookieConsentButton.click();
    }

    public void clickOnContactBtn() {
        contactUsButton.click();
    }


    public void loginHappyPath() {
        acceptCookie();
        clickOnLoginSignupButton();
        fillEmailAddress();
        fillPassword();
        clickLogin();
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

    public void clickOnlogin_signupButton() {
        loginSignupButton.click();
    }

    public boolean isAlreadyExistingErrorMessageDisplayed() {
        return alreadyExistingErrorMessage.isDisplayed();
    }
}
