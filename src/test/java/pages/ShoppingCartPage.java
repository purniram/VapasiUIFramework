package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {

        this.driver = driver;
    }

    public List<WebElement> getItemsFromCart() {
        WebElement CartContainer = driver.findElement(By.id("cart-detail"));
        List<WebElement> lineItems = CartContainer.findElements(By.id("line_items"));

        /*for (Iterator<WebElement> lineItem = lineItems.iterator(); lineItem.hasNext(); ) {
            WebElement product = lineItem.next();
            System.out.println("Item Title: " + driver.findElement(By.tagName("a")).getText());
        } */
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

    public ProductListingsPage clearCart(String url)

    {
        By emptyCart = By.className("alert alert-info");
        driver.get("https://spree-vapasi.herokuapp.com/cart");

       // System.out.println("is shopping cart empty: "+ driver.findElement(By.linkText("Your cart is empty")).getText());

        if(( driver.findElement(By.name("commit")).isDisplayed())) {
            driver.findElement(By.name("commit")).click();
          //  WebDriverWait wait=new WebDriverWait(driver, 5);
           // wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCart));

        }

        driver.findElement(By.linkText("Continue shopping")).click();
        return new ProductListingsPage(driver);

    }

    public void assertItemsInCart(List<WebElement> lineItems, ShoppingCartPage shoppingCartPage, String quantity) {

        assertTrue(lineItems.size() == 1 , "No of items in cart should be 1"); // assert there is only one item in cart

        WebElement lineItem = shoppingCartPage.getFirstLineItem( lineItems); //getting the first line item

        assertTrue(shoppingCartPage.getLineItem(lineItem).isDisplayed(), "the item is not showing in cart"); // is item displayed
        assertTrue(shoppingCartPage.getLineItemQuantity(lineItem).equals(quantity), "the quantity is not matching"); // is quantity matching

    }
}
