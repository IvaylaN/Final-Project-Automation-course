package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage{
    //private WebDriver driver;
    @FindBy(id = "homeIcon")
    WebElement logoBtn;
    @FindBy(id = "nav-link-home")
    WebElement homeBtn;
    @FindBy(id = "nav-link-profile")
    WebElement profileBtn;
    @FindBy(id = "nav-link-new-post")
    WebElement newPostBtn;
    @FindBy(id = "nav-link-login")
    WebElement loginLink;

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void clickToLogo(){
        clickElement(logoBtn);
    }
    public void goToProfile(){
        clickElement(profileBtn);
    }
    public void goToHome(){
        clickElement(homeBtn);
    }
    public void goToNewPost(){
        clickElement(newPostBtn);
    }
    public void goToLogin() {
        clickElement(loginLink);
    }
}
