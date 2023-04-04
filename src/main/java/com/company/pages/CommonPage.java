package com.company.pages;

import com.company.utils.BaseWebUI;
import com.company.constant.Constants;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.time.Duration;

public class CommonPage extends BaseWebUI {

    public CommonPage() {
        super();
    }

    @Step("Go to : {0}")
    public CommonPage goToUrl(String url) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_TIME));
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.WAIT_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        return this;
    }

    @Step("Verify title")
    public CommonPage verifyTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(Constants.titleLoginPage));
        return this;
    }
}
