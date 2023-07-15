package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ProfilePage;

public class DeleteOldPost extends BaseTestMethods {
    //private WebDriver driver;
    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{"IvaNik", "adidas"}};
    }
    @Test(dataProvider = "getData")
    public void deleteOldPost(String username, String password) {

        System.out.println("1. Load ISkillo website and login");
        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.goToLogin();

        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();
        loginPage.logIn(username, password);

        System.out.println("2. Go to profile page");
        headerPage.goToProfile();

        System.out.println("3. Click all posts and show their number");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.allPosts();

        int currentPostCount = profilePage.getCountOfPosts();
        System.out.println("The number of posts is: " + currentPostCount);

        System.out.println("4. Choose the post");
        profilePage.clickOnPost();

        System.out.println("5. Choose delete post");
        profilePage.clickDeletePost();

        System.out.println("6. Choose option Yes");
        profilePage.confirmDelete();

        System.out.println("7. Confirm that there are no posts and show their number");
        profilePage.allPosts();
        int existingPosts = profilePage.getCountOfPosts();

        Assert.assertEquals(existingPosts,currentPostCount  - 1, "Incorrect post number");
        System.out.println("The number of posts is: " + existingPosts);
    }
}
