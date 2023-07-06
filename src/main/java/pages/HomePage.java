package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends  BasePage{
    private final String URL = "http://training.skillo-bg.com/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void navigateTo(){
        driver.get(URL);
    }
}
