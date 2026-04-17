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
import pages.OrderCompletePage;
import pages.OverviewPage;
import pages.ProductsPage;
import pages.YourCartPage;
import pages.YourInformationPage;

public class EndToEndTest extends BaseTest {

	@Test
	public void loginTest() throws InterruptedException {

		// Page classes object creation steps
		LoginPage lp = new LoginPage(driver);
		ProductsPage prodPage = new ProductsPage(driver);
		YourCartPage yourCartPage = new YourCartPage(driver);
		YourInformationPage yourInformationPage = new YourInformationPage(driver);
		OverviewPage overviewPage = new OverviewPage(driver);
		OrderCompletePage orderCompletePage = new OrderCompletePage(driver);

		// Goto the saucedemo url
		lp.loadURL("https://www.saucedemo.com/");

		// Verify whether Page was actually loaded
		AssertJUnit.assertEquals(lp.verifyHeaderText(), true);

		// Login into the application
		lp.login("standard_user", "secret_sauce");

		// Verify whether login was successful
		AssertJUnit.assertEquals(prodPage.verifyLogin(), true);

		// Add Items to Cart
		prodPage.addItemsToCart();

		// Verify Whether Items Were added to cart
		AssertJUnit.assertEquals(prodPage.verifyItemInCart(), true);

		// Click on Cart Link
		prodPage.clickCartLink();

		// Verify Whether Your cart page is displayed or not
		AssertJUnit.assertEquals(yourCartPage.verifyCartPageTitleText(), true);

		// Click on Checkout Button
		yourCartPage.checkout();

		// Verify Your Information page
		AssertJUnit.assertEquals(yourInformationPage.verifyYourInformationPageTitleText(), true);

		// Enter user Information
		yourInformationPage.enterInformation("Ajay", "Fullstack", "560076");

		// Click on continue Button
		yourInformationPage.clickContinueButton();

		// Verify Your Information page
		AssertJUnit.assertEquals(overviewPage.verifyOverviewPageTitleText(), true);

		// Click on finish button
		overviewPage.clickFinish();

		// Verify Order COmplete Page
		AssertJUnit.assertEquals(orderCompletePage.verifyOrderCOmpletePageTitleText(), true);

		// Verify Success Message
		AssertJUnit.assertEquals(orderCompletePage.verifyOrderCOmpletePageSuccessMsg(), true);

		// Logout steps
		orderCompletePage.clickBackToProducts();
		prodPage.logout();

	}
}
