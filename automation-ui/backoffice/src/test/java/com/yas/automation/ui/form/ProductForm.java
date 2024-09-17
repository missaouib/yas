package com.yas.automation.ui.form;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ProductForm extends BaseForm {

    @FindBy(how = How.ID, using = "name")
    private WebElement name;

    @FindBy(how = How.ID, using = "price")
    private WebElement price;

    @FindBy(how = How.ID, using = "sku")
    private WebElement sku;

    @FindBy(how = How.ID, using = "gtin")
    private WebElement gtin;

    @FindBy(how = How.ID, using = "select-option-brandId")
    private WebElement brand;

    @FindBy(how = How.ID, using = "isFeatured")
    private WebElement isFeatured;

    @FindBy(how = How.ID, using = "select-option-taxClassId")
    private WebElement tax;

    @FindBy(how = How.CLASS_NAME, using = "ql-editor")
    private WebElement description;

    @FindBy(id = "shortDescription")
    private WebElement shortDescription;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Create')]")
    private WebElement createBtn;

    @FindBy(xpath = "//button[@type='button' and contains(text(),'Product Images')]")
    private WebElement productImgNav;

    @FindBy(how = How.ID, using = "main-thumbnail")
    private WebElement thumbnail;

    @FindBy(how = How.ID, using = "main-product-images")
    private WebElement image;

    public ProductForm(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public WebElement getSubmitBtn() {
        return createBtn;
    }
}
