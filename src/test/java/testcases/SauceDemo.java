package testcases;

import bases.BaseTest;
import com.company.model.User;
import com.company.steps.LoginPageSteps;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.company.constant.Constants.URL;

public class SauceDemo extends BaseTest {
    LoginPageSteps loginPageSteps;

    @DataProvider(name = "UserJsonFile")
    public Object[][] getUserJsonFile() {
        Gson gson = new Gson();
        try {
            User[] user = gson.fromJson(new FileReader("src/main/resources/data.json"), User[].class);

            Object[][] data = new Object[user.length][1];
            for (int i = 0; i < user.length; i++) {
                data[i][0] = user[i];
            }
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test(dataProvider = "UserJsonFile")
    public void loginTest(User user) {
        loginPageSteps = new LoginPageSteps();
        loginPageSteps.goToUrl(URL)
                .verifyTitle();
        loginPageSteps.loginWithCredentials(user.getUserName(), user.getPassword());
    }

}
