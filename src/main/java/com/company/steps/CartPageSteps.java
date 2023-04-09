package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.company.pages.CartPage.*;

public class CartPageSteps extends BaseWebUI {

    @Step("Verify navigate to cart page successfully")
    public CartPageSteps verifyNavigateToCartPageSuccessfully() {
        Assert.assertTrue(elementIsPresent(HEADING_YOUR_CART), "Navigate to cart page unsuccessfully");
        return this;
    }

    @Step("Click button checkout to navigate to checkout your information page")
    public void navigateToCheckoutYourInformation() {
        clickElement(BTN_CHECKOUT);
    }
}
