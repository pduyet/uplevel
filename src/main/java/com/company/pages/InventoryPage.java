package com.company.pages;

import org.openqa.selenium.By;

public class InventoryPage {

    public static By TABLE_PRODUCTS = By.id("inventory_container");
    public static By LIST_PRICE = By.xpath("//div[@class='inventory_item_price']");
    public static String BTN_ADDTOCART = "//div[text()='price']/../button";
    public static String PRODUCT_NAME = "//div[text()='price']/../..//a/div";
    public static By BADGE_SHOPPING_CART = By.xpath("//span[@class='shopping_cart_badge']");
    public static By SHOPPING_CART_CONTAINER = By.id("shopping_cart_container");
}
