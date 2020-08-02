package testng_listener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import freemarker.core.CustomAttribute;

public class Listener implements ITestListener{
public ExtentReports extent;	
public ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test.log(Status.INFO, "Test Started");
		/*
		 * Assertion. List<CustomAssertions.AssertionInfo> assertions =
		 * (List<CustomAssertions.AssertionInfo>)
		 * method.getAttribute(CustomAssertions.ASSERTIONS);
		 */
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed");
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
		
	 test =	extent.createTest("Test Started");
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		extent.flush();
	}
	
	
	
	
	
	
}
