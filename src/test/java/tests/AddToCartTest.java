package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class AddToCartTest extends BaseTest{

    @Test
    public void testItemClickAndAddToCart()

    {
        addProduct("Bags", "Ruby on Rails Tote");

        WebElement CartContainer = driver.findElement(By.id("cart-detail")) ;
        List<WebElement> lineItems  = CartContainer.findElements(By.id("line_items"));

        for (Iterator<WebElement> lineItem = lineItems.iterator(); lineItem.hasNext(); ) {
            WebElement product =  lineItem.next();
            //System.out.print
        }

        assertTrue(lineItems.size() == 1);

        WebElement lineItem = lineItems.get(0);

        assertTrue(lineItem.findElement(By.linkText("Ruby on Rails Tote")).isDisplayed());
        assertTrue(lineItem.findElement(By.id("order_line_items_attributes_0_quantity")).getAttribute("value").equals("1"));
    }

    @Test
    public void SampleTest()
    {
        System.out.println ("Sample");
    }

    private void addProduct(String category, String product) {
        openBrowser(url);
        WebElement bagsCategory = driver.findElement(By.linkText(category));
        bagsCategory.click();

        WebElement item = driver.findElement(By.linkText(product));
        item.click();

        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
        addToCartBtn.click();

        String title = driver.getTitle();
        assertEquals(title, "Ruby on Rails Tote - Spree Demo Site");

        System.out.println(title);
    }
}