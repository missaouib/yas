package com.yas.automation.ui.pages;

import com.yas.automation.ui.hook.WebDriverFactory;
import com.yas.automation.ui.page.BasePage;
import com.yas.automation.ui.service.InputDelegateService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewCategoryPage extends BasePage {

    private final WebDriverFactory webDriverFactory;

    private final InputDelegateService inputDelegateService;

    public NewCategoryPage(WebDriverFactory webDriverFactory,
                        InputDelegateService inputDelegateService) {
        super(webDriverFactory);
        this.webDriverFactory = webDriverFactory;
        this.inputDelegateService = inputDelegateService;
    }

    public void fillInAllNecessaryField() {
        WebElement createCategoryButton = webDriverFactory.getChromeDriver().findElement(By.cssSelector("a[href='/catalog/categories/create'] button"));
        createCategoryButton.click();
    }

}
