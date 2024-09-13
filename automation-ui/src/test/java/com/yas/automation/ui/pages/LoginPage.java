package com.yas.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {
    @FindBy(how = How.ID, using = "username")
    public WebElement txtUserName;

    @FindBy(how = How.ID, using = "password")
    public WebElement txtPassword;

    @FindBy(how = How.CLASS_NAME, using = "submit")
    public WebElement loginBtn;

    public void login(String username, String password) {
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
    }

    @Autowired
    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void clickLogin() {

        loginBtn.click();
    }
}
