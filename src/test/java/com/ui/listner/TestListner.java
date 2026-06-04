package com.ui.listner;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.browserUtility;
import com.utility.loggerUtility;

public class TestListner implements ITestListener{

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	
	private static ThreadLocal<ExtentTest>  extentTest= new ThreadLocal<ExtentTest>();
	
	Logger logger=loggerUtility.getLogger(this.getClass());
	
	 public void onTestStart(ITestResult result) {
		    logger.info(result.getMethod().getMethodName());
		    logger.info(result.getMethod().getDescription());
		    logger.info(Arrays.toString(result.getMethod().getGroups()));
		    
		    ExtentTest test= extentReports.createTest(result.getMethod().getMethodName());
		    extentTest.set(test);
		  }

		 public void onTestSuccess(ITestResult result) {
		    logger.info(result.getMethod().getMethodName()+ " " +"Passed");
		    extentTest.get().log(Status.PASS,result.getMethod().getMethodName()+ " " +"Passed" );
		  }

		  public void onTestFailure(ITestResult result) {
		   logger.error(result.getMethod().getMethodName()+" " + "Failed");
		   logger.error(result.getThrowable().getMessage());
		   extentTest.get().log(Status.FAIL,result.getMethod().getMethodName()+ " " +"Failed" );
		   extentTest.get().log(Status.FAIL,result.getThrowable().getMessage());
		   
		  String screenshotpath= browserUtility.takeScreenshot(result.getMethod().getMethodName());
		  extentTest.get().addScreenCaptureFromPath(screenshotpath);
		  }

		 public void onTestSkipped(ITestResult result) {
			 logger.warn(result.getMethod().getMethodName()+" " + "Skipped");
			   logger.warn(result.getThrowable().getMessage());
			   extentTest.get().log(Status.SKIP,result.getMethod().getMethodName()+ " " +"Skipped" );
			   extentTest.get().log(Status.SKIP,result.getThrowable().getMessage());
		 }

		 public void onStart(ITestContext context) {
		    logger.info("Test suite Started");
		    extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//report.html");
		    extentReports = new ExtentReports();
		    extentReports.attachReporter(extentSparkReporter);
		  }

		  public void onFinish(ITestContext context) {
			  logger.info("Test suite Completed");
			  extentReports.flush();
		  }
}
