package com.yas.automation.ui;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.yas.automation.ui",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
