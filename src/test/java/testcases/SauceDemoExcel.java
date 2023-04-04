package testcases;

import bases.BaseTest;
import com.company.pages.CommonPage;
import com.company.steps.*;
import com.company.utils.ExcelConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.company.constant.Constants.URL;

public class SauceDemoExcel extends BaseTest {

    ExcelConfig excelConfig = new ExcelConfig("src/main/resources/data.xlsx");
    CommonPage commonPage;
    LoginPageSteps loginPageSteps;
    InventoryPageSteps inventoryPageSteps;
    CartPageSteps cartPageSteps;
    CheckoutInformationPageSteps checkoutInformationPageSteps;
    CheckoutOverviewPageSteps checkoutOverviewPageSteps;
    CompleteOrderPageSteps completeOrderPageSteps;


    @DataProvider(name = "excelUser")
    public Object[][] getCredential() {
        return excelConfig.data();
    }

    @Test(dataProvider = "excelUser")
    public void loginTest(String user, String password) {
        loginPageSteps = new LoginPageSteps();
        commonPage = new CommonPage();
        commonPage.goToUrl(URL)
                .verifyTitle();
        loginPageSteps.loginWithCredentials(user, password);
    }

    @Test
    public void buyProducts() {
        commonPage = new CommonPage();
        loginPageSteps = new LoginPageSteps();
        inventoryPageSteps = new InventoryPageSteps();
        cartPageSteps = new CartPageSteps();
        checkoutInformationPageSteps = new CheckoutInformationPageSteps();
        checkoutOverviewPageSteps = new CheckoutOverviewPageSteps();
        completeOrderPageSteps = new CompleteOrderPageSteps();
        commonPage.goToUrl(URL).verifyTitle();
        loginPageSteps.loginWithCredentials("standard_user", "secret_sauce");
        inventoryPageSteps.verifyLoginSuccessfully().buyRandom().verifyTotalBadgeShoppingCart().navigateToCartPage();
        cartPageSteps.verifyNavigateToCartPageSuccessfully().navigateToCheckoutYourInformation();
        checkoutInformationPageSteps.verifyNavigateToCheckoutInformationPageSuccessfully().fillYourInformation().navigateToCheckoutOverview();
        checkoutOverviewPageSteps.verifyNavigateToCheckoutOverviewPageSuccessfully().navigateToCompleteOrderPage();
        completeOrderPageSteps.verifyNavigateToCompleteOrderPageSuccessfully().backToHomePage();
        inventoryPageSteps.verifyLoginSuccessfully();
    }
}
