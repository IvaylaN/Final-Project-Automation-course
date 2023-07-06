package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTestMethods {
    protected WebDriver driver;

    public static final String RESOURCES_DIR = "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    //public static final String DOWNLOAD_DIR = RESOURCES_DIR.concat("download" + File.separator);
    public static final String REPORT_DIR = RESOURCES_DIR.concat("reports" + File.separator);
    public static final String SCREENSHOT_DIR = RESOURCES_DIR.concat("screenshots" + File.separator);
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(13));
    }

    private void takeScreenShot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String testName = testResult.getName();
            try {
                FileUtils.copyFile(screenshot, new File(SCREENSHOT_DIR.concat(testName).concat(".jpg")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
            @AfterMethod
            public void cleanUp(ITestResult testResult){
                takeScreenShot(testResult);
                if (driver != null) {
                    driver.close();
                }
            }
            }
