package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import org.testng.Assert;
import org.testng.AssertJUnit;

import static com.company.pages.HomePageDemo.*;

public class HomePageDemoSteps extends BaseWebUI {

    public void goToHomePage() {
        visitWebsite("https://demowebshop.tricentis.com/");
        Assert.assertTrue(elementIsPresent(LOGIN_LINK));
    }
    public void clickLogin() {
        clickElement(LOGIN_LINK);
    }

    public void clickBookTab() {
        clickElement(BOOK_TAB);
    }

    public void clickDigitalDownloads() {
        clickElement(DIGITAL_DOWNLOADS_TAB);
    }

    public void addCartSuccessfully() {
        waitForElementIsPresence(MESSAGE_ADD_TO_CART_SUCCESSFULLY, 5);
        Assert.assertTrue(elementIsPresent(MESSAGE_ADD_TO_CART_SUCCESSFULLY));
        clickElement(ICON_CLOSE);
        waitForElementIsNotPresence(MESSAGE_ADD_TO_CART_SUCCESSFULLY, 5);
//        Assert.assertFalse(elementIsPresent(MESSAGE_ADD_TO_CART_SUCCESSFULLY));
    }

    public void clickShoppingCart() {
        clickElement(SHOPPING_CART);
    }
}
