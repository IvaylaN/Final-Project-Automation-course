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
    @FindBy(xpath = "//p[contains(text(), 'I am happy to be here \uD83D\uDCF7✈\uFE0F\uD83C\uDFD5\uFE0F')]")
    WebElement fieldAfterModify;
    @FindBy(css= "textarea.form-control")
    WebElement publicInfoField;
    @FindBy(css = "button.btn.btn-primary")
    WebElement saveBtn;
    @FindBy(id = "nav-link-profile")
    WebElement profileBtn;
    public ProfileInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickEditInfoBtn() {
        clickElement(editInfoBtn);
    }
    public void setVerifyWindow() {
        smallWait.until(ExpectedConditions.visibilityOf(verifyWindow));
    }
    public void fillPublicInfoField () {
        publicInfoField.sendKeys("I am happy to be here");
    }
    public void pressSaveInfoBtn(){
        clickElement(saveBtn);
    }
    public String getNewText(){
        smallWait.until(ExpectedConditions.visibilityOf(fieldAfterModify));
        return fieldAfterModify.getText();
    }
    public void clearInfoField(){
        publicInfoField.clear();
    }
    public void goToPublicInfoField(){
        clickElement(publicInfoField);
    }
    public void waitForPageToBeVisible() {
        mediumWait.until(ExpectedConditions.visibilityOf(profileBtn));
    }
    public void goToFieldAfterModify(){
        clickElement(fieldAfterModify);
}
}
