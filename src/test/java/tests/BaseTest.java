package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    ChromeDriver driver;
    String url = "https://spree-vapasi.herokuapp.com";
    // private ChromeDriver;

    @BeforeMethod
    public void setup()
    {
        System.out.println("Setting up driver before test");
        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is " + currentUsersWorkingDir);
        System.setProperty("webdriver.chrome.driver",currentUsersWorkingDir+"/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void openBrowser(String url)
    {
        driver.get(url);
    }

    @AfterMethod
    public void tearDown()
    {
        System.out.println ("Quitting all browsers");
        driver.close();
        driver.quit();
    }

}
