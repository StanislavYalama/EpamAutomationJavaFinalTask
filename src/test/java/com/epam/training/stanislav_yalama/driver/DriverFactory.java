package com.epam.training.stanislav_yalama.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver != null)  {
            return driver;
        } else {
            String browser = System.getProperty("browser", "firefox");

            return driver = switch(browser.toLowerCase()) {
                case "firefox" -> new FirefoxDriver();
                case "edge" -> new EdgeDriver();
                case "chrome" -> new ChromeDriver();
                default -> throw new RuntimeException("Unsupported browser: " + browser);
            };
        }
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
