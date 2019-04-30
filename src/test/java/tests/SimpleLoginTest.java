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
        assertTrue(prdtListingPage.clickOnLogin().login(userName,password).isMyAccountDisplayed(), "Login failed");

    }

    @Test ( dataProvider = "invalidLoginUserAndPassword")
    public void testInvalidLogin ( String username, String password)
    {
        openBrowser(url);
        ProductListingsPage prdtListingPage = new ProductListingsPage(driver);
        prdtListingPage.clickOnLogin().login(username,username);

        assertTrue ( driver.findElement(By.className("alert-error")).isDisplayed());

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
