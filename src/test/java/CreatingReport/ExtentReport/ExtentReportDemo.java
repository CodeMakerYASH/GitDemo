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

public class ExtentReportDemo {
	
	public static ExtentReports extent;
	
	@BeforeTest
	public static ExtentReports getReportObject()
	{
		// main classes - "ExtentReports , ExtentSparkReporter"
		
		// Sets the file path for the report & Configures the title, name, and theme of the report

		String path = System.getProperty("user.dir") + "\\report\\index.html";
		
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Device farm Automation");
		report.config().setDocumentTitle("FOS7 device");
		report.config().setTheme(Theme.DARK);
		
		// Initialize ExtentReports and attach the Spark reporter
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Yashwanth");
		
		return extent;
		
	}
	
	@Test
	public void initialDemo()
	{
		// ExtentTest class - log the progress, status, and results of a test.
		// Log test steps (info, pass, fail, skip) & Attach screenshots.

		ExtentTest test = extent.createTest("Initial Demo Testcase");  // starts monitering the execution
		test.info("Starting the test");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		driver.findElement(By.id("inputUsername")).sendKeys("Yash");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Yash123");
		driver.findElement(By.cssSelector("button.signInBtn")).click();
		
		test.fail("Test failed").addScreenCaptureFromPath("screenshot.png"); // fails & takes screenShot
		
		extent.flush(); //makes it stop listening
	}

}
