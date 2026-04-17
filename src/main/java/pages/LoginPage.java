package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Global WebDriver driver
	WebDriver driver;
	
	//Parameterized constructor accepting WebDriver driver
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		//Page Decorator
		PageFactory.initElements(driver, this);
	}
	
	//Locating WebElements using @FindBy annotations & store them as private WebELement
	@FindBy(id="user-name")
	private WebElement unameTextBox;
	
	@FindBy(name="password")  //for cssSelector we should use only css
	private WebElement passwordTextBox;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='login_container']/div[1]")
	private WebElement headerText;
	
	
	//Go to the URL
	public void loadURL(String url) {
		driver.get(url);
	}
	
	
	//Method to do Login action
	public void login(String uname, String pwd) {
		unameTextBox.sendKeys(uname);
		passwordTextBox.sendKeys(pwd);
		loginButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Header Text Verification method
	public boolean verifyHeaderText() {
		if(headerText.getText().equals("Swag Labs")) {
			System.out.println("Header Text verification has passed");
			return true;
		}else {
			System.out.println("Header Text verification has not passed");
			return false;
		}
	}
	


}
