package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ProfileInfoPage;

public class ChangeProfileInfo extends BaseTestMethods {

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{"IvaNik", "adidas"}};
    }
    @Test(dataProvider = "getData")
    public void changeProfileInfo(String username, String password) {

        System.out.println("1. Load ISkillo website and login");
        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();

        loginPage.logIn(username, password);

        System.out.println("2. Go to profile page");
        ProfileInfoPage profileInfo = new ProfileInfoPage(driver);
        profileInfo.waitForPageToBeVisible();
        headerPage.goToProfile();

        System.out.println("3. Click edit info button");
        profileInfo.clickEditInfoBtn();

        System.out.println("4. Verify visibility of Modify your profile window is shown");
        profileInfo.setVerifyWindow();

        System.out.println("5. Fill the field Public info");
        profileInfo.goToPublicInfoField();
        profileInfo.clearInfoField();
        profileInfo.fillPublicInfoField();

        System.out.println("6. Click Save btn");
        profileInfo.pressSaveInfoBtn();

        System.out.println("7. Go to profile and to modified field");
        headerPage.goToProfile();
        profileInfo.goToFieldAfterModify();

        System.out.println("8. Verify the entered text is visible");
        String currentText = profileInfo.getNewText();
        Assert.assertEquals(currentText, "I am happy to be here", "The text is not the same");
    }
}
