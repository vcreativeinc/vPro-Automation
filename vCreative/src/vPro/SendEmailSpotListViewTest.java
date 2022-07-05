package vPro;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SendEmailSpotListViewTest extends BaseTest {
	
	@Test
	public void sendEmail() throws InterruptedException
	{	
		
		// Regression item VC2-5601
		// Verify that users can attach files and script from the send email tool
		
		
		// Logging in with sales executive credentials
		WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(40));
		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("username")));
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("imail-test+DemoSalesExec@vcreativeinc.com");		
		driver.findElement(By.id("password")).clear();	
		driver.findElement(By.id("password")).sendKeys("GoTeamvC21!");	
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
		Thread.sleep(5000);
		
		
		// Search for test spot
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/icons/search-filter.svg']")));
		driver.findElement(By.xpath("//img[@src='./assets/img/icons/search-filter.svg']")).click();
		driver.findElement(By.id("spot_title")).click();
		driver.findElement(By.id("spot_title")).sendKeys("JUN SEND EMAIL TEST (DO NOT TOUCH)");
		driver.findElement(By.id("do-search-btn")).click();
		Thread.sleep(4000);
		
		String text = driver.findElement(By.xpath("//span[contains(text(),'Title: JUN SEND EMAIL TEST (DO NOT TOUCH)')]")).getText();
		String textToCheck = "TITLE: JUN SEND EMAIL TEST (DO NOT TOUCH)";
		Assert.assertEquals(textToCheck, text);
		
		
		// Sending Email modal
		driver.findElement(By.xpath("//a[normalize-space()='Send Email']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[normalize-space()='Spot: JUN SEND EMAIL TEST (DO NOT TOUCH)']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[normalize-space()='Script']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[normalize-space()='Prod File: Final Video Snip 27.mp4']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("p-footer[class='ui-md-12'] button[type='submit'] span[class='ui-button-text ui-clickable']")).click();
		Thread.sleep(3000);
		// Confirmation page
		driver.findElement(By.xpath("//span[normalize-space()='YES, CONFIRM']")).click();
		
		
		// Logout
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")));
		driver.findElement(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")).click();
		Thread.sleep(6000);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Logout')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		System.out.println("PASS Send Email Test");

}
}