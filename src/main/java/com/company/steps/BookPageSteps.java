package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import com.company.pages.BookPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.company.pages.BookPage.*;
import static com.company.pages.HomePageDemo.*;

public class BookPageSteps extends BaseWebUI {
    BookPage bookPage = new BookPage();
    String firstItem;
    String secondItem;

    public void navigateToBookPageSuccessfully() {
        Assert.assertTrue(elementIsPresent(BREADCRUMB));
    }

    public List<Integer> getListRating() {
        List<Integer> listRating = new ArrayList<>();
        List<WebElement> ratingList = getListElements(ITEMS_WITH_ADD_TO_CART);
        for (WebElement rated : ratingList) {
            String valueRated = rated.getAttribute("style");
            int valueRating = Integer.parseInt(valueRated.substring(7, valueRated.indexOf("%")));
            listRating.add(valueRating);
        }
        return listRating;
    }

    public void buyItemsHighestRating() {
        List<Integer> rating = getListRating();
        rating.sort(Collections.reverseOrder());
        firstItem = getTextElement(replaceValueInXpath(bookPage.PRODUCT_ADDED_TO_CART, "rating", String.valueOf(rating.get(0))));
        clickElement(replaceValueInXpath(bookPage.ADD_TO_CART_ITEMS, "rating", String.valueOf(rating.get(0))));
        clickElement(ICON_CLOSE);
        secondItem = getTextElement(replaceValueInXpath(bookPage.PRODUCT_ADDED_TO_CART, "rating", String.valueOf(rating.get(1))));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickElement(replaceValueInXpath(bookPage.ADD_TO_CART_ITEMS, "rating", String.valueOf(rating.get(1))));
        clickElement(ICON_CLOSE);
    }

    public void verifyProductAdded() {
        hoverToElement(SHOPPING_CART);
        waitForElementIsPresence(LIST_PRODUCT_SHOPPING_CART, 10);
        List<WebElement> listElementsProducts = getListElements(LIST_PRODUCT_SHOPPING_CART);
        System.out.println(listElementsProducts.size());
        List<String> listValueProducts = new ArrayList<>();
        for (WebElement listElementsProduct : listElementsProducts) {
            String value = listElementsProduct.getText();
            listValueProducts.add(value);
        }
        for (String listValueProduct : listValueProducts) {
            System.out.println(listValueProduct);
        }
        Assert.assertEquals(firstItem, listValueProducts.get(1));
        Assert.assertEquals(secondItem, listValueProducts.get(0));
    }
}
