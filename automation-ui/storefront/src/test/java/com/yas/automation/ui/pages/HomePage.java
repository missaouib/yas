package com.yas.automation.ui.pages;

import static com.yas.automation.ui.ultil.WebElementUtil.getWebElementBy;

import com.yas.automation.ui.hook.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class HomePage {
    private final WebDriverFactory webDriverFactory;

    public HomePage(WebDriverFactory webDriverFactory) {
        this.webDriverFactory = webDriverFactory;
    }

    public void clickLogin() {
        WebElement loginBtn = getWebElementBy(webDriverFactory.getChromeDriver(), How.LINK_TEXT, "Login");
        loginBtn.click();
    }
}
