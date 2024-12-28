package TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CreatingReport.ExtentReport.ExtentReportDemo;

public class ListenersToImplementExtentReport extends ExtentReportDemo implements ITestListener {

	// classname.methodname
	ExtentReports extent = ExtentReportDemo.getReportObject();
	ExtentTest test;
	
	// When we run multiple testcases in parallel execution , the Extent report is wrongly showing the reports.
	// to make the object Thread Safe (ThreadLocal class) which prevents from interrupting other overriding variable 
	// and each object creation has its own Thread safe

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread Safe
	
	@Override
	public void onTestStart(ITestResult result) {

		ITestListener.super.onTestStart(result);
		
		test = extent.createTest(result.getMethod().getMethodName());  
		// on starting od the execution , it will monitor
		
		extentTest.set(test); // unique thread ID is assigned 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		
		test.log(Status.PASS, "Test is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		test.fail(result.getThrowable());
		String filepath = null;
		
		filepath = System.getProperty("user.dir")+"//reports//"+result.getMethod().getMethodName()+".png";
		
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		
		extent.flush();
	}

}
