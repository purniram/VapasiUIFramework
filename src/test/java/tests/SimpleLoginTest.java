package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductListingsPage;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest {


    @Test(groups="sample")
    public void testLogin(){

        openBrowser(url);
        ProductListingsPage prdtListingPage = new ProductListingsPage(driver);
        prdtListingPage.clickOnLogin();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(userName,password);

        assertTrue(prdtListingPage.isMyAccountDisplayed(), "Login failed");

    }


}
