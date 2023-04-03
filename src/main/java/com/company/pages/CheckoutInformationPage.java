package com.company.pages;

import org.openqa.selenium.By;

public class CheckoutInformationPage {
    public static By HEADING_CHECK_YOUR_INFORMATION = By.xpath("//span[@class='title']");
    public static By FIRSTNAME = By.id("first-name");
    public static By LASTNAME = By.id("last-name");
    public static By ZIP = By.id("postal-code");
    public static By BTN_CONTINUE = By.id("continue");
}
