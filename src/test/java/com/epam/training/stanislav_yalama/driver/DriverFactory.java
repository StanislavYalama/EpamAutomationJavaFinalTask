package com.epam.training.stanislav_yalama.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if(driver.get() == null) {
            String browser = System.getProperty("browser", "firefox");

            WebDriver newDriver = switch (browser.toLowerCase()) {
                case "firefox" -> new FirefoxDriver();
                case "edge" -> new EdgeDriver();
                case "chrome" -> new ChromeDriver();
                default -> throw new RuntimeException("Unsupported browser: " + browser);
            };

            driver.set(newDriver);
        }

        return driver.get();
    }

    public static void quitDriver() {
        WebDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.quit();
            driver.remove();
        }
    }
}

