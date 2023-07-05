package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.ProfilePage;
import pages.UploadPostPage;
import java.io.File;
import java.time.Duration;

public class Upload_first_post {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
    }
    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{ {"IvaNik", "adidas", new File("src/upload/firstPost.jpg")}};
    }
    @Test(dataProvider = "getData")
    public void deleteOldPost(String username, String password, File file) {

        System.out.println("1. Load ISkillo website and login");

        pages.HomePage homePage = new pages.HomePage(driver);
        homePage.navigateTo();

        Header headerPage = new Header(driver);
        headerPage.goToLogin();

        pages.LoginPage loginPage = new pages.LoginPage(driver);
        loginPage.checkURL();

        loginPage.logIn(username, password);

        System.out.println("2. Go to profile page");
        headerPage.goToProfile();

        System.out.println("3. Go to All posts");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.allPosts();

        System.out.println("4. Check that there is no posts in All posts");
        int existingAllPosts = profilePage.getCountOfPosts();
        System.out.println("The number of All posts is: " + existingAllPosts);

        System.out.println("5. Go to Private posts");
        profilePage.privatePosts();

        System.out.println("6. Check that there is no posts in Private posts");
        int existingPrivatePosts = profilePage.getCountOfPosts();
        System.out.println("The number of Private posts is: " + existingPrivatePosts);

        System.out.println("7. Upload first photo");
        headerPage.goToNewPost();
        pages.UploadPostPage postPage = new UploadPostPage(driver);
        postPage.uploadImage(file);

        System.out.println("8. Verify that the image is visible");
        postPage.waitForImageToShow();

        System.out.println("9. Submit a photo and check the number of posts");
        postPage.clickSubmitBtn();

        int currentPostCount = profilePage.getCountOfPosts();
        Assert.assertEquals(currentPostCount, existingPrivatePosts + 1, "Incorrect post number");
        System.out.println("The number of posts is: " + currentPostCount);
    }
        @AfterMethod
        public void clean() {
            this.driver.close();
        }
    }

