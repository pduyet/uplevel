package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import org.testng.Assert;

import static com.company.pages.HomePageDemo.LOGIN_LINK;

public class HomePageDemoSteps extends BaseWebUI {

    public void goToHomePage() {
        visitWebsite("https://demowebshop.tricentis.com/");
        Assert.assertTrue(elementIsPresent(LOGIN_LINK));
    }

    public void clickLogin() {
        clickElement(LOGIN_LINK);
    }
}
