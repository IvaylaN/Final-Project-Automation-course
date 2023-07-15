package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;

public class SearchField extends BaseTestMethods {
    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{"IvaNik", "adidas", "t"}};
    }
    @Test(dataProvider = "getData")
    public void useSearchField(String username, String password, String letter) {

        System.out.println("1. Load ISkillo website and login");
        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();
        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();
        loginPage.logIn(username, password);

        System.out.println("2. Go to search field");
        pages.ProfilePage profilePage = new pages.ProfilePage(driver);
        profilePage.chooseSearchField();
        profilePage.waitForSearchFieldToShow();

        System.out.println("3. Enter a letter in Search field and press search btn");
        profilePage.enterLetterInSearchField(letter);
        profilePage.pressSearchBtn();

        System.out.println("4. Verify the results are shown");
        profilePage.waitForDropBoxToShow();
        // да проверя с linktext и list
    }
}
