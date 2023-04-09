package com.company.steps;

import com.company.constant.Constants;
import com.company.core.basehandle.BaseWebUI;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.company.pages.LoginPage.*;

public class LoginPageSteps extends BaseWebUI {

    @Step("Go to : {0}")
    public LoginPageSteps goToUrl(String url) {
        visitWebsite(url);
        return this;
    }

    @Step("Verify title")
    public LoginPageSteps verifyTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(Constants.titleLoginPage));
        return this;
    }

    @Step("Login to the system")
    public void loginWithCredentials(String user, String pass) {
        sendKeys(USERNAME_FIELD, user);
        sendKeys(PASSWORD_FIELD, pass);
        clickElement(LOGIN_BTN);
    }
}
