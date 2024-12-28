package CreatingReport.ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessMode {
	
	@Test
	public void initialDemo()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");  // tells the chromedriver to run in headless mode
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.findElement(By.id("inputUsername")).sendKeys("Yash");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Yash123");
		driver.findElement(By.cssSelector("button.signInBtn")).click();
		
	}


}
