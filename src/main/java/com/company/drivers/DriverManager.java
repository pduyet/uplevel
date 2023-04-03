package com.company.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public synchronized static void getLocalDriver(String browser) throws Exception {
        WebDriver tDriver;
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                tDriver = new ChromeDriver(chromeOptions);
                System.out.println("created driver");
                break;
            case "firefox":
                tDriver = new FirefoxDriver();
                break;
            default:
                throw new Exception("Wrong browser name, pls check");
        }
        setDriver(tDriver);
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
