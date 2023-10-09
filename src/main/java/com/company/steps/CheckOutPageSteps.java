package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import org.testng.Assert;

import static com.company.pages.CheckOutPage.*;

public class CheckOutPageSteps extends BaseWebUI {
    public void navigateToCheckOutPageSuccessfully() {
        waitForElementIsPresence(BILLING_ADDRESS, 5);
        Assert.assertTrue(elementIsPresent(BILLING_ADDRESS));
    }

    public void fillInInformation() {
        sendKeys(FIRSTNAME, "ABC");
        sendKeys(LASTNAME, "ABC");
        sendKeys(EMAIL, "yo@most.com");
        selectByValue(COUNTRY, "Guatemala");
        sendKeys(CITY, "HN");
        sendKeys(ADDRESS, "HN");
        sendKeys(ZIP, "100000");
        sendKeys(PHONE, "0123456789");
        clickElement(CONTINUE_BUTTON);
    }

    public void navigateToPaymentMethodSuccessfully() {
        waitForElementIsPresence(PAYMENT_METHOD, 5);
        Assert.assertTrue(elementIsPresent(PAYMENT_METHOD));
    }

    public void getPaymentMethod() {
        String value = getTextElement(METHOD);
        System.out.println(value);
    }
}
