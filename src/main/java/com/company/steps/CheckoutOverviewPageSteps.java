package com.company.steps;

import com.company.utils.BaseWebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.company.pages.CheckoutOverviewPage.*;

public class CheckoutOverviewPageSteps extends BaseWebUI {

    @Step("Verify navigate to checkout overview page successfully")
    public CheckoutOverviewPageSteps verifyNavigateToCheckoutOverviewPageSuccessfully() {
        Assert.assertTrue(elementIsPresent(HEADING_CHECKOUT_OVERVIEW), "Navigate to checkout overview page page unsuccessfully");
        return this;
    }

    @Step("Click button finish to navigate to complete order page")
    public void navigateToCompleteOrderPage() {
        clickElement(BTN_FINISH);
    }
}
