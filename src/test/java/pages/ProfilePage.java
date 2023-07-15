package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
public class ProfilePage extends BasePage {
    @FindBy(css = ".post-img")
    WebElement postedPicture;
    @FindBy(css = ".btn-all")
    WebElement goToAllPosts;
    @FindBy(css = ".btn-private")
    WebElement goToPrivatePosts;
    @FindBy(css = ".fa-trash-alt")
    WebElement clickTrash;
    @FindBy(xpath = "//button[text()='Yes']")
    WebElement confirmDelete;
    @FindBy(css="app-post")
    List<WebElement> existingPosts;
    @FindBy(id = "search-bar")
    WebElement searchField;
    @FindBy(css = ".fa-search")
    WebElement searchBtn;
    @FindBy(css = ".dropdown-container")
    WebElement dropDownBoxAfterPressedSearch;
    @FindBy(css=".post-feed-img")
    List<WebElement> userPost;
    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickOnPost(){
        clickElement(postedPicture);
    }
    public void clickDeletePost(){
        clickElement(clickTrash);
    }
    public void confirmDelete(){
        clickElement(confirmDelete);
    }
    public void goToAllPosts(){
        clickElement(goToAllPosts);
    }
    public void privatePosts(){
        clickElement(goToPrivatePosts);
    }
    public int getCountOfPosts(){
        return  existingPosts.size();
    }
    public void chooseSearchField(){
        clickElement(searchField);
    }
    public void waitForSearchFieldToShow() {
        waitForVisibility(searchField);
    }
    public void enterLetterInSearchField(String letter){
       enterText(searchField, letter);
    }
    public void pressSearchBtn(){
        clickElement(searchBtn);
    }
    public void waitForDropBoxToShow() {
        bigWait.until(ExpectedConditions.visibilityOf(dropDownBoxAfterPressedSearch));
    }
    public  void chooseUserPublicPost(int index){
        clickElement(userPost.get(index));
    }
}

