package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.PublicPostsPage;

public class FollowUnfollowOtherUser extends BaseTestMethods {
    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{"IvaNik", "adidas"}};
    }
    @Test(dataProvider = "getData")
    public void followOtherUser(String username, String password) {
        System.out.println("1. Load ISkillo website and login");
        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();

        loginPage.logIn(username, password);

        System.out.println("2. Load public posts and choose some user profile");
        headerPage.goToHome();
        PublicPostsPage publicPostsPage = new PublicPostsPage(driver);
        publicPostsPage.openUserByIndex(0);

        System.out.println("3. Verify you can see user profile and Follow btn is shown");
        publicPostsPage.waitForProfileToShow();
        publicPostsPage.waitForFollowBtnOrUnfollowToShow();

        System.out.println("4. Follow the user and go to his All posts");
        publicPostsPage.chooseToFollowOrUnfollowUser();
        publicPostsPage.chooseOtherUserAllPostsBtn();

        System.out.println("5. Unfollow the user and go to his All posts");
        publicPostsPage.chooseToFollowOrUnfollowUser();
        publicPostsPage.chooseOtherUserAllPostsBtn();

        System.out.println("6. Verify All posts user btn is unable when you unfollow him");
        Boolean unableAllPostsBtn = Boolean.TRUE;
        //da prowerq dali butona e visible - Assert.assertTrue(unableAllPostsBtn, "It is possible to press the button");
//list s elementi da ima tekts follow
    }
}
