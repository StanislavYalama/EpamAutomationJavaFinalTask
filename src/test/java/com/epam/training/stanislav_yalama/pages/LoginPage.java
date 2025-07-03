package com.epam.training.stanislav_yalama.pages;

import com.epam.training.stanislav_yalama.stepdefs.LoginStepDefinition;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private final WebDriver driver;
    private static String BASE_URL = "https://www.saucedemo.com";
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage openPage() {
        driver.navigate().to(BASE_URL);
        log.info("Login page is opened");

        return this;
    }

    public LoginPage enterUsername(String username) {
        usernameInput.sendKeys(username);
        log.info("Username and password was entered");

        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        log.info("Password was entered");

        return this;
    }

    public LoginPage clearUsernameInput() {
        usernameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        log.info("Username input was cleared");

        return this;
    }

    public LoginPage clearPasswordInput() {
        passwordInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        log.info("Password input was cleared");

        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        log.info("Login button was clicked");

        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
