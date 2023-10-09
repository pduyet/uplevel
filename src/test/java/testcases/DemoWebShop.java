package testcases;

import bases.BaseTest;
import com.company.steps.*;
import com.company.utils.ExcelConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoWebShop extends BaseTest {
    ExcelConfig excelConfig = new ExcelConfig("src/test/resources/assignment.xlsx");

    HomePageDemoSteps homePageDemoSteps;
    LoginPageDemoSteps loginPageDemoSteps;
    BookPageSteps bookPageSteps;
    DigitalDownloadsPageSteps digitalDownloadsPageSteps;

    ShoppingCartPgeSteps shoppingCartPgeSteps;
    CheckAsGuestPageSteps checkAsGuestPageSteps;
    CheckOutPageSteps checkOutPageSteps;


    @DataProvider(name = "excelUser")
    public Object[][] getCredential() {
        return excelConfig.data();
    }

    @Test(dataProvider = "excelUser", enabled = false)
    public void LoginTest(String STT, String email, String password, String expectedMessage) {
        homePageDemoSteps = new HomePageDemoSteps();
        loginPageDemoSteps = new LoginPageDemoSteps();
        homePageDemoSteps.goToHomePage();
        homePageDemoSteps.clickLogin();
        loginPageDemoSteps.verifyNavigateToLoginPageSuccessfully();
        loginPageDemoSteps.fillInCredentials(email, password);
        loginPageDemoSteps.verifyMessage(expectedMessage);
    }

    @Test()
    public void getTextShoppingCart() {
        homePageDemoSteps = new HomePageDemoSteps();
        bookPageSteps = new BookPageSteps();
        homePageDemoSteps.goToHomePage();
        homePageDemoSteps.clickBookTab();
        bookPageSteps.navigateToBookPageSuccessfully();
        bookPageSteps.getListRating();
        bookPageSteps.buyItemsHighestRating();
        bookPageSteps.verifyProductAdded();
    }

    @Test(enabled = false)
    public void BuyItem() {
        homePageDemoSteps = new HomePageDemoSteps();
        digitalDownloadsPageSteps = new DigitalDownloadsPageSteps();
        shoppingCartPgeSteps = new ShoppingCartPgeSteps();
        checkAsGuestPageSteps = new CheckAsGuestPageSteps();
        checkOutPageSteps = new CheckOutPageSteps();
        homePageDemoSteps.goToHomePage();
        homePageDemoSteps.clickDigitalDownloads();
        digitalDownloadsPageSteps.navigateToDigitalDownloadsSuccessfully();
        digitalDownloadsPageSteps.buyItem();
        homePageDemoSteps.addCartSuccessfully();
        homePageDemoSteps.clickShoppingCart();
        shoppingCartPgeSteps.navigateToShoppingCartSuccessfully();
        shoppingCartPgeSteps.checkTermOfService();
        shoppingCartPgeSteps.clickCheckOut();
        checkAsGuestPageSteps.navigateToCheckAsGuestSuccessfully();
        checkAsGuestPageSteps.clickCheckAsGuest();
        checkOutPageSteps.navigateToCheckOutPageSuccessfully();
        checkOutPageSteps.fillInInformation();
        checkOutPageSteps.navigateToPaymentMethodSuccessfully();
        checkOutPageSteps.getPaymentMethod();
    }

}
