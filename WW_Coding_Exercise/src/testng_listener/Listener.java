package testng_listener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReport.ExtentReport_Imp;

public class Listener implements ITestListener{
public ExtentReports extent;	
public ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//ExtentTestManager.startTest(result.getMethod().getMethodName());
		//ExtentTestManager.getTest().log(Status.INFO, "Test Started");
		test = extent.createTest(result.getMethod().getMethodName());
		ExtentReport_Imp.test = test;
		test.log(Status.INFO, "Test Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		test.log(Status.PASS, "Test Passed");
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed");
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		extent = ExtentReport_Imp.getinstance();
		}

	@Override
	public void onFinish(ITestContext context) {
		
		
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	
	
	
	
	
	
}
