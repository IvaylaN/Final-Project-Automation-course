package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
public class CommentPostPage extends BasePage {
    @FindBy (css = ".form-control[formcontrolname ='content']" )
    WebElement fileNameField;
    @FindBy(css = ".comment-container")
    WebElement newCommentField;
    public CommentPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void enterTextInCommentField(String comment) {
       enterText(fileNameField, comment );
    }
    public String getNewComment(){
        waitForVisibility(newCommentField);
        return newCommentField.getText();
    }
    public void verifyNewComment() {
        Assert.assertTrue(getNewComment().contains("So nice picture"));
    }
}
