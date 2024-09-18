package com.yas.automation.ui.steps;

import static org.junit.Assert.assertTrue;

import com.yas.automation.ui.hook.WebDriverFactory;
import com.yas.automation.ui.pages.CategoryPage;
import com.yas.automation.ui.pages.HomePage;
import com.yas.automation.ui.service.AuthenticationService;
import com.yas.automation.ui.util.WebElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCategorySteps {
    private final AuthenticationService authenticationService;
    private final WebDriverFactory webDriverFactory;
    private final HomePage homePage;
    private final CategoryPage categoryPage;

    public CreateCategorySteps(AuthenticationService authenticationService, WebDriverFactory webDriverFactory,
                               HomePage homePage, CategoryPage categoryPage) {
        this.authenticationService = authenticationService;
        this.webDriverFactory = webDriverFactory;
        this.homePage = homePage;
        this.categoryPage = categoryPage;
    }

//    @Given("I am logged in successfully")
//    public void i_am_logged_in_successfully() {
//        authenticationService.authorizeWithAdminUser();
//    }
//
//    @When("I click on the {string} option in the menu")
//    public void i_click_on_option_in_the_menu(String option) {
//        homePage.clickToCatalogItem(option);
//    }
//
//    @Then("I should be redirected to the category list page")
//    public void i_should_be_redirected_to_category_list_page() {
//        assertTrue(WebElementUtil.isCorrectUrl(webDriverFactory.getChromeDriver(), "http://backoffice/catalog/categories"));
//    }
//
//    @When("I click on the Create Category button")
//    public void i_click_on_button(String button) {
//        categoryPage.clickCreateCategoryButton();
//    }
//
//    @Then("I should be redirected to the create category page")
//    public void i_should_be_redirected_to_create_category_page() {
//        assertTrue(WebElementUtil.isCorrectUrl(webDriverFactory.getChromeDriver(), "http://backoffice/catalog/categories/create"));
//    }
//
//    @Given("I have filled in all the necessary data for the new category")
//    public void i_have_filled_in_all_the_necessary_data_for_new_category() {
//        //categoryPage.fillInAllNecessaryFields();
//    }
//
//    @When("I click the {string} button")
//    public void iClickTheButton(String arg0) {
//    }
//
//    @Then("I should be redirected to the category list page")
//    public void i_should_be_redirected_to_category_list_page_again() {
//        // Code to verify redirection back to the category list page after saving
//    }
//
//    @Then("the new category should be displayed in the category list")
//    public void the_new_category_should_be_displayed_in_the_category_list() {
//        // Code to check if the new category is visible in the category list
//        // Ecxample: Find the newly created category in the list
//    }
}

