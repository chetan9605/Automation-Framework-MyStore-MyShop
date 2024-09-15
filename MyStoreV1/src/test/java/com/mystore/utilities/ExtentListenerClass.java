package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentListenerClass implements ITestListener{

	ExtentSparkReporter  htmlReporter; // It is use for look and feel of the report UI of report 
	ExtentReports reports;             //useful for common info of the report like tester name,browser name, operating system name , module name
	ExtentTest test;                  //update reports like test case pass, fail ,skip update status of the test methods
	
	public void configureReport()
	{
		
		 Properties p=new Properties();
		//ReadConfig readConfig = new ReadConfig
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyStoreTestReport-" + timestamp + ".html";   // Document name
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName); //here we mention location of report
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "Chetan"); // key and value pair
		reports.setSystemInfo("OS", "windows 10");
	//	reports.setSystemInfo("browser:", readConfig.getBrowser());
	    reports.setSystemInfo("browser:", "chrome");
	//	reports.setSystemInfo("browser:", p.getProperty("browser"));

		reports.setSystemInfo("user name:", "Chetan");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my First Report");
		htmlReporter.config().setTheme(Theme.DARK);
		                               
		                       // this is a template that we are created now we use this
	}

	//OnStart method is called when any Test starts.
	public void onStart(ITestContext Result)	     				
	{		
		configureReport();
		System.out.println("On Start method invoked....");  		
	}	

	//onFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result) 					
	{		
		System.out.println("On Finished method invoked....");  	
		reports.flush();//it is mandatory to call flush method to ensure information is written to the started reporter.

	}		



	// When Test case get failed, this method is called.		

	public void onTestFailure(ITestResult Result) 					
	{		
		System.out.println("Name of test method failed:" + Result.getName() );  		
		test = reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
	
	String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";
	
	File screenShotFile = new File(screenShotPath);
	
	if(screenShotFile.exists())
	{
		test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		
	}
	
	//	test.addScreenCaptureFromPath(null)
		
	}		

	// When Test case get Skipped, this method is called.		

	public void onTestSkipped(ITestResult Result)					
	{		
		System.out.println("Name of test method skipped:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
	}			

	// When Test case get Started, this method is called.		

	public void onTestStart(ITestResult Result)					
	{		
		System.out.println("Name of test method started:" + Result.getName() );  		

	}		

	// When Test case get passed, this method is called.		

	public void onTestSuccess(ITestResult Result)	   // parameter we use result for capture test case pass or fail or skip				
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() ); // It will create new entry in report when test case pass 		

		test = reports.createTest(Result.getName());  // result will give name or test case
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));  // update test case pass or fail
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}		          // all method must be address if we dont implement no problem


	
}
