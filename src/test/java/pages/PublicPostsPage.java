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
    @FindBy(css=".post-user")
    List<WebElement> existingUsers;
    @FindBy(css=".btn-primary.profile-edit-btn.ng-star-inserted")
    WebElement otherUserFollowOrUnfollowBtn;
    @FindBy(css = ".btn-all")
    WebElement otherUserAllPostsBtn;
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
        waitForVisibility(onePostedPicture);
    }
    public void openUserByIndex(int index){
        clickElement(existingUsers.get(index));
    }
    public void waitForProfileToShow() {
        waitForVisibility(existingUsers.get(0));
    }
    public void waitForFollowBtnOrUnfollowToShow() {
        smallWait.until(ExpectedConditions.elementToBeClickable(otherUserFollowOrUnfollowBtn));
    }
    public void chooseToFollowOrUnfollowUser(){
        clickElement(otherUserFollowOrUnfollowBtn);
    }
    public void chooseOtherUserAllPostsBtn(){
        clickElement(otherUserAllPostsBtn);
    }
}
