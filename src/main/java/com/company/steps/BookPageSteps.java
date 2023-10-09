package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import com.company.pages.BookPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.company.pages.BookPage.*;

public class BookPageSteps extends BaseWebUI {
    BookPage bookPage = new BookPage();

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
        System.out.println("1: " + bookPage.ADD_TO_CART_ITEMS);
        clickElement(replaceValueInXpath(bookPage.ADD_TO_CART_ITEMS, "rating", String.valueOf(rating.get(0))));
        System.out.println("2: " + bookPage.ADD_TO_CART_ITEMS);
        clickElement(replaceValueInXpath(bookPage.ADD_TO_CART_ITEMS, "rating", String.valueOf(rating.get(1))));
    }
}
