package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(ChromeDriver driver) {

        this.driver = driver;

    }

   // WebElement userName =  driver.findElement(By.id("spree_user_email"));
  //  WebElement password = driver.findElement(By.id("spree_user_password"));
   // WebElement loginButton = driver.findElement(By.name("commit"));

    public void login(String username, String password) {
        driver.findElement(By.id("spree_user_email")).sendKeys(username);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }
}
