package com.resumelibrary.admintest.account;

import com.resumelibrary.utilities.AdminURLHelper;
import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage extends Utility {

    public AccountPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(AccountPage.class);

    @FindBy(id = "search")
    WebElement NavigationBarSearchField;
    @FindBy(id = "search_type")
    WebElement NavigationBarSearchTypeField;
    @FindBy(id = "nav-bar-search-btn")
    WebElement NavigationBarSearchButton;
    @FindBy(id = "update_account")
    WebElement UpdateAccount;
    @FindBy(id = "disable_ecomm")
    WebElement DisableEcommerce;
    @FindBy(xpath = "//div[contains(text(),'Product Details')]/child::button")
    WebElement EditProductDetails;
    @FindBy(id = "actions-btn")
    WebElement ActionBtn;
    @FindBy(className = "mobile-menu-trigger")
    WebElement MobileMenuTrigger;

    public void searchForInTheNavigationBar(String text) {
        waitUntilElementToBeClickable(NavigationBarSearchField, 5);
        NavigationBarSearchField.sendKeys(text);
        logger.info("Searched email address --> : " + text);
        selectByValueFromDropDown(NavigationBarSearchTypeField, "accounts");
        clickOnElementWithJS(NavigationBarSearchButton);
    }

    public void clickOnUpdateAccount() {
        logger.info("Clicking on update account");
        clickOnElementWithJS(UpdateAccount);
    }

    public void selectDisableEcommerceFromDropdown(String reason) {
        logger.info("Selected Disable Ecommerce from list " + reason);
        selectByVisibleTextFromDropDown(DisableEcommerce, reason);
    }

    public void clickOnEditProductDetails() {
        logger.info("Clicking on Edit button");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(EditProductDetails);
    }

    public void clickOnActionButton() {
        logger.info("Clicking on action account button ");
        if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
            waitFor(2);
        }
        clickOnElement(ActionBtn);
    }

    public void clickOnMenu() {
        logger.info("Clicking on menu ");
        clickOnElementWithJS(MobileMenuTrigger);
        waitFor(2);
    }
}