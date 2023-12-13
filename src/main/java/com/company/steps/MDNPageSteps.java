package com.company.steps;

import com.company.core.basehandle.BaseWebUI;

import static com.company.pages.MDNPage.JoshuaChen;

public class MDNPageSteps extends BaseWebUI {

    public void goToWebMDN() {
        visitWebsite("https://developer.mozilla.org/en-US/blog/regular-expressions-reference-updates/");
    }
    public void clickToJoshuaChen() {
        waitForElementIsPresence(JoshuaChen, 10);
        clickElement(JoshuaChen);
    }

    public void switchToParentPage() {
        switchToNewTab();
    }
}
