package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import org.testng.Assert;

import static com.company.pages.LoginPageDemo.*;

public class LoginPageDemoSteps extends BaseWebUI {

    public void verifyNavigateToLoginPageSuccessfully() {
        Assert.assertTrue(elementIsPresent(EMAIL_FIELD));
    }
    public void fillInCredentials(String email, String password) {
        sendKeys(EMAIL_FIELD, email);
        sendKeys(PASSWORD_FIELD, password);
        clickElement(LOGIN_BUTTON);
    }

    public void verifyMessage(String expectedMessage) {
        Assert.assertTrue(elementIsPresent(replaceValueInXpath(EXPECTED_MSG, "message", expectedMessage)));
    }
}
