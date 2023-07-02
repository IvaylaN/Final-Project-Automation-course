package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {

    WebDriverWait wait;
    @FindBy(css = ".post-img")
    WebElement postedPicture;

    @FindBy(css = ".btn-all")
    WebElement goToAllPosts;
    @FindBy(css = ".fa-trash-alt")

    WebElement clickTrash;

    @FindBy(xpath = "//button[text()='Yes']")
    WebElement confirmDelete;



    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
}
