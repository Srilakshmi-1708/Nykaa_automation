package com.nykaa.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nykaa.basetest.BaseClass;
import com.nykaa.basetest.RegisterBaseClass;
import com.nykaa.webdriverutility.UtilityClassObject;



public class ListImpClass extends RegisterBaseClass implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static  ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
		//Spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		//add environment info & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome");
		
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("== ==>"+result.getMethod().getMethodName()+">==START==");
	    test=report.createTest(result.getMethod().getMethodName());
	    UtilityClassObject.setTest(test);
	    test.log(Status.INFO,result.getMethod().getMethodName()+"==> STARTED <==" );
	}
 
	public void onTestSuccess(ITestResult result) {
		System.out.println("== ==>"+result.getMethod().getMethodName()+">==END ==");
		test.log(Status.PASS,result.getMethod().getMethodName()+"==> COMPLETED <==" );
	}
  
	  public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		TakesScreenshot t=(TakesScreenshot)sdriver;
		String filePath=t.getScreenshotAs(OutputType.BASE64);
		
		String time=new Date().toString().replace(" ", "_").replace(":", "_");

		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time) ;
		test.log(Status.FAIL,result.getMethod().getMethodName()+"==> FAILED <==" );
	}

	public void onTestSkipped(ITestResult result) {  
  

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}


   
}
