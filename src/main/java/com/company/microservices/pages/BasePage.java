package com.company.microservices.pages;

import com.company.Utils.BaseWebUI;
import com.company.constant.Constants;
import com.company.drivers.DriverManager;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.time.Duration;

public class BasePage extends BaseWebUI {

    public BasePage() {
        super();
    }

    @Step("Go to : {0}")
    public BasePage goToUrl(String url) {
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_TIME));
        DriverManager.getDriver().get(url);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.WAIT_TIME));
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        return this;
    }

    @Step("Verify title")
    public BasePage verifyTitle() {
        String title = DriverManager.getDriver().getTitle();
        Assert.assertTrue(title.contains(Constants.titleLoginPage));
        return this;
    }
}
