package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductDescriptionPage;
import pages.ProductListingsPage;
import pages.ShoppingCartPage;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class AddToCartTest extends BaseTest{

    String category = "Bags";
    String product = "Ruby on Rails Tote";
    String quantity = "3";

    @Test(groups="sample")

    public void testAddToCartGuest()
    {
        ProductListingsPage prdtListingPage = new ProductListingsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        openBrowser(url);

        List<WebElement> lineItems = prdtListingPage.SelectCategory(category).clickOnProduct(product).addToCart(quantity).getItemsFromCart();

        shoppingCartPage.assertItemsInCart(lineItems,shoppingCartPage,quantity);

    }


    @Test
    public void testAddtoCartwithLogin()
    {
        openBrowser(url);

        ProductListingsPage prdtListingPage = new ProductListingsPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        prdtListingPage.clickOnLogin().login(userName,password);

        List<WebElement> lineItems = shoppingCartPage.clearCart(url).SelectCategory(category).clickOnProduct(product).
                                      addToCart(quantity).getItemsFromCart();
        shoppingCartPage.assertItemsInCart(lineItems,shoppingCartPage,quantity);
    }
}