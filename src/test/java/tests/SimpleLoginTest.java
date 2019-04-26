package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest {

    @Test
    public void testLogin(){

        openBrowser(url);
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("spree@example.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("spree123");
        driver.findElement(By.name("commit")).click();

        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        String myAccountText = myAccount.getText();
       // assertTrue( myAccountText.equals("My Account"), "My Account exists");
        assertTrue(myAccount.isDisplayed(), "Logged in successfully");

    }

}
