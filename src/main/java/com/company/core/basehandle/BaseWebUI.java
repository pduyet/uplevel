package com.company.core.basehandle;

import com.company.constant.Constants;
import com.company.core.drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BaseWebUI {

    public WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BaseWebUI() {
        try {
            driver = DriverManager.getDriver();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    protected void visitWebsite(String url) {
        driver.get(url);
    }

    protected String getPageUrl() {
        return driver.getCurrentUrl();
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

    protected List<WebElement> getListElements(By by) {
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

    protected void selectByValue(By by, String value) {
        Select slc = new Select(driver.findElement(by));
        slc.selectByVisibleText(value);
    }

    protected boolean elementIsChecked(By by) {
        return driver.findElement(by).isSelected();
    }

    protected By replaceValueInXpath(String oldXpath, String oldVal, String newVal) {
        String newXpath = oldXpath.replace(oldVal, newVal);
        return By.xpath(newXpath);
    }

    protected String getTextElement(By by) {
        return driver.findElement(by).getText();
    }

    protected void waitForElementIsPresence(By by, int time) {
        try {
            wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout for wait element: " + by.toString() + " on " + time);
            System.out.println(error.getMessage());
        }
    }

    protected void waitForElementIsNotPresence(By by, int time) {
        try {
            wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Throwable error) {
            Assert.fail("Timeout for wait element: " + by.toString() + " on " + time);
            System.out.println(error.getMessage());
        }
    }

    protected void hoverToElement(By by) {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    protected void waitForPageReadyForState(int time) {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(time));

        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    protected void closeATab() {
        DriverManager.getDriver().close();
    }

    protected void switchToNewTab() {
        Set<String> handles = DriverManager.getDriver().getWindowHandles();
        for (String handle : handles) {
            DriverManager.getDriver().switchTo().window(handle);
        }
    }
}
