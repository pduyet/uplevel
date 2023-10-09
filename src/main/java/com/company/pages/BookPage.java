package com.company.pages;

import org.openqa.selenium.By;

public class BookPage {
    public static By BREADCRUMB = By.xpath("//div[@class='breadcrumb']");

    public static By ITEMS_WITH_ADD_TO_CART = By.xpath("//input[@value='Add to cart']/../../../..//div[@class='rating']/div");

    public String ADD_TO_CART_ITEMS = "//div[contains(@style,'rating')]/../../..//input";

    public String PRODUCT_ADDED_TO_CART = "//div[contains(@style,'rating')]/../../../..//h2/a";
}
