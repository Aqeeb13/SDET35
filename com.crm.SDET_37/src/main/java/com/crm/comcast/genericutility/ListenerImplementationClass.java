package com.crm.comcast.genericutility;

import java.io.File;
import org.testng.ITestListener;
import org.testng.ITestResult;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		/*String testName = result.getMethod().getMethodName();
		System.out.println(testName+"========Executing========");
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./ScreenShot/"+testName+".PNG"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
	    try {
	    	String screenShotName;
				screenShotName = WebDriverUtility.takeScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/report.html");
		
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("Framework Extent Report");
		spark.config().setDocumentTitle("Aqeeb's document");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("createdBy", "Aqeeb");
		report.setSystemInfo("ReviwedBy", "Deepak");
		report.setSystemInfo("platform", "windows11");
		report.setSystemInfo("ServerName","ApacheTomcat");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
