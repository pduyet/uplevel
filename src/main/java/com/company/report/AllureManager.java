package com.company.report;

import com.company.core.drivers.DriverManager;
import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;

public class AllureManager {
    public AllureManager() {}

    public static void setAllureEnvironmentInformation(String key, String value) {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put(key, value)
                        .build(), System.getProperty("user.dir") + "/target/allure-results/");
    }


    @Attachment(value = "Screenshot", type = "image/png")
    public static void takeScreenshotToAttachOnAllureReport() {
        try {
            ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static void saveTextLog(String message) {
    }
}
