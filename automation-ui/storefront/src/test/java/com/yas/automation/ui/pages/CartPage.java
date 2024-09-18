package com.yas.automation.ui.pages;

import static com.yas.automation.ui.ultil.WebElementUtil.getWebElementBy;

import com.yas.automation.ui.hook.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Component
public class CartPage extends BasePage {
    private final WebDriverFactory webDriverFactory;

    public CartPage(WebDriverFactory webDriverFactory) {
        super(webDriverFactory.getChromeDriver());
        this.webDriverFactory = webDriverFactory;
    }

    public boolean checkProductName(String productName) {
        this.wait(Duration.ofSeconds(1));
        // Locate the table body containing the products
        WebElement tableBody = getWebElementBy(webDriverFactory.getChromeDriver(), How.XPATH, "//div[@class='shop__cart__table']//tbody");

        // Get all rows (tr) inside the table body
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));

        // Loop through each row and get the product name
        for (WebElement row : rows) {
            // Get the product title in the current row
            WebElement productTitleElement = row.findElement(By.xpath(".//h6[@class='product-link']"));
            String productTitle = productTitleElement.getText();
            if (Objects.nonNull(productTitle) && productTitle.equals(productName)) {
                return true;
            }
        }
        return false;
    }

}

