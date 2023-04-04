package com.company.steps;

import com.company.utils.BaseWebUI;
import com.company.utils.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.company.pages.InventoryPage.*;

public class InventoryPageSteps extends BaseWebUI {
    static int firstProduct;
    static int secondProduct;

    public InventoryPageSteps verifyLoginSuccessfully() {
        Assert.assertTrue(elementIsPresent(TABLE_PRODUCTS), "Login with standard user unsuccessfully");
        return this;
    }

    public List<String> getListPrices() {
        List<String> listPrices = new ArrayList<>();
        List<WebElement> listDefaultPrices = getListElements(LIST_PRICE);
        for (WebElement element : listDefaultPrices) {
            listPrices.add(element.getText().substring(1));
        }
        return listPrices;
    }

    public InventoryPageSteps buyRandom() {

        Random rd = new Random();
        List<String> listPrices = getListPrices();
        List<Integer> indexPrices = new ArrayList<>();
        firstProduct = rd.nextInt(listPrices.size());
        secondProduct = rd.nextInt(listPrices.size());
        while ((firstProduct == 2) || (firstProduct == 5)) {
            firstProduct = rd.nextInt(listPrices.size());
            while (firstProduct == secondProduct) {
                secondProduct = rd.nextInt(listPrices.size());
            }
        }
        Log4j.info("the first product with price: " + listPrices.get(firstProduct));
        Log4j.info("the second product with price: " + listPrices.get(firstProduct));
        indexPrices.add(firstProduct);
        indexPrices.add(secondProduct);
        for (int index : indexPrices) {
            By xpathProduct = replaceValueInXpath(BTN_ADDTOCART, "price", listPrices.get(index));
            Log4j.info("the xpath product: " + xpathProduct);
            clickElement(xpathProduct);
        }
        return this;
    }

    public InventoryPageSteps verifyTotalBadgeShoppingCart() {
        String numberOfBadgeShoppingCart = getTextElement(BADGE_SHOPPING_CART);
        Assert.assertEquals(numberOfBadgeShoppingCart, "2", "expected badge shopping cart is 2 but actual is " + numberOfBadgeShoppingCart);
        return this;
    }

    public void navigateToCartPage() {
        clickElement(SHOPPING_CART_CONTAINER);
    }
}
