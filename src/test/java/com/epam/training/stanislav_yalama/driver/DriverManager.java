//package com.epam.training.stanislav_yalama.driver;
//
//import org.openqa.selenium.WebDriver;
//
//public class DriverManager {
//    private static final ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(DriverFactory::getDriver);
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//
//    public static void quitDriver() {
//        driver.get().quit();
//        driver.remove();
//    }
//}
