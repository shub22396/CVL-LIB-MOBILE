package com.resumelibrary.cucumber.stepdefinitions.admin.misc;

import com.resumelibrary.admintest.misc.MiscPage;
import com.resumelibrary.utilities.AdminURLHelper;
import com.resumelibrary.utilities.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class Misc extends Utility {
    public Misc() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(Misc.class);

    @Given("I login as an admin user")
    public void iLoginAsAnAdminUser() {
        new MiscPage().loginAsAdminUser();
    }

    @And("I select the option {string} from {string} field")
    public void iSelectTheOptionFromField(String option, String field) {
        new MiscPage().selectOptionFromField(option, field);
    }

    @When("I am on admin page {string}")
    public void iAmOnAdminPage(String url) {
        logger.info("Web page url to load is : " + AdminURLHelper.getAdminUrl() + getURL(url));
        getDriverWithUrl(AdminURLHelper.getAdminUrl(), getURL(url));
        webDriverWaitContainsUrl(getURL(url));
    }
}