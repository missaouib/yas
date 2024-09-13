package com.yas.automation.ui.hook;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {
    @Autowired
    private WebDriver driver;

    @After
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();  // Reset the WebDriver after each scenario
        }
    }
}
