package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ProfileInfoPage;

public class ChangeProfileInfo extends BaseTestMethods {

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{"IvaNik", "adidas", "I am happy to be here"}};
    }
    @Test(dataProvider = "getData")
    public void changeProfileInfo(String username, String password, String text) {

        System.out.println("1. Load ISkillo website and login");
        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();

        loginPage.logIn(username, password);

        System.out.println("2. Confirm log im by checking Log out btn is visible. Go to profile page");
        headerPage.waitForNewPostBtnVisible();
        ProfileInfoPage profileInfo = new ProfileInfoPage(driver);
        profileInfo.waitForPageToBeVisible();
        headerPage.goToProfile();

        System.out.println("3. Click edit info button");
        profileInfo.clickEditInfoBtn();

        System.out.println("4. Verify visibility of Modify your profile window is shown");
        profileInfo.waitForModifyModal();

        System.out.println("5. Fill the field Public info");
        profileInfo.goToPublicInfoField();
        profileInfo.enterTextInProfileInfo(text);

        System.out.println("6. Click Save btn");
        profileInfo.pressSaveInfoBtn();

        System.out.println("7. Verify the entered text is visible");
        profileInfo.waitForDialogDisappear();
        profileInfo.getNewProfileInfo("I am happy to be here");
    }
}
