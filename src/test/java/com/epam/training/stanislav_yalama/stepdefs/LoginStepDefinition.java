package com.epam.training.stanislav_yalama.stepdefs;

import com.epam.training.stanislav_yalama.driver.DriverFactory;
import com.epam.training.stanislav_yalama.pages.LoginPage;
import com.epam.training.stanislav_yalama.utils.LoggerManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class LoginStepDefinition {
    private LoginPage loginPage;
    private static final Logger log = LoggerManager.getLogger();

    @Before
    public void setup() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @Given("Login page is opened")
    public void login_page_is_opened() {
        loginPage.openPage();
        log.info("Login page is opened");
    }
    @When("Enter username as {string} and password as {string}")
    public void enterUsernameAsAndPasswordAs(String username, String password) {
        loginPage
                .insertUsername(username)
                .insertPassword(password);

        log.info("Username and password was entered");
    }
    @And("Clear the username inputs")
    public void clearTheUsernameInputs() {
        loginPage.clearUsernameInput();
        log.info("Username input was cleared");
    }
    @And("Clear the password input")
    public void clearThePasswordInput() {
        loginPage.clearPasswordInput();
        log.info("Password input was cleared");
    }
    @And("Hit the Login button")
    public void hitTheLoginButton() {
        loginPage.clickLoginButton();
        log.info("Login button was clicked");
    }
    @Then("I should receive message {string}")
    public void i_should_receive_message(String expectedErrorMessage) {
        Assertions.assertTrue(
                loginPage.getErrorMessage().contains(expectedErrorMessage)
        );
        log.info("Error message:\n" + loginPage.getErrorMessage() + "\nshould contain:\n" + expectedErrorMessage + "\n");
    }

    @Then("Page title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        Assertions.assertEquals(loginPage.getTitle(), expectedTitle);
        log.info("Current title:\n" + loginPage.getTitle() + "\nshould be:\n" + expectedTitle + "\n");
    }

    @After
    public void shutdownBrowser() {
        DriverFactory.quitDriver();
    }
}
