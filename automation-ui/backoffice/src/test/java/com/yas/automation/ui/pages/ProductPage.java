package com.yas.automation.ui.pages;

import com.yas.automation.ui.form.InputType;
import com.yas.automation.ui.form.ProductForm;
import com.yas.automation.ui.hook.WebDriverFactory;
import com.yas.automation.ui.service.InputDelegateService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.UUID;

import static com.yas.automation.ui.util.WebElementUtil.getWebElementBy;

@Component
public class ProductPage extends BasePage {

    private final WebDriverFactory webDriverFactory;
    private final InputDelegateService inputDelegateService;

    public ProductPage(WebDriverFactory webDriverFactory, InputDelegateService inputDelegateService) {
        super(webDriverFactory);
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

    public void fillGeneralProductData(ProductForm productForm) {
        // General Information
        inputDelegateService.setInputValue(InputType.TEXT, productForm.getName(), String.format("Dell-%s", UUID.randomUUID()));
        inputDelegateService.setInputValue(InputType.TEXT, productForm.getPrice(), "100000000");
        inputDelegateService.setInputValue(InputType.TEXT, productForm.getSku(), UUID.randomUUID().toString());
        inputDelegateService.setInputValue(InputType.TEXT, productForm.getGtin(), UUID.randomUUID().toString());
        inputDelegateService.setInputValue(InputType.TEXT, productForm.getDescription(), UUID.randomUUID().toString());
        inputDelegateService.setInputValue(InputType.TEXT, productForm.getShortDescription(), UUID.randomUUID().toString());
        scrollTo(productForm.getIsFeatured());
        inputDelegateService.setInputValue(InputType.CHECKBOX, productForm.getIsFeatured(), null);
        inputDelegateService.setInputValue(InputType.DROPDOWN, productForm.getBrand(), "Apple");
        inputDelegateService.setInputValue(InputType.DROPDOWN, productForm.getTax(), "Value Added Tax (VAT)");
    }

    public void uploadProductImg(ProductForm productForm) {
        scrollTo(productForm.getProductImgNav());
        this.wait(Duration.ofSeconds(2));
        productForm.getProductImgNav().click();

        String filePath = "sampledata/images/dell.jpg";
        inputDelegateService.setInputValue(InputType.FILE, productForm.getImage(), filePath);
        inputDelegateService.setInputValue(InputType.FILE, productForm.getThumbnail(), filePath);
    }

}
