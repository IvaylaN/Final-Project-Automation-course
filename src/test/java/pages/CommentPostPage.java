package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommentPostPage extends BasePage {
    @FindBy (css = ".form-control[formcontrolname ='content']" )
    WebElement fileNameField;
    @FindBy(css = ".col-12.comment-content")
    WebElement newCommentField;
    @FindBy(xpath = "//div[contains(text(), 'So nice picture')]")
    WebElement newComment;
    public CommentPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
      public void enterTextInCommentField(String comment) {
       enterText(fileNameField, comment );
    }
    public String getNewComment(){
        waitForVisibility(newComment);
        return newComment.getText();
    }
}
