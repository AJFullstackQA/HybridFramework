package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage {
	// Global WebDriver driver
	WebDriver driver;

	// Parameterized constructor accepting WebDriver driver
	public YourInformationPage(WebDriver driver) {

		this.driver = driver;

		// Page Decorator
		PageFactory.initElements(driver, this);
	}

	// Locating the Elements
	@FindBy(xpath = "//span[@class='title']")
	private WebElement yourInformationPageTitle;
	
	@FindBy(id="first-name")
	private WebElement firstNameTextBox;
	
	@FindBy(id="last-name")
	private WebElement lastNameTextBox;
	
	@FindBy(id="postal-code")
	private WebElement postalCodeTextBox;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	

	
	// Method to verify Your Information page title text
	public boolean verifyYourInformationPageTitleText() throws InterruptedException {
		Thread.sleep(2000);
		if (yourInformationPageTitle.getText().equals("Checkout: Your Information")) {
			System.out.println("Your Information Page title verification passed");
			return true;
		} else {
			System.out.println("Your Information Page title verification has not passed");
			return false;
		}
	}
	
	
	//Method to enter User Information
	public void enterInformation(String fn,String ln, String postalCode) {
		firstNameTextBox.sendKeys(fn);
		lastNameTextBox.sendKeys(ln);
		postalCodeTextBox.sendKeys(postalCode);
		
	}
	
	//Click on continue button
	public void clickContinueButton() {
		continueButton.click();
	}
	


}
