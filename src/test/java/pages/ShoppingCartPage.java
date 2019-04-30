package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartPage {

    WebDriver driver;
    private String CartUrl = "https://spree-vapasi.herokuapp.com/cart";

    public ShoppingCartPage(WebDriver driver) {

        this.driver = driver;
    }

    public ProductListingsPage clearCart(String url)

    {

        driver.get(CartUrl);

        try{
            driver.findElement(By.xpath("//input[@value='Empty Cart']")).isDisplayed();
            driver.findElement(By.xpath("//input[@value='Empty Cart']")).click();
          //  WebDriverWait wait=new WebDriverWait(driver, 5);
           // wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCart));

        }
        catch( Exception e) {
            System.out.println (e.toString() );

        }

        driver.findElement(By.linkText("Continue shopping")).click();
        return new ProductListingsPage(driver);
    }

    public List<Product> getCartDetails() {

        List<Product> cartDetails = new ArrayList<Product>();
        WebElement CartContainer = driver.findElement(By.id("cart-detail"));
        List<WebElement> lineItems = CartContainer.findElements(By.id("line_items"));

        for (Iterator<WebElement> lineItem = lineItems.iterator(); lineItem.hasNext(); ) {
            WebElement prdElement = lineItem.next();
            Product product = new Product();

            product.productName = prdElement.findElement(By.className("cart-item-description")).getText();
           // product.productPrice = prdElement.findElement(By.className("lead text-primary cart-item-price")).getText();
            product.productQuantity= prdElement.findElement(By.id("order_line_items_attributes_0_quantity")).getAttribute("value");
          //  product.productTotalPrice = prdElement.findElement(By.className("lead text-primary cart-item-total")).getText();

            cartDetails.add(product);

        }

        return cartDetails;
    }

    public int noOfProductsInCart (List<Product> cartDetails)
    {
        return cartDetails.size();
    }

    public Product firstProductInCart (List<Product> cartDetails)
    {
        return cartDetails.get(0);
    }

    /*public List<WebElement> getItemsFromCart() {

        WebElement CartContainer = driver.findElement(By.id("cart-detail"));
        List<WebElement> lineItems = CartContainer.findElements(By.id("line_items"));

        *//*for (Iterator<WebElement> lineItem = lineItems.iterator(); lineItem.hasNext(); ) {
            WebElement product = lineItem.next();
            System.out.println("Item Title: " + driver.findElement(By.tagName("a")).getText());
        } *//*
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
    }*/

}
