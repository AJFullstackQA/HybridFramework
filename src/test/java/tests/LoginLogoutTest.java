package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.aventstack.extentreports.MediaEntityBuilder;

import pages.LoginPage;
import pages.ProductsPage;

public class LoginLogoutTest extends BaseTest {
	@Test
	public void loginLogoutMethod() throws InterruptedException, EncryptedDocumentException, IOException {
		final Logger log = LogManager.getLogger(LoginLogoutTest.class);
		log.info("===== Test Started: LoginLogoutTest =====");
		
		test = extent.createTest("Login Logout Test");

		test.info("=====> Beginning of LoginLogout Test <=====");
		// Fetch the Test-Data
		String url = xlop.getExcelData("LoginScript", 1, 0);
		String uname = xlop.getExcelData("LoginScript", 1, 1);
		String pwd = xlop.getExcelData("LoginScript", 1, 2);

		// Create an object of LoginPage class
		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);

		// Test Step = 1 : Load the URL & Verify
		loginPage.loadURL(url);
		Assert.assertTrue(loginPage.verifyHeaderText());
		test.info("Application was opened successfully");
		log.info("Application was opened successfully");

		// Test Step = 2 : Do the login & verify
		loginPage.login(uname, pwd);
		Assert.assertEquals(true, productsPage.verifyLogin());
		test.info("Login was successful...!");
		log.info("Login was successful...!");
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenCapture(driver)).build());

		// Test Step = 3 : Logout of the application & verify
		productsPage.logout();
		Assert.assertTrue(loginPage.verifyHeaderText());
		test.info("Logout was successful...!");
		log.info("Logout was successful...!");
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenCapture(driver)).build());
		
		
		test.info("=====> End of LoginLogout Test <=====");
		log.info("=====> End of LoginLogout Test <=====");
	}
}
