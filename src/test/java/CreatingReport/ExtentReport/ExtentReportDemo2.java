package CreatingReport.ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo2 {
	
	public static ExtentReports extent;
	
	
	@Test
	public void initialDemo()
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.findElement(By.id("inputUsername")).sendKeys("Yash");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Yash123");
		driver.findElement(By.cssSelector("button.signInBtn")).click();
		
	}

}
