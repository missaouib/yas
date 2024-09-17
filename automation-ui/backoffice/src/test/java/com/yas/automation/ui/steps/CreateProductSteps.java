package com.yas.automation.ui.steps;

import com.yas.automation.ui.form.ProductForm;
import com.yas.automation.ui.hook.WebDriverFactory;
import com.yas.automation.ui.pages.HomePage;
import com.yas.automation.ui.pages.ProductPage;
import com.yas.automation.ui.service.AuthenticationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

import static org.junit.Assert.assertTrue;

@AllArgsConstructor
public class CreateProductSteps {

    private final HomePage homePage;
    private final ProductPage productPage;
    private final WebDriverFactory webDriverFactory;
    private final AuthenticationService authenticationService;

    @Given("I logged in successfully")
    public void i_should_be_logged_in_successfully() {
        authenticationService.authorizeWithAdminUser();
    }

    @When("I click to product on menu")
    public void i_should_click_to_product_on_menu() {
        homePage.clickToCatalogItem("products");
    }

    @Then("I should be in product list page")
    public void i_should_be_in_product_list_page() {
        String currentUrl = webDriverFactory.getChromeDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("/catalog/products"));
    }

    @When("I click to create product button")
    public void i_should_click_to_create_product_button() {
        productPage.clickToCreateProductBtn();
    }

    @Then("I should be in create product page")
    public void i_should_be_in_create_product_page() {
        String currentUrl = webDriverFactory.getChromeDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("/catalog/products/create"));
    }

    @Given("I fill necessary data for product and submit")
    public void i_should_fill_necessary_data_for_product() {
        ProductForm productForm = new ProductForm(webDriverFactory.getChromeDriver());

        // create product data
        productPage.fillGeneralProductData(productForm);
        productPage.uploadProductImg(productForm);

        // submit form
        productPage.scrollTo(productForm.getSubmitBtn());
        productForm.submitForm();
    }

}
