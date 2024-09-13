package com.yas.automation.ui.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage {

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement loginLink;

    @Autowired
    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public  void clickLogin() {
        loginLink.click();
    }

}
