package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutRegistrationPage {

    private WebDriver driver;

    public CheckoutRegistrationPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void registerGuestUser ( String useremail)
    {
        WebElement guestUserEmail = driver.findElement(By.id("order_email"));
        guestUserEmail.sendKeys(useremail);
    }

    public void clickContinue ()
    {
        driver.findElement(By.tagName("submit")).click();
    }
}