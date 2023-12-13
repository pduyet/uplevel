package com.company.steps;

import com.company.core.basehandle.BaseWebUI;
import org.testng.Assert;

import static com.company.pages.GitPage.GIT_LINK;

public class GitPageSteps extends BaseWebUI {

    public void switchToGitPage() {
        switchToNewTab();
    }
    public void navigateToGitSuccessfully() {
        Assert.assertTrue(elementIsPresent(GIT_LINK));
    }

    public void closeGitPageWhenLoadingSuccessfully() {
        waitForPageReadyForState(30);
        closeATab();
    }
}
