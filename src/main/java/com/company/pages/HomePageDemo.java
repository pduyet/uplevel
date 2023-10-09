package com.company.pages;

import org.openqa.selenium.By;

public class HomePageDemo {
    public static By LOGIN_LINK = By.xpath("//a[normalize-space()='Log in']");

    public static By BOOK_TAB = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']");

    public static By DIGITAL_DOWNLOADS_TAB = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Digital downloads']");

    public static By MESSAGE_ADD_TO_CART_SUCCESSFULLY = By.xpath("//p[@class='content']");

    public static By ICON_CLOSE = By.xpath("//span[@title='Close']");

    public static By SHOPPING_CART = By.xpath("//span[normalize-space()='Shopping cart']");

}
