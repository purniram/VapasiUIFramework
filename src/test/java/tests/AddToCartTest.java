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
        openBrowser(url);
        ProductListingsPage prdtListingPage = new ProductListingsPage(driver);
        prdtListingPage.SelectCategory(category);
        prdtListingPage.clickOnProduct(product);

        ProductDescriptionPage prdtDescriptionPage = new ProductDescriptionPage(driver);
        prdtDescriptionPage.addToCart(quantity);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        List<WebElement> lineItems = shoppingCartPage.getItemsFromCart();

        assertTrue(lineItems.size() == 1 , "No of items in cart should be 1"); // assert there is only one item in cart

        WebElement lineItem = shoppingCartPage.getFirstLineItem( lineItems); //getting the first line item

        assertTrue(shoppingCartPage.getLineItem(lineItem).isDisplayed(), "the item is not showing in cart"); // is item displayed
        assertTrue(shoppingCartPage.getLineItemQuantity(lineItem).equals(quantity), "the quantity is not matching"); // is quantity matching
    }

    @Test
    public void testAddtoCartwithLogin()
    {
        openBrowser(url);

        ProductListingsPage prdtListingPage = new ProductListingsPage(driver);
        prdtListingPage.clickOnLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(userName,password);
        assertTrue(prdtListingPage.isMyAccountDisplayed(), "Login failed");

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clearCart(url);

        prdtListingPage.SelectCategory(category);
        prdtListingPage.clickOnProduct(product);

        ProductDescriptionPage prdtDescriptionPage = new ProductDescriptionPage(driver);
        prdtDescriptionPage.addToCart(quantity);

        List<WebElement> lineItems = shoppingCartPage.getItemsFromCart();

        assertTrue(lineItems.size() == 1 , "No of items in cart should be 1"); // assert there is only one item in cart

        WebElement lineItem = shoppingCartPage.getFirstLineItem( lineItems); //getting the first line item

        assertTrue(shoppingCartPage.getLineItem(lineItem).isDisplayed(), "the item is not showing in cart"); // is item displayed

        System.out.println(shoppingCartPage.getLineItemQuantity(lineItem));
        assertTrue(shoppingCartPage.getLineItemQuantity(lineItem).equals(quantity), "the quantity is not matching"); // is quantity matching

    }
}