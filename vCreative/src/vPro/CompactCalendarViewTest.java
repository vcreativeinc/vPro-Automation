package vPro;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class CompactCalendarViewTest extends BaseTest {
	
	@Test
	public void compactView() throws InterruptedException
	{	
		// Logging in with sales executive credentials
		WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(40));
		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("username")));
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("imail-test+DemoSalesExec@vcreativeinc.com");		
		driver.findElement(By.id("password")).clear();	
		driver.findElement(By.id("password")).sendKeys("GoTeamvC21!");	
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
		
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//body//app-root//button[3]")));
		driver.findElement(By.xpath("//body//app-root//button[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Compact']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//h2)[1]")).click();
		driver.findElement(By.xpath("//body//app-root//button[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Calendar']")).click();
		Thread.sleep(3000);
		
		
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")));
		driver.findElement(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")).click();
		Thread.sleep(2000);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Logout')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		System.out.println("PASS Compact, Calendar view Test");

}
}