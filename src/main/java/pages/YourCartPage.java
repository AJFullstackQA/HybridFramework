package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
	// Global WebDriver driver
	WebDriver driver;

	// Parameterized constructor accepting WebDriver driver
	public YourCartPage(WebDriver driver) {

		this.driver = driver;

		// Page Decorator
		PageFactory.initElements(driver, this);
	}

	// Locating the Elements
	@FindBy(xpath = "//span[@class='title']")
	private WebElement yourCartPageTitle;
	
	@FindBy(id="checkout")
	private WebElement checkoutButton;
	
	// Method to verify Cart page title text
	public boolean verifyCartPageTitleText() throws InterruptedException {
		Thread.sleep(2000);
		if (yourCartPageTitle.getText().equals("Your Cart")) {
			System.out.println("Your Cart Page title verification passed");
			return true;
		} else {
			System.out.println("Your Cart Page title verification has not passed");
			return false;
		}
	}
	
	//Click on checkout button
	public void checkout() {
		Actions act = new Actions(driver);
		act.scrollToElement(checkoutButton);
		checkoutButton.click();
	}

}
