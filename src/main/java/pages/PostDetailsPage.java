/*
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PostDetailsPage extends BasePage {
    @FindBy(name = "caption")
    WebElement captionInput;
    @FindBy(css = "input.input-lg")
    WebElement fileNameField;
    */
/*@FindBy(name = "caption")
    WebElement captionInput;*//*

    @FindBy(css = ".fa-plus-square")
    WebElement plusNewPostBtn;
    public PostDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getImageFileName(){
        smallWait.until(ExpectedConditions.visibilityOf(fileNameField));
        return  fileNameField.getAttribute("placeholder");
    }
    public void useBrowseBtn(){
        clickElement(fileUploadInputBrowseBtn);
    }
    public void choosePlusNewPostBtn(){
        clickElement(plusNewPostBtn);
    }
    public void waitForBrowseBtnToShow() {
        smallWait.until(ExpectedConditions.elementToBeClickable(fileUploadInputBrowseBtn));
    }
}
*/
