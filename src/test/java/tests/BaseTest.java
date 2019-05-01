package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.GetConfigProperties;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.internal.Utils.copyFile;

public class BaseTest extends GetConfigProperties {

    WebDriver driver;
    String url = getUrl();
    String userName = readConfigFile().getProperty("username"); //"spree@example.com";
    String password = readConfigFile().getProperty("password");//"spree123";

    public BaseTest() throws IOException {
    }

    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void openBrowser(String url)
    {
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        System.out.println ("Quitting all browsers");
        driver.close();
        driver.quit();
    }

    @AfterMethod(alwaysRun =  true)
    public void captureScreenShotIfFails(ITestResult result)
    {
    if (result.getStatus()== ITestResult.FAILURE)
    {
        takeScreenshot(result);
    }
    }

    private void takeScreenshot(ITestResult result) {

        String filePath =  System.getProperty("user.dir")+ "/target/" ;
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in target folder with test method name
        try {

            FileUtils.copyFile(scrFile, new File(filePath+result.getName().toString().trim()+".png"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
