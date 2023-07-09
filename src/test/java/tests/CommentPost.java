package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ProfilePage;

public class CommentPost extends BaseTestMethods {
    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{"IvaNik", "adidas"}};
    }
    @Test(dataProvider = "getData")
        public void commentUserPost(String username, String password) {

        System.out.println("1. Load ISkillo website and login");
        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();
        loginPage.logIn(username, password);

        System.out.println("2. Go to profile page");
        headerPage.goToHome();

        System.out.println("3. Choose and open other user post");
        pages.ProfilePage profilePage = new pages.ProfilePage(driver);
        profilePage.chooseUserPublicPost();

        System.out.println("4. Go to comment field");
        pages.CommentPostPage commentPost = new pages.CommentPostPage(driver);
        commentPost.goToCommentField();


        System.out.println("5. Enter text in Comment field");
        commentPost.clearFileNameField();
        commentPost.enterTextInCommentField();

        System.out.println("6. Go to new comment and verify it is visible");
        commentPost.goToFieldWithNewComment();
        String currentText = commentPost.getNewComment();
        Assert.assertEquals(currentText, "So nice picture", "The text is not the same");

    }
}
