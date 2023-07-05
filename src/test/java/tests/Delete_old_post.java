package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Header;
import pages.ProfilePage;
import java.time.Duration;
public class Delete_old_post {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(13));
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{"IvaNik", "adidas"}};
    }
    @Test(dataProvider = "getData")
    public void deleteOldPost(String username, String password) {

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

        System.out.println("3. Click all posts");
        pages.ProfilePage profilePage = new ProfilePage(driver);
        profilePage.allPosts();

        System.out.println("4. Choose one of your posts");
        profilePage.clickOnPost();

        System.out.println("5. Choose delete post");
        profilePage.clickDeletePost();

        System.out.println("6. Choose option Yes");
        profilePage.confirmDelete();

        System.out.println("7. Confirm that there are no posts");
        WebElement newPostBtnIsVisible = driver.findElement(By.xpath("//h3[text()='New post']"));
        Assert.assertTrue(newPostBtnIsVisible.isDisplayed());

        profilePage.allPosts();
        int existingPosts = profilePage.getCountOfPosts();
        System.out.println("The number of posts is: " + existingPosts);
    }

    @AfterMethod
    public void cleanUp() {
        this.driver.close();
    }

}
