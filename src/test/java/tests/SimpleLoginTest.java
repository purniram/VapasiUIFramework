package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductListingsPage;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SimpleLoginTest extends BaseTest {

    public SimpleLoginTest() throws IOException {
    }

    @Test(groups="sample")
    public void testLogin(){

        openBrowser(url);
        Reporter.log("Opening the browser");
        ProductListingsPage prdtListingPage = new ProductListingsPage(driver);

        Reporter.log("checking if the user is logged in and taken to the home page");
        assertTrue(prdtListingPage.clickOnLogin().login(userName,password).isMyAccountDisplayed(), "Login failed");

    }

    @Test ( dataProvider = "invalidLoginUserAndPassword")
    public void testInvalidLogin ( String username, String password)
    {
        openBrowser(url);
        Reporter.log("Opening the browser");
        ProductListingsPage prdtListingPage = new ProductListingsPage(driver);

        Reporter.log("Invalid login password provided");
        prdtListingPage.clickOnLogin().login(username,username);

        Reporter.log("checking if the invalid login error message is displayed");
        assertFalse ( driver.findElement(By.className("alert-error")).isDisplayed());

    }

  @DataProvider(name = "invalidLoginUserAndPassword")
   public Object[][] getInvalidLoginUserNameAndPassword ()
   {
      return new Object[][] {
              {"spree@example.com" , "spree"},
              {"example@spree.com", "exmple"}

    };
   }
}
