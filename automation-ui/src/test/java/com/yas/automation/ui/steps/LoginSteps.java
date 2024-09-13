package com.yas.automation.ui.steps;

import com.yas.automation.ui.pages.HomePage;
import com.yas.automation.ui.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private final HomePage homePage;

    private final LoginPage loginPage;

    private final WebDriver webDriver;

    @Value("${test.cucumber.homeUrl}")
    private String homePageUrl;

    @Autowired
    public LoginSteps(HomePage homePage, LoginPage loginPage, WebDriver webDriver) {
        this.homePage = homePage;
        this.loginPage = loginPage;
        this.webDriver = webDriver;
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        // Set up WebDriver
        webDriver.navigate().to(homePageUrl); // Replace with your actual home page URL
    }

    @When("I click on the login link")
    public void i_click_on_the_login_link() {
        homePage.clickLogin();
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        // Verify that the current URL is the login page
        String currentUrl = webDriver.getCurrentUrl();
        assertTrue(currentUrl.contains("/login"));
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        String adminUsername = "admin";
        String adminPassword = "password";
        loginPage.login(adminUsername, adminPassword);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.of(10, ChronoUnit.SECONDS)); // 10 seconds wait
        WebElement userDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-dropdown")));
        //WebElement userDropdown = webDriver.findElement(By.id("user-dropdown"));
        String dropdownText = userDropdown.getText();

        // Assert to check if the correct text is present
        Assert.assertTrue("Check failed: User is not logged in as admin.", dropdownText.contains("Signed in as: admin"));
    }

    @When("I enter invalid credentials")
    public void i_enter_invalid_credentials() {
        String invalidUsername = "invalidAdmin";
        String invalidPassword = "invalidPassword";
        loginPage.login(invalidUsername, invalidPassword);
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.of(10, ChronoUnit.SECONDS)); // 10 seconds wait
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-error .message-text")));

        // Assert the text content of the error message
        String expectedMessage = "Invalid username or password.";
        String actualMessage = errorMessage.getText();
        Assert.assertEquals("The error message is not as expected.", expectedMessage, actualMessage);

        System.out.println("Test passed: Correct error message is displayed.");
    }
}
