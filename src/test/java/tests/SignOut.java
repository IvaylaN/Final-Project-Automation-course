package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class SignOut extends BaseTestMethods {
    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{"IvaNik", "adidas"}};
    }
    @Test(dataProvider = "getData")
    public void usesCanSignOut(String username, String password) {

        System.out.println("1. Load ISkillo website and login");
        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        pages.HeaderPage headerPage = new pages.HeaderPage(driver);
        headerPage.goToLogin();

        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();
        loginPage.logIn(username, password);

        System.out.println("2. Go to profile to verify successful log in");
        headerPage.goToProfile();

        System.out.println("3. Go to and press sign out btn");
        headerPage.chooseSignOutBtn();

        System.out.println("4. Choose Login to verify you are logged out");
        headerPage.goToLogin();
        loginPage.checkURL();
    }
}
