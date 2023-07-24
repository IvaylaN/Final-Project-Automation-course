package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
public class CommentPost extends BaseTestMethods {
    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{"IvaNik", "adidas", "So nice picture"}};
    }
    @Test(dataProvider = "getData")
        public void commentUserPost(String username, String password, String comment) {

        System.out.println("1. Load ISkillo website and login");
        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();
        loginPage.logIn(username, password);

        System.out.println("2. Choose and open other user post");
        pages.ProfilePage profilePage = new pages.ProfilePage(driver);
        profilePage.chooseUserPublicPost(0);

        System.out.println("3. Enter text in Comment field");
        pages.CommentPostPage commentPost = new pages.CommentPostPage(driver);
        commentPost.enterTextInCommentField(comment + "\n");

        System.out.println("4. Go to new comment and verify it is visible");
        commentPost.getNewComment();
        commentPost.verifyNewComment(comment);
    }
}
