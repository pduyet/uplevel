package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import org.testng.Assert;

import static com.company.pages.ShoppingCartPage.*;

public class ShoppingCartPgeSteps extends BaseWebUI {
    public void navigateToShoppingCartSuccessfully() {
        waitForElementIsPresence(SHOPPING_CART_PAGE, 5);
        Assert.assertTrue(elementIsPresent(SHOPPING_CART_PAGE), "Navigate to Shopping cart unsuccessfully");
    }

    public void checkTermOfService() {
        Assert.assertFalse(elementIsChecked(CHECKBOX_TERM_OF_SERVICE));
        clickElement(CHECKBOX_TERM_OF_SERVICE);
        Assert.assertTrue(elementIsChecked(CHECKBOX_TERM_OF_SERVICE));
    }

    public void clickCheckOut() {
        clickElement(BUTTON_CHECKOUT);
    }
}
