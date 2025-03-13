package org.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HooksCucumber {

    private static WebDriver driver;

    @Before(order = 0)
    public void setUpDriver() {
        System.out.println("HooksCucumber setUpDriver start");

        if (driver != null) {
            System.out.println("driver already inicialised");
            return;
        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        System.out.println(driver.getTitle());

        System.out.println("Everything success around the driver setup");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        if(driver == null) {
        }
        return driver;
    }

}
