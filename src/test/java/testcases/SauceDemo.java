package testcases;

import bases.BaseTest;
import com.company.model.User;
import com.company.steps.InventoryPageSteps;
import com.company.steps.LoginPageSteps;
import com.company.utils.JsonConfig;
import com.google.gson.Gson;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.company.constant.Constants.URL;

public class SauceDemo extends BaseTest {
    LoginPageSteps loginPageSteps;
    InventoryPageSteps inventoryPageSteps;

    JsonConfig jsonConfig = new JsonConfig();

    @DataProvider(name = "UserJsonFile")
    public Object[][] getUserJsonFile() {
        return jsonConfig.data();
    }

    @Test(dataProvider = "UserJsonFile", groups = {"group 1"})
    @Feature("Login")
    @Story("I want to login")
    public void loginTest(User user) {
        loginPageSteps = new LoginPageSteps();
        inventoryPageSteps = new InventoryPageSteps();
        loginPageSteps.goToUrl(URL)
                .verifyTitle();
        loginPageSteps.loginWithCredentials(user.getUserName(), user.getPassword());
        inventoryPageSteps.verifyLoginSuccessfully();
    }

}
