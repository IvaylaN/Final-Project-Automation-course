package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PublicPostsPage;

public class DislikePublicPosts extends BaseTestMethods {
    @Test
    public void tryToDislikePost(){
        System.out.println("1. Load ISkillo website");


        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        System.out.println("2. Load public posts and choose one");
        PublicPostsPage publicPosts = new PublicPostsPage(driver);
        //publicPosts.waitToLoadAllPosts();
        int countAllPosts = publicPosts.getCountOfPosts();
        System.out.println("The number of All visible posts is: " + countAllPosts);

        System.out.println("3. Choose one post and click on it");
        publicPosts.choosePublicPost();

        System.out.println("4. Verify that the chosen one is visible");
        publicPosts.waitToSeeThePost();

        System.out.println("5. Verify that it is impossible to press dislike button");
        publicPosts.clickDislikeBtn();
        Boolean ableBtn = Boolean.FALSE;
        Assert.assertTrue(ableBtn, "We can press the button");
    }
}
