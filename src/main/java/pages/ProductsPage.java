package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	// Global WebDriver driver
	WebDriver driver;

	// Parameterized constructor accepting WebDriver driver
	public ProductsPage(WebDriver driver) {

		this.driver = driver;

		// Page Decorator
		PageFactory.initElements(driver, this);
	}

	// Locating the Elements
	@FindBy(xpath = "//span[@class='title']")
	private WebElement productsPageTitle;

	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")
	private List<WebElement> addToCartButtons;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement itemNumberInCart;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cartLink;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement logoutMenuButton;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logoutLink;
	
	// Method to verify Products page title text
	public boolean verifyLogin() {
		if (productsPageTitle.getText().equals("Products")) {
			System.out.println("Products Page title verification passed");
			return true;
		} else {
			System.out.println("Products Page title verification has not passed");
			return false;
		}
	}

	// Add all items to Cart
	public void addItemsToCart() throws InterruptedException {
		int count = 0;
		for (WebElement item : addToCartButtons) {
			item.click();
			Thread.sleep(2000);
			count++;
			if(count==2)
				break;
		}
	}
	
	//Very the numbe rof items added in cart
	public boolean verifyItemInCart() {
		int actualItems = Integer.parseInt(itemNumberInCart.getText());
		if(2==actualItems) {
			System.out.println("Number of Items added are successfully verified");
			return true;
		}
		else {
			System.out.println("Number of Items added are not successfully verified");
			return false;
		}
	}
	
	//Click on Cart link Button
	public void clickCartLink() {
		cartLink.click();
	}
	
	//Logout of the application
	public void logout() {
		logoutMenuButton.click();
		logoutLink.click();
	}

}
