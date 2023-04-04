package com.company.utils;

import com.company.constant.Constants;
import com.company.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    }

    protected void waitForElementIsClickable(By by) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Throwable error) {
            System.err.println(error.getMessage());
        }
    }

    protected void clickElement(By by) {
        waitForElementIsClickable(by);
        driver.findElement(by).click();
    }

    protected void clearValue(By by) {
        clickElement(by);
        driver.findElement(by).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), Keys.DELETE);
    }

    protected void sendKeys(By by, String value) {
        clickElement(by);
        clearValue(by);
        driver.findElement(by).sendKeys(value);
    }

    protected List<WebElement> getListElements (By by) {
        return driver.findElements(by);
    }

    protected boolean elementIsPresent(By by) {
        try {
           driver.findElement(by);
           return true;
        } catch (Exception e) {
            return false;
        }
    }

    public By replaceValueInXpath(String oldXpath, String oldVal, String newVal) {
        return By.xpath(oldXpath.replace(oldVal, newVal));
    }

    public String getTextElement(By by) {
        return driver.findElement(by).getText();
    }
}
