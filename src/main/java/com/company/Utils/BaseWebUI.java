package com.company.Utils;

import com.company.constant.Constants;
import com.company.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseWebUI {

    public WebDriver driver;
    WebDriverWait wait;

    public BaseWebUI() {
        try {
            driver = DriverManager.getDriver();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void waitForElementIsClickable(WebElement element) {
        try {
            wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.WAIT_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable error) {
            System.err.println(error.getMessage());
        }
    }

    protected void clickElement(WebElement element) {
        waitForElementIsClickable(element);
        element.click();
    }

    protected void clearValue(WebElement element) {
        element.clear();
    }

    protected void sendKeys(WebElement element, String value) {
        clickElement(element);
        clearValue(element);
        element.sendKeys(value);
    }

    protected List<WebElement> getListElements (By by) {
        return DriverManager.getDriver().findElements(by);
    }
}
