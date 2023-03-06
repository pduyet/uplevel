package com.company.microservices.pages;

import com.company.Utils.BaseWebUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseWebUI {

    public LoginPage() {
        super();
    }

    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement btnClick;

    @Step("Login to the system")
    public void loginWithCredentials(String user, String pass) {
        sendKeys(userName, user);
        sendKeys(password, pass);
        clickElement(btnClick);
    }
}
