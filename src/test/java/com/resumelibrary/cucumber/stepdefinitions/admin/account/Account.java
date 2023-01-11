package com.resumelibrary.cucumber.stepdefinitions.admin.account;

import com.resumelibrary.admintest.account.AccountPage;
import com.resumelibrary.utilities.Utility;
import io.cucumber.java.en.And;

public class Account extends Utility {

    @And("I click on update account")
    public void iClickOnUpdateAccount() {
        new AccountPage().clickOnUpdateAccount();
    }

    @And("I select Disable Ecomm {string}")
    public void iSelectDisableEcomm(String reason) {
        new AccountPage().selectDisableEcommerceFromDropdown(reason);
    }

    @And("I click on product details Edit button")
    public void iClickOnProductDetailsEditButton() {
        new AccountPage().clickOnEditProductDetails();
    }

    @And("I click on actions btn")
    public void iClickOnActionsBtn() {
        new AccountPage().clickOnActionButton();
    }

    @And("I click on menu")
    public void iClickOnMenu() {
        new AccountPage().clickOnMenu();
    }
}