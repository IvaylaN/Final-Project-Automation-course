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
    @FindBy(css = ".image-preview")
    WebElement imagePreview;
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
    public void waitForImageToShow() {
        waitForVisibility(imagePreview);
    }
    public void checkURL() {
        checkURL(URL);
    }
}
