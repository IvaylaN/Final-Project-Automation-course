package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PublicPostsPage;

public class DislikePublicPosts extends BaseTestMethods {
    @Test
    public void dislikePublicPost(){
        System.out.println("1. Load ISkillo website and verify Login btn is visible");
        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        System.out.println("2. Choose one post and click on it");
        PublicPostsPage publicPosts = new PublicPostsPage(driver);
        publicPosts.choosePublicPost();

        System.out.println("3. Verify that the chosen one is visible");
        publicPosts.waitToSeeThePost();

        System.out.println("4. Verify that it is impossible to press dislike button. When you press it you must be redirected to Login page");
        publicPosts.clickDislikeBtn();

        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();
        //modala da byde zatvoren
    }
}
