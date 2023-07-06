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
    @FindBy(css = ".fas.fa-search")
    WebElement searchBtn;
    @FindBy(css = ".dropdown-container")
    WebElement dropDownBoxAfterPressedSearch;
    @FindBy(css=".post-feed-img")
    WebElement userPost;
    @FindBy(css = "input.form-control.ng-untouched.ng-pristine.ng-invalid")
    WebElement fileNameField;
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
    public void allPosts(){
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
        smallWait.until(ExpectedConditions.elementToBeClickable(searchField));
    }
    public void enterLetterInSearchField(){
        searchField.sendKeys("t");
    }
    public void pressSearchBtn(){
        clickElement(searchBtn);
    }
    public void waitForDropBoxToShow() {
        bigWait.until(ExpectedConditions.visibilityOf(dropDownBoxAfterPressedSearch));
    }
    public  void chooseUserPublicPost(){
        clickElement(userPost);
    }


}

