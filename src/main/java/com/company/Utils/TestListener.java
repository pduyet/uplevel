package com.company.Utils;

import com.company.Report.AllureManager;
import com.company.drivers.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log4j.error("Test case: " + getTestName(result) + " is failed.");
        CaptureUtils.captureScreen(DriverManager.getDriver(), getTestName(result));
        AllureManager.takeScreenshotToAttachOnAllureReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log4j.warn("Test case: " + getTestName(result) + " is skipped.");
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log4j.info("Test case: " + getTestName(result) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log4j.info("Test case: " + getTestName(result) + " is passed.");
        AllureManager.saveTextLog("Test case: " + getTestName(result) + " is passed.");
    }

    @Override
    public void onFinish(ITestContext result) {
    }

    @Override
    public void onStart(ITestContext result) {
        Log4j.info("Test case: " + result.getName() + " is starting");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
}
