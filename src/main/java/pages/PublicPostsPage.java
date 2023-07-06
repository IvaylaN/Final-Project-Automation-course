package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class PublicPostsPage extends BasePage{
    @FindBy(css=".post-feed-img")
    List<WebElement> publicPosts;
    @FindBy(css = ".post-feed-img")
    WebElement onePostedPicture;
    @FindBy(css = ".fa-thumbs-down")
    WebElement dislikeBtn;
    public PublicPostsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public int getCountOfPosts(){
        return  publicPosts.size();}
    public void choosePublicPost() {
        clickElement(onePostedPicture);
    }
    public void clickDislikeBtn() {
        clickElement(dislikeBtn);
    }
    public void waitToSeeThePost() {
        smallWait.until(ExpectedConditions.visibilityOf(onePostedPicture));
    }
}
