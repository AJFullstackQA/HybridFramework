package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;

public class AddItemsToCartTest extends BaseTest{
	
	@Test
	public void loginTest() throws InterruptedException {
		
		//Page classes object creation steps
		LoginPage lp = new LoginPage(driver);
		ProductsPage prodPage = new ProductsPage(driver);
		
		//Goto the saucedemo url
		lp.loadURL("https://www.saucedemo.com/");
		
		//Verify whether Page was actually loaded
		AssertJUnit.assertEquals(lp.verifyHeaderText(), true);
		
		//Login into the application
		lp.login("standard_user", "secret_sauce");
		

		//Verify whether login was successful
		AssertJUnit.assertEquals(prodPage.verifyLogin(), true);
		
		
		//Add Items to Cart
		prodPage.addItemsToCart();
		
		//Verify Whether Items Were added to cart
		AssertJUnit.assertEquals(prodPage.verifyItemInCart(), true);
		
		//Logout of the application
		prodPage.logout();
		
		//Verify whether logout was successful
		AssertJUnit.assertEquals(lp.verifyHeaderText(), true);
		
		
	}
}
