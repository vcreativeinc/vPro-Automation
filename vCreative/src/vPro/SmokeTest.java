package vPro;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SmokeTest extends BaseTest {

	@Test
	public void login() throws InterruptedException
	{	
		// Logging in with sales executive credentials
		WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(30));
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
	}
	
	@Test
	public void newRequest() throws InterruptedException
	{
		WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(30));
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='New Request']")));
		driver.findElement(By.xpath("//span[normalize-space()='New Request']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Select an Ad Type')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@aria-label='TV Ad (Open submit)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='client_id']")).sendKeys("duff");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//body/app-root[1]/app-root[1]/div[1]/app-quickorders[1]/div[1]/vsidebar[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/vforms[1]/div[1]/form[1]/div[5]/div[1]/div[5]/div[1]/div[1]/vfield[1]/div[1]/div[1]/p-autocomplete[1]/span[1]/div[1]/ul[1]/li[2]/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("card_spot_title")).click();
		driver.findElement(By.name("card_spot_title")).sendKeys("JUN TEST");
		driver.findElement(By.xpath("//span[contains(text(),'Select Status')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@aria-label='Needs Producing']")).click();
		Thread.sleep(2000);		
		driver.findElement(By.name("card_rotationpercent")).click();
		driver.findElement(By.name("card_rotationpercent")).sendKeys("100");
		
		// Due Date, Start and end date
		driver.findElement(By.xpath("//body/app-root[1]/app-root[1]/div[1]/app-quickorders[1]/div[1]/vsidebar[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/vforms[1]/div[1]/form[1]/div[5]/div[1]/div[13]/div[1]/div[1]/vfield[1]/div[1]/div[1]/p-calendar[1]/span[1]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body[1]/div[5]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[3]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body[1]/div[5]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[3]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body[1]/div[5]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/a[1]")).click();
		Thread.sleep(2000);
		
		// Client Billing Status
		driver.findElement(By.xpath("//*[@id=\"layoutWrapper\"]/app-quickorders/div/vsidebar/div/div/div[2]/div[2]/div[3]/div[1]/div/vforms/div/form/div[5]/div/div[28]/div/div/vfield/div/div/p-dropdown/div/div[2]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Approved Credit')]")).click();
		Thread.sleep(2000);
		
		// Lengths
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//*[@id=\"layoutWrapper\"]/app-quickorders/div/vsidebar/div/div/div[2]/div[2]/div[3]/div[1]/div/vforms/div/form/div[5]/div/div[30]/div/div/vfield/div/div/p-multiselect/div/div[2]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[5]/div[2]/ul[1]/p-multiselectitem[1]/li[1]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Submit All')]")).click();
		Thread.sleep(4000);
		
		// Verify the created spot
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Duff Beer')]")));
		String spot = driver.findElement(By.xpath("//a[contains(text(),'Duff Beer')]")).getText();
		String expected = "Duff Beer";
		Assert.assertEquals(spot, expected);
		
		// Log out
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")));
		driver.findElement(By.xpath("//app-header/div[1]/div[2]/div[4]/span[1]/span[1]/span[2]")).click();
		Thread.sleep(2000);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Logout')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		System.out.println("PASS Smoke Test");
		
		
	}
}


