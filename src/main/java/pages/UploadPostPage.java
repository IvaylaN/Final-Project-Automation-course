package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
public class UploadPostPage extends BasePage {

    final String URL = "http://training.skillo-bg.com/users/4054";
    @FindBy(css = "input.file[type='file']")
    WebElement fileUploadInputBrowseBtn;
    @FindBy(id = "create-post")
    WebElement submitBtn;
    @FindBy(css = "input.input-lg")
    WebElement fileNameField;
    @FindBy(css = ".image-preview")
    WebElement imagePreview;
    @FindBy(name = "caption")
    WebElement captionInput;
    @FindBy(css = ".fa-plus-square")
    WebElement plusNewPostBtn;

    public UploadPostPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void uploadImage (File file) {
        fileUploadInputBrowseBtn.sendKeys(file.getAbsolutePath());
    }
    public void clickSubmitBtn() {
        clickElement(submitBtn);
    }
    public String getImageFileName(){
        smallWait.until(ExpectedConditions.visibilityOf(fileNameField));
        return  fileNameField.getAttribute("placeholder");
    }
    public void waitForImageToShow() {
        smallWait.until(ExpectedConditions.visibilityOf(imagePreview));
    }
    public void checkURL() {
        checkURL(URL);
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
