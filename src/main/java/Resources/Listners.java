package Resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.Orange.qa.base.TestBase;
import Resources.ExtentReportNG;

public class Listners extends TestBase implements ITestListener{
	
	ExtentTest test;
	
	ExtentReports extent=ExtentReportNG.getReportObject();
	
	ThreadLocal<ExtentTest>extenttest=new ThreadLocal<ExtentTest>();
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		//ScreenShot--Fail TestCases
		
		extenttest.get().fail(result.getThrowable());
		
		WebDriver driver=null;
		
		String testmethodname=result.getMethod().getMethodName();
		
		try {
			
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			
			extenttest.get().addScreenCaptureFromPath(getScreenshotAs(testmethodname),result.getMethod().getMethodName());
			
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
			
	}

	public void onTestSuccess(ITestResult result) {
		
		extenttest.get().log(Status.PASS,"Test Passed");
		
	}



	public Listners() throws IOException {
		super();
	}

}
