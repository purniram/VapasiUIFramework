package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

public class ProductListingsPage {

    private WebDriver driver;

    public ProductListingsPage(WebDriver driver) {

        this.driver = driver;

    }

    public LoginPage clickOnLogin ()
    {
        driver.findElement(By.id("link-to-login")).click();
        return new LoginPage(driver);
    }

    public boolean isMyAccountDisplayed() {
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        String myAccountText = myAccount.getText();
        return myAccount.isDisplayed();
    }

    public ProductListingsPage SelectCategory(String category) {
        WebElement bagsCategory = driver.findElement(By.linkText(category));
        bagsCategory.click();
        return new ProductListingsPage(driver);
    }

    public ProductDescriptionPage clickOnProduct(String product)
    {
        WebElement item = driver.findElement(By.linkText(product));

        item.click();
        return new ProductDescriptionPage(driver);
    }
}
