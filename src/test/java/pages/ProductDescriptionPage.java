package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDescriptionPage {

    private WebDriver driver;

    public ProductDescriptionPage(WebDriver driver) {

        this.driver = driver;
    }

    public void addToCart(String quantity)
    {
    WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
        WebElement qty = driver.findElement(By.id("quantity"));
        qty.clear();
        qty.sendKeys(quantity);
        addToCartBtn.click();
     }



}
