package org.cucumber.Helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Navigation {

    private WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTheElement (WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void scrollToTheBottomTop(WebDriver driver, String direction) {
        if ("bottom".equalsIgnoreCase(direction)) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }
        if ( "top".equalsIgnoreCase(direction)) {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        }

    }
}
