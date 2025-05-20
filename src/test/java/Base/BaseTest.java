package Base;

import Pages.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;



public class BaseTest {

    protected WebDriver driver;
    protected BasePage basepage;
    protected HomePage homepage;


    private String url="https://ecommerce.tealiumdemo.com/";


    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Utility.setDriver(driver);
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(url);
        basepage = new BasePage(driver);
        basepage.closeConsentModalIfPresent();
        homepage = new HomePage(driver);

    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult){
        if(ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source =  screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    java.time.LocalDate.now() +
                    testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot Located At" + destination);
        }

    }

    @AfterClass
    public void tearDown(){
      driver.quit();
   }

}

