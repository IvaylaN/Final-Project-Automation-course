package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private final String URL = "http://training.skillo-bg.com/posts/all";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get(URL);

    }
}
