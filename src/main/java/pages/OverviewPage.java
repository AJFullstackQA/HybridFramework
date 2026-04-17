package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
	// Global WebDriver driver
	WebDriver driver;

	// Parameterized constructor accepting WebDriver driver
	public OverviewPage(WebDriver driver) {

		this.driver = driver;

		// Page Decorator
		PageFactory.initElements(driver, this);
	}

	// Locating the Elements
	@FindBy(xpath = "//span[@class='title']")
	private WebElement overviewPageTitle;
	
	@FindBy(id = "finish")
	private WebElement finishButton;

	
	// Method to verify Overview page title text
	public boolean verifyOverviewPageTitleText() throws InterruptedException {
		Thread.sleep(2000);
		if (overviewPageTitle.getText().equals("Checkout: Overview")) {
			System.out.println("Overview Page title verification passed");
			return true;
		} else {
			System.out.println("Overview Page title verification has not passed");
			return false;
		}
	}
	
	
	// CLick on FInish Button
	public void clickFinish() {
		finishButton.click();
	}
	


}
