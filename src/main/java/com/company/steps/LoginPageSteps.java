package com.company.steps;

import com.company.Utils.BaseWebUI;
import io.qameta.allure.Step;

import static com.company.pages.LoginPage.*;

public class LoginPageSteps extends BaseWebUI {

    @Step("Login to the system")
    public void loginWithCredentials(String user, String pass) {
        sendKeys(USERNAME_FIELD, user);
        sendKeys(PASSWORD_FIELD, pass);
        clickElement(LOGIN_BTN);
    }
}
