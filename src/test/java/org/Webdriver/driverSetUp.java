package org.Webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class driverSetUp {

    // létrehozzuk a webdrivert, amit minden példány esetén és tesztlefutásnál megtesz majd a program
            protected WebDriver driver;

            public void getWebdriver() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://automationexercise.com/login");

                // implicit wait, mindentől függetlenül vár annyi secundumig amennyit megadunk
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }

            public void tearDown() {
                if (driver != null) {
                    driver.quit();
                }
            }
        }
