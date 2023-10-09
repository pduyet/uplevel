package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import org.testng.Assert;

import static com.company.pages.CheckAsGuestPage.*;

public class CheckAsGuestPageSteps extends BaseWebUI {

    public void navigateToCheckAsGuestSuccessfully() {
        waitForElementIsPresence(CHECK_AS_GUEST_BUTTON, 5);
        Assert.assertTrue(elementIsPresent(CHECK_AS_GUEST_BUTTON));
    }

    public void clickCheckAsGuest() {
        clickElement(CHECK_AS_GUEST_BUTTON);
    }
}
