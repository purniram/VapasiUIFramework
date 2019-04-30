package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements( driver, this);

    }

    @FindBy (id = "spree_user_email")
    WebElement userEmail;

    @FindBy (id = "spree_user_password")
    WebElement password;

    @FindBy (name = "commit")
    WebElement loginButton;


    public ProductListingsPage login(String username, String userpassword) {

        //driver.findElement(By.id("spree_user_email")).sendKeys(username);
        //driver.findElement(By.id("spree_user_password")).sendKeys(password);
        //driver.findElement(By.name("commit")).click();

        userEmail.sendKeys(username);
        password.sendKeys(userpassword);
        loginButton.click();

        return new ProductListingsPage(driver);
    }

}
