package testcases;

import bases.BaseTest;
import com.company.pages.HomePageDemo;
import com.company.pages.LoginPageDemo;
import com.company.steps.HomePageDemoSteps;
import com.company.steps.LoginPageDemoSteps;
import com.company.utils.ExcelConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo extends BaseTest {
    ExcelConfig excelConfig = new ExcelConfig("src/test/resources/assignment.xlsx");

    HomePageDemoSteps homePageDemoSteps;
    LoginPageDemoSteps loginPageDemoSteps;


    @DataProvider(name = "excelUser")
    public Object[][] getCredential() {
        return excelConfig.data();
    }

    @Test(dataProvider = "excelUser")
    public void LoginTest(String STT, String email, String password, String expectedMessage) {
        homePageDemoSteps = new HomePageDemoSteps();
        loginPageDemoSteps = new LoginPageDemoSteps();
        homePageDemoSteps.goToHomePage();
        homePageDemoSteps.clickLogin();
        loginPageDemoSteps.verifyNavigateToLoginPageSuccessfully();
        loginPageDemoSteps.fillInCredentials(email, password);
        loginPageDemoSteps.verifyMessage(expectedMessage);
    }

}
