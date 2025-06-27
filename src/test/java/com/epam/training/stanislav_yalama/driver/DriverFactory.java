package com.epam.training.stanislav_yalama.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if(driverThreadLocal.get() != null)  {
            return driverThreadLocal.get();
        } else {
            String browser = System.getProperty("browser");

            WebDriver driver = switch(browser.toLowerCase()) {
                case "firefox" -> new FirefoxDriver();
                case "edge" -> new EdgeDriver();
                case "chrome" -> new ChromeDriver();
                default -> throw new RuntimeException("Unsupported browser: " + browser);
            };
            driverThreadLocal.set(driver);

            return driverThreadLocal.get();
        }
    }

    public static void quitDriver() {
        if(driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
