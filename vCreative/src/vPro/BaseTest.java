package vPro;

import java.util.NoSuchElementException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

	public class BaseTest {


		// Test Environments
		
		// TwoTest
		public String baseUrl = "https://two-test.vcreative.net/#/login";
		
		// SmokeTest
//		public String baseUrl = "https://smoketest.vcreative.net/#/login";
		
		// PRODUCTION
//		public String baseUrl = "https://vcreative.net/#/login";
		
		public static WebDriver driver;
		
		@BeforeTest
		public void launchBrowser() {
			
			// Chrome
			String driverPath = "/Users/junkim/Downloads/chromedriver";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			
			// Firefox
//			String driverPath = "/Users/junkim/Downloads/geckodriver";
//			System.setProperty("webdriver.gecko.driver", driverPath);
//			driver = new FirefoxDriver();
			
				
			driver.manage().window().maximize();
			
			driver.get(baseUrl);
			}
		
		@AfterTest
		public void terminateBrowser(){
			driver.close();
		
		}
		
	}