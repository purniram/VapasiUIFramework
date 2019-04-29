package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductListingsPage {

    private ChromeDriver driver;

    public ProductListingsPage(ChromeDriver driver) {

        this.driver = driver;
    }

    public void clickOnLogin ()
    {
        driver.findElement(By.id("link-to-login")).click();
    }

    public boolean isMyAccountDisplayed() {
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        String myAccountText = myAccount.getText();
        return myAccount.isDisplayed();
    }

    public void SelectCategory(String category) {
        WebElement bagsCategory = driver.findElement(By.linkText(category));
        bagsCategory.click();
    }

    public void clickOnProduct(String product)
    {
        WebElement item = driver.findElement(By.linkText(product));

        item.click();
    }
}
