package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {

        this.driver = driver;
    }

    public List<WebElement> getItemsFromCart() {
        WebElement CartContainer = driver.findElement(By.id("cart-detail"));
        List<WebElement> lineItems = CartContainer.findElements(By.id("line_items"));

        for (Iterator<WebElement> lineItem = lineItems.iterator(); lineItem.hasNext(); ) {
            WebElement product = lineItem.next();
            System.out.println("Item Title: " + driver.findElement(By.tagName("a")).getText());
        }
        return lineItems;
    }

    public WebElement getFirstLineItem(List<WebElement> lineItems) {

        WebElement lineItem = lineItems.get(0); //getting the first line item


        return lineItem;
    }

    public WebElement getLineItem(WebElement lineItem)
    {
        WebElement item = lineItem.findElement(By.linkText("Ruby on Rails Tote")); //getting the item

        return item;
    }

    public String getLineItemQuantity ( WebElement lineItem)
    {
        String itemQuantity = lineItem.findElement(By.id("order_line_items_attributes_0_quantity")).getAttribute("value");
        return itemQuantity;
    }

    /*
    public void gotoShoppingCartPage ()
    {
        driver.get("https://spree-vapasi.herokuapp.com/cart");
    } */


    public void clearCart()

    {
        driver.get("https://spree-vapasi.herokuapp.com/cart");
        driver.findElement(By.id("clear_cart_link")).click();

       // assertEquals( driver.findElement(By.linkText("Your cart is empty")).getText(), "Your cart is empty");
    }
}
