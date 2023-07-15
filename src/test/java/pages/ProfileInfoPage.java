package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class ProfileInfoPage extends BasePage {
    @FindBy(css = ".fa-user-edit")
    WebElement editInfoBtn;
    @FindBy(xpath = "//h4[text()='Modify Your Profile']")
    WebElement verifyWindow;
    @FindBy(css = "app-profile-section p")
    WebElement fieldAfterModify;
    @FindBy(css= "textarea.form-control")
    WebElement publicInfoField;
    @FindBy(css = "button.btn.btn-primary")
    WebElement saveBtn;
    @FindBy(id = "nav-link-profile")
    WebElement profileBtn;
    @FindBy(css = ".profile-edit-container")
    WebElement modalDialog;
    public ProfileInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickEditInfoBtn() {
        clickElement(editInfoBtn);
    }
    public void checkVerifyWindow() {
        waitForVisibility(verifyWindow);
    }
    public void pressSaveInfoBtn(){
        clickElement(saveBtn);
    }
    public String getNewText(){
        waitForVisibility(fieldAfterModify);
        return fieldAfterModify.getText();
    }
    public void goToPublicInfoField(){
        clickElement(publicInfoField);
    }
    public void waitForPageToBeVisible() {
        waitForVisibility(profileBtn);
    }
    public void enterTextInProfileInfo(String text) {
        publicInfoField.clear();
        enterText(publicInfoField, text );
    }
    public void waitForDialogDisappear(){
      waitForVisibility(modalDialog);
    }
}
