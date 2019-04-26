package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    ChromeDriver driver;
    String url = "https://spree-vapasi.herokuapp.com";
    // private ChromeDriver;

    @BeforeTest
    public void setup()
    {
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

    @AfterTest
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }

}
