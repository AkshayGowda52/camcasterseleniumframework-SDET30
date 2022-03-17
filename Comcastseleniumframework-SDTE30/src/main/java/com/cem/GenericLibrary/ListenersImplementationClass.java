package com.cem.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener
{
	ExtentReports report=null;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName +"----testscript execution started",true);
	}

	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName +"----testscript execution sucessfull - PASS",true);
	}

	public void onTestFailure(ITestResult result) {
		
		String path=null;
		
		String MethodName = result.getMethod().getMethodName()+"-";
		
		
		//Step 1: configure screeshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFromate();
		System.out.println(screenshotName);
		
		//Step 2: using screenshotname method from webdriver utility
		try {
			path=new WebDriverUtility().getScreenShot(BaseClass.sdriver, screenshotName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName()+"-";
		test.log(Status.SKIP, MethodName+"------>Skipped");
		
		//it will capture the exception and log it in the report
		test.log(Status.SKIP, result.getThrowable());
		
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		//execution will start here
		/* configure the report*/
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFromate()+".html");
		htmlreporter.config().setDocumentTitle("SDET-30 ExecutionReport");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("Selenium Execution Report");
		
	    report = new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Base-browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Baer-url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Akshay");
		
	}

	public void onFinish(ITestContext context) {
		//consolidate all the parameters and generate the report
		report.flush();
		
	}
    
}
