package tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.ExcelOperations;

public class BaseTest {
	WebDriver driver;
	ExcelOperations xlop = new ExcelOperations();
	ExtentReports extent;
	ExtentTest test;
 
	@BeforeClass
	public void setupReport(){
		ExtentSparkReporter spark = new ExtentSparkReporter("report/ExtentReport.html");
		spark.config().setReportName("SauceDemo Report");
		spark.config().setDocumentTitle("Test Execution Results");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	
	@BeforeMethod
	public void beforeMethod(ITestContext context) throws MalformedURLException {
		
		String browserName = context.getCurrentXmlTest().getParameter("browserName");
		
		if(browserName.equals("Chrome")) {
			// 1. Create a map for Chrome preferences
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false); // Disables saving passwords
			prefs.put("profile.password_manager_enabled", false); // Disables password manager
			prefs.put("profile.password_manager_leak_detection", false); // Disables the breach popup

			// Include Browser Options
			ChromeOptions opt = new ChromeOptions();
//			opt.addArguments("--headless");
			opt.setExperimentalOption("prefs", prefs);
			opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//			opt.addArguments("window-size=1920,1080");

//			driver = new ChromeDriver(opt);
			driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444"), opt);
		}else if(browserName.equals("Firefox")) {
			
			// 1. Create a map for Chrome preferences
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false); // Disables saving passwords
			prefs.put("profile.password_manager_enabled", false); // Disables password manager
			prefs.put("profile.password_manager_leak_detection", false); // Disables the breach popup

			// Include Browser Options
			FirefoxOptions opt = new FirefoxOptions();

			driver = new FirefoxDriver(opt);
		}else {
			//MIcrosoft Edge
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}

	@AfterClass
	public void closeReport(){
		extent.flush();
	}
	
    @AfterMethod
    public void tearDownTest(ITestResult result) {
    	driver.quit();
    }
    
    public static String screenCapture(WebDriver driver) throws IOException{
    	String screenshotPath="";
    	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	File dstFile = new File("./src/test/resources/screenchots/"+System.currentTimeMillis()+".png");
    	FileUtils.copyFile(scrFile, dstFile);
    	screenshotPath = dstFile.getAbsolutePath();
    	return screenshotPath;
    	
    }
    

}
