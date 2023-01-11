package com.resumelibrary.admintest.misc;

import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiscPage extends Utility {

    public MiscPage() {
        PageFactory.initElements(getThreadDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(MiscPage.class);

    @FindBy(name = "username")
    WebElement UserName;
    @FindBy(name = "password")
    WebElement Password;
    @FindBy(id = "loginButton")
    WebElement LoginButton;
    @FindBy(id = "partner-type")
    WebElement PartnerType;
    @FindBy(id = "region_select")
    WebElement State;
    @FindBy(id = "salary_time_period")
    WebElement SalaryTimePeriod;
    @FindBy(id = "job_type")
    WebElement JobType;
    @FindBy(id = "state")
    WebElement JobStatus;
    @FindBy(id = "apply_api_type")
    WebElement ATSApply;
    @FindBy(id = "account_type")
    WebElement AccountType;
    @FindBy(id = "sector")
    WebElement Sector;
    @FindBy(id = "apply_type")
    WebElement applyType;
    @FindBy(xpath = "//*[@id=\"candidate_unlock_spend_type\"]")
    WebElement candiateUnlock;
    @FindBy(xpath = "//*[contains(text(),'Product Details')]/button")
    WebElement editButton;

    public void loginAsAdminUser() {
        loadAdminHomePage();
        UserName.sendKeys(DataHelper.getAdminUsername());
        Password.sendKeys(DataHelper.getAdminPassword());
        clickOnElementWithJS(LoginButton);
    }

    public void selectOptionFromField(String option, String field) {
        switch (field) {
            case "Partner Type":
                selectByVisibleTextFromDropDown(PartnerType, option);
                break;
            case "State":
                selectByVisibleTextFromDropDown(State, option);
                break;
            case "Job Type":
                selectByVisibleTextFromDropDown(JobType, option);
                break;
            case "Salary Time Period":
                selectByVisibleTextFromDropDown(SalaryTimePeriod, option);
                break;
            case "Status":
                if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
                    waitFor(1);
                }
                selectByVisibleTextFromDropDown(JobStatus, option);
                break;
            case "ATS Apply":
                selectByVisibleTextFromDropDown(ATSApply, option);
                break;
            case "Account Type":
                selectByVisibleTextFromDropDown(AccountType, option);
                break;
            case "Sector":
                if (getBrowserName().contains("firefox") || getBrowserName().contains("remoteFirefoxBrowser")) {
                    waitFor(1);
                }
                selectByVisibleTextFromDropDown(Sector, option);
                break;
            case "Apply Type":
                selectByVisibleTextFromDropDown(applyType, option);
                break;
        }
    }

    public void updateCandidateUnlock() {
        logger.info("Update account details as CLIENT in Admin Page");
        if (verifyThatElementIsDisplayed(editButton)) {
            clickOnElement(editButton);
        }
        selectByVisibleText(candiateUnlock, "CLIENT");
        clickOnElementUsingText("Save Changes");
    }
}