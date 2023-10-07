package com.company.pages;

import org.openqa.selenium.By;

public class LoginPageDemo {
    public static By EMAIL_FIELD = By.id("Email");
    public static By PASSWORD_FIELD = By.id("Password");

    public static By LOGIN_BUTTON = By.xpath("//input[@value='Log in']");

    public static String EXPECTED_MSG = "//*[.='message']";

}
