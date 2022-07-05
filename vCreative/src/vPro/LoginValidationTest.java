package vPro;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginValidationTest extends BaseTest {

	@Test
	public void loginValidation() throws InterruptedException 
	{
		// Logging in with invalid credentials
		WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(10));
		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("username")));
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("imail-test+DemoSalesExec@vcreativeinc.com");		
		driver.findElement(By.id("password")).clear();	
		driver.findElement(By.id("password")).sendKeys("fGoTeamvC21!");	
		driver.findElement(By.id("password")).sendKeys(Keys.RETURN);
		
		d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='alert'][normalize-space()='Invalid credentials']")));
		String error = driver.findElement(By.xpath("//div[@role='alert'][normalize-space()='Invalid credentials']")).getText();
		System.out.println("PASS " + error + " Test");
		String expected = "Invalid credentials";
		Assert.assertEquals(expected, error);

	}
}
		