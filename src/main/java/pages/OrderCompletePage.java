package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCompletePage {
	// Global WebDriver driver
	WebDriver driver;

	// Parameterized constructor accepting WebDriver driver
	public OrderCompletePage(WebDriver driver) {

		this.driver = driver;

		// Page Decorator
		PageFactory.initElements(driver, this);
	}

	// Locating the Elements
	@FindBy(xpath = "//span[@class='title']")
	private WebElement orderCompletePageTitle;
	
	@FindBy(tagName = "h2")
	private WebElement successMsg;
	
	@FindBy(id="back-to-products")
	private WebElement backToProducts;

	
	// Method to verify order complete page title text
	public boolean verifyOrderCOmpletePageTitleText() throws InterruptedException {
		Thread.sleep(2000);
		if (orderCompletePageTitle.getText().equals("Checkout: Complete!")) {
			System.out.println("Order Complete Page title verification passed");
			return true;
		} else {
			System.out.println("Order Complete Page title verification has not passed");
			return false;
		}
	}
	
	
	// Method to verify order complete page Success message
	public boolean verifyOrderCOmpletePageSuccessMsg() {
		if (successMsg.getText().equals("Thank you for your order!")) {
			System.out.println("Success Message Verification passed");
			return true;
		} else {
			System.out.println("Success Message Verification not passed");
			return false;
		}
	}
	
	
	//Method to click Bact to home button
	public void clickBackToProducts() {
		backToProducts.click();
	}


}
