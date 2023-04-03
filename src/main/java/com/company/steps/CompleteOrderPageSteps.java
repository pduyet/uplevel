package com.company.steps;

import com.company.Report.AllureManager;
import com.company.Utils.BaseWebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.company.pages.CompleteOrderPage.*;

public class CompleteOrderPageSteps extends BaseWebUI {

    @Step("Verify navigate to complete order page successfully")
    public CompleteOrderPageSteps verifyNavigateToCompleteOrderPageSuccessfully() {
        Assert.assertTrue(elementIsPresent(HEADING_CHECKOUT_COMPLETE), "Navigate to complete order page unsuccessfully");
        AllureManager.takeScreenshotToAttachOnAllureReport();
        return this;
    }

    @Step("Click button back to home to navigato to home page")
    public void backToHomePage() {
        clickElement(BTN_BACK_HOME);
    }
}
