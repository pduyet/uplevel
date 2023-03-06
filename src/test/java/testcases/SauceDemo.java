package testcases;

import bases.BaseTest;
import com.company.microservices.pages.BasePage;
import com.company.microservices.pages.LoginPage;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.company.constant.Constants.URL;

public class SauceDemo extends BaseTest {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    @DataProvider(name = "UserJsonFile")
    public Object[][] getUserJsonFile() {
        JsonObject data = null;
        try {
            data = JsonParser.parseReader(new FileReader("src/main/resources/data.json")).getAsJsonObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert data != null;
        String userName = data.get("userName").getAsString();
        String password = data.get("password").getAsString();
        return new Object[][]{{userName, password}};
    }


    @Test
    public void test1() {
        basePage.goToUrl(URL)
                .verifyTitle();
        loginPage.loginWithCredentials("standard_user", "sauce_secret");
    }

}
