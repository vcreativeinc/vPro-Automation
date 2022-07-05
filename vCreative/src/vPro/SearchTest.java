package vPro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

	@Test
	public void search() throws InterruptedException
	{	
		// Logging in with sales executive credentials
		WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(15));
		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("username")));
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("imail-test+DemoSalesExec@vcreativeinc.com");		
		driver.findElement(By.id("password")).clear();	
		driver.findElement(By.id("password")).sendKeys("GoTeamvC21!");	
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
		
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")));
		String user = driver.findElement(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")).getText();
		System.out.println("Logged in as: " + user);
		String expected = "Demo Sales Executive";
		Assert.assertEquals(expected, user);
		Thread.sleep(4000);
		
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='./assets/img/icons/search-filter.svg']")));
		driver.findElement(By.xpath("//img[@src='./assets/img/icons/search-filter.svg']")).click();
		driver.findElement(By.id("spot_title")).click();
		driver.findElement(By.id("spot_title")).sendKeys("JUN TEST");
		driver.findElement(By.id("do-search-btn")).click();
		Thread.sleep(4000);
		
		String text = driver.findElement(By.xpath("(//span[contains(text(),'Title: JUN TEST')])[1]")).getText();
		String textToCheck = "TITLE: JUN TEST";
		Assert.assertEquals(textToCheck, text);
		
		// Log out
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")));
		driver.findElement(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")).click();
		Thread.sleep(2000);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Logout')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		System.out.println("PASS Search Test");
		
		
	}
}
