package com.yas.automation.ui.pages;

import com.yas.automation.ui.form.InputType;
import com.yas.automation.ui.form.ProductForm;
import com.yas.automation.ui.hook.WebDriverFactory;
import com.yas.automation.ui.service.InputDelegateService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.yas.automation.ui.util.WebElementUtil.getWebElementBy;

@Component
public class ProductPage extends BasePage {

    private final WebDriverFactory webDriverFactory;
    private final InputDelegateService inputDelegateService;

    public ProductPage(WebDriverFactory webDriverFactory, InputDelegateService inputDelegateService) {
        super(webDriverFactory.getChromeDriver());
        this.webDriverFactory = webDriverFactory;
        this.inputDelegateService = inputDelegateService;
    }

    public void clickToCreateProductBtn() {
        WebElement createProductLink = getWebElementBy(
                webDriverFactory.getChromeDriver(),
                How.CSS,
                "a[href='/catalog/products/create']"
        );
        createProductLink.click();
    }

    public void fillProductData() {
        ProductForm productForm = new ProductForm(webDriverFactory.getChromeDriver());
        inputDelegateService.setInputValue(InputType.TEXT, productForm.getName(), String.format("test-%s", UUID.randomUUID()));
        inputDelegateService.setInputValue(InputType.TEXT, productForm.getPrice(), "10000");
        inputDelegateService.setInputValue(InputType.TEXT, productForm.getSku(), UUID.randomUUID().toString());
        inputDelegateService.setInputValue(InputType.DROPDOWN, productForm.getBrand(), "Apple");
        inputDelegateService.setInputValue(InputType.DROPDOWN, productForm.getTax(), "Value Added Tax (VAT)");
        this.scrollTo(productForm.getCreateBtn());
        productForm.submitForm();
    }

}
