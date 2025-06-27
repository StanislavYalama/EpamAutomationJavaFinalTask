Task description

Launch URL: https://www.saucedemo.com/

<b>UC-1</b> Test Login form with empty credentials:

    Type any credentials into "Username" and "Password" fields.

    Clear the inputs.
    
    Hit the "Login" button.
    
    Check the error messages: "Username is required".

<b>UC-2</b> Test Login form with credentials by passing Username:

    Type any credentials in username.

    Enter password.
    
    Clear the "Password" input.
    
    Hit the "Login" button. 

    Check the error messages: "Password is required".

<b>UC-3</b> Test Login form with credentials by passing Username & Password:

    Type credentials in username which are under Accepted username are sections.
    
    Enter password as secret sauce.

    Click on Login and validate the title “Swag Labs” in the dashboard.

Provide parallel execution, add logging for tests and use Data Provider to parametrize tests. Make sure that all tasks are supported by these 3 conditions: UC-1; UC-2; UC-3.   

Please, add task description as README.md into your solution!

<b>To perform the task use the various of additional options:</b>

    Test Automation tool: Selenium WebDriver;
    Project Builder: Maven;
    Browsers: 1) Firefox; 2) Edge;
    Locators: XPath;
    Test Runner: JUnit;
    [Optional] Patterns: Singleton; 2) Factory method; 3) Abstract Factory;
    [Optional] Test automation approach: BDD;
    Assertions: AssertJ;
    [Optional] Loggers: SLF4J .