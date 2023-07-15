package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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
    @FindBy(css="app-small-user-profile .btn-primary")
    List<WebElement> otherUserFollowOrUnfollowBtn;
    @FindBy(css = ".btn-all")
    WebElement otherUserAllPostsBtn;
    @FindBy(css = ".post-modal-img")
    WebElement modalDialog;
    @FindBy(css = ".btn-primary.profile-edit-btn")
    WebElement followUnfollowBtn;
    public PublicPostsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
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
        waitForVisibility(existingUsers.get(1));
    }
    public void waitForFollowBtnOrUnfollowToShow() {
        mediumWait.until(ExpectedConditions.elementToBeClickable(otherUserFollowOrUnfollowBtn.get(1)));
    }
    public void chooseOtherUserAllPostsBtn(){
        clickElement(otherUserAllPostsBtn);
    }
    public void waitForDialogDisappear(){
        smallWait.until(ExpectedConditions.invisibilityOf(modalDialog));
    }
    public void checkVisibilityOfAllPostBtn() {
        waitForVisibility(otherUserAllPostsBtn);
    }
    public void pressFollowUnfollowBtn(){
        clickElement(followUnfollowBtn);
    }
}
