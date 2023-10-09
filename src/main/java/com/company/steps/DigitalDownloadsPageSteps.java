package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import org.testng.Assert;

import static com.company.pages.DigitalDownloadsPage.*;

public class DigitalDownloadsPageSteps extends BaseWebUI {

    public void navigateToDigitalDownloadsSuccessfully() {
        waitForElementIsPresence(BREADCRUMB_DD, 5);
        Assert.assertTrue(elementIsPresent(BREADCRUMB_DD), "Navigate to Digital Download unsuccessfully");
    }

    public void buyItem() {
        clickElement(ITEM);
    }
}
