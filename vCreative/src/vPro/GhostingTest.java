package vPro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GhostingTest extends BaseTest {
	
	@Test
	public void ghosting() throws InterruptedException
	{	
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("jun@vcreativeinc.com");		
		driver.findElement(By.id("password")).clear();	
		driver.findElement(By.id("password")).sendKeys("Temp123!");	
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[4]//p-button[1]//button[1]")).click();
		WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(20));
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")));
		String user = driver.findElement(By.xpath("//span[@class='user-text']")).getText();
		System.out.println("Logged in as: " + user);
		String expected = "Jun Kim";
		Assert.assertEquals(expected, user);
		Thread.sleep(5000);

		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@placeholder='Ghost In As']")));
		
		// Jackson Telecasters/Bahakel - Chris Adams
		driver.findElement(By.xpath("//input[@placeholder='Ghost In As']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Ghost In As']")).sendKeys("Chris Adams");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'12425->Chris Adams (Jackson Telecasters LLC)')]")).click();
		Thread.sleep(8000);
		String ghost = driver.findElement(By.xpath("//span[@class='user-text']")).getText();
		System.out.println("Ghosted in as: " + ghost);
		String expectedghost = "Chris Adams";
		Assert.assertEquals(expectedghost, ghost);
		
		// Plymouth - Deborah Soares
		
		
		
		// Homeslice - MaryAnne Whittle
		
		
		
		// WSIL - Matt Linsin
		
		System.out.println("PASS Ghosting Test");
	}
}