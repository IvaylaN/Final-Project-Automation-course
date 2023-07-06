package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommentPostPage extends BasePage {
    @FindBy(css = "input.form-control.ng-untouched.ng-pristine.ng-invalid")
    WebElement fileNameField;
    @FindBy(css = ".col-12.comment-content")
    WebElement newCommentField;

    public CommentPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void goToCommentField() {
        clickElement(fileNameField);
    }
    public void enterTextInCommentField() {
        fileNameField.sendKeys("So nice picture");
    }
    public void clearFileNameField(){
        fileNameField.clear();
    }
    public void goToNewComment(){
        clickElement(newCommentField);
    }
 /*   public void getNewComment(){
        smallWait.until(ExpectedConditions.visibilityOf((WebElement) By.partialLinkText(".col-12.comment-content")));
    }*/

}
