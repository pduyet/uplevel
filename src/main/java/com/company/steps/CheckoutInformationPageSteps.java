package com.company.steps;

import com.company.utils.BaseWebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.company.pages.CheckoutInformationPage.*;

public class CheckoutInformationPageSteps extends BaseWebUI {

    @Step("Verify navigate to checkout information page successfully")
    public CheckoutInformationPageSteps verifyNavigateToCheckoutInformationPageSuccessfully() {
        Assert.assertTrue(elementIsPresent(HEADING_CHECK_YOUR_INFORMATION), "Navigate to checkout your information page unsuccessfully");
        return this;
    }

    @Step("Fill your information")
    public CheckoutInformationPageSteps fillYourInformation() {
        sendKeys(FIRSTNAME, "test");
        sendKeys(LASTNAME, "test");
        sendKeys(ZIP, "100000");
        return this;
    }

    @Step("Click button continue to navigate to checkout overview page")
    public void navigateToCheckoutOverview() {
        clickElement(BTN_CONTINUE);
    }
}
