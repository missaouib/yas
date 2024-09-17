package com.yas.automation.ui.form;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public abstract class BaseForm {

    private WebDriver driver;

    private BaseForm() {}

    public BaseForm(WebDriver driver) {
        this.driver = driver;
    }

    public void submitForm() {
        getSubmitBtn().click();
    }

    public abstract WebElement getSubmitBtn();
}
