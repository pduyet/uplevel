package testcases;

import bases.BaseTest;
import com.company.steps.GitPageSteps;
import com.company.steps.MDNPageSteps;
import org.testng.annotations.Test;

public class openNewTab extends BaseTest {

    MDNPageSteps mdnPageSteps;
    GitPageSteps gitPageSteps;

    @Test
    public void handleNewTab() {
        mdnPageSteps = new MDNPageSteps();
        gitPageSteps = new GitPageSteps();

        mdnPageSteps.goToWebMDN();
        mdnPageSteps.clickToJoshuaChen();
        gitPageSteps.switchToGitPage();
        gitPageSteps.navigateToGitSuccessfully();
        gitPageSteps.closeGitPageWhenLoadingSuccessfully();
        mdnPageSteps.switchToParentPage();
    }
}
