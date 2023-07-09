package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BasePage {
    private final String URLLogin = "http://training.skillo-bg.com/users/login";
    @FindBy(css = "form .h4")
    WebElement signInText;
    @FindBy(name = "usernameOrEmail")
    WebElement userNameField;
    @FindBy(name = "password")
    WebElement passField;
    @FindBy(id = "sign-in-button")
    WebElement signInBtn;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void checkURL() {
        checkURL(URLLogin);
    }
    public void enterUsername(String username) {
        enterText(userNameField, username);
    }
    public void enterPassword(String password) {
        enterText(passField, password);
    }
    public void clickSignIn() {
        clickElement(signInBtn);
    }
    public void logIn(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }
}
