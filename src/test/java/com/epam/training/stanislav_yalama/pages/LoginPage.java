package com.epam.training.stanislav_yalama.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private static String BASE_URL = "https://www.saucedemo.com";

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
        return this;
    }

    public LoginPage insertUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage insertPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clearUsernameInput() {
        usernameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        return this;
    }

    public LoginPage clearPasswordInput() {
        passwordInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
