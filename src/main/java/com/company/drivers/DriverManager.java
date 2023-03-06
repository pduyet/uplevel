package com.company.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public synchronized static WebDriver getLocalDriver(String browser) throws Exception {
        WebDriver tDriver;
        switch (browser.toLowerCase()) {
            case "chrome":
                tDriver = new ChromeDriver();
                System.out.println("created driver");
                break;
            case "firefox":
                tDriver = new FirefoxDriver();
                break;
            default:
                throw new Exception("Wrong browser name, pls check");
        }
        setDriver(tDriver);
        return tDriver;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quitDriver() throws Exception {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
