package pages;

import org.openqa.selenium.WebDriver;


public class HomePage extends  BasePage{
    private final String URL = "http://training.skillo-bg.com/posts/all";
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void navigateTo(){
        driver.get(URL);
    }
}
