package com.epam.training.stanislav_yalama.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com.epam.training.stanislav_yalama.resources")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.epam.training.stanislav_yalama.stepdefs")
public class CucumberTestRunner {
}