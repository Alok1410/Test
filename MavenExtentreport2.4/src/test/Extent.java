package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent extends aLOK
{

	static ExtentReports report;
	//helps to generate the logs in test report.
	static ExtentTest Logger;

	@BeforeClass

	public static void startTest()

	{
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html", true);

	}

	@Test
	public void test1()
	{
		Logger = report.startTest("test1");
		System.out.println("This test passed successfully");

	}

	@Test
	public void test2()
	{
		Logger = report.startTest("test2");
		System.out.println("This test passed successfully");

	}

	@Test
	public void call()
	{
		Logger = report.startTest("call");
		aLOK a = new aLOK();
		a.test();
		//Logger = report.startTest("test");
		a.testalok();
		//Logger = report.startTest("testalok");

	}

	@Test
	public void call2()
	{
		Logger = report.startTest("call2");
		aLOK a = new aLOK();
		a.testalok();
		//Logger = report.startTest("testalok");

	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			Logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			Logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			Logger.log(LogStatus.FAIL, Logger.addScreenCapture(capture(d)) + "Test Failed");

		}

		/* public static String capture(WebDriver driver) throws IOException { File
		 * scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputsType.FILE);
		 * File Dest = new File("src/../ErrImages/" + System.currentTimeMillis() +
		 * ".png"); String errflpath = Dest.getAbsolutePath();
		 * FileUtils.copyFile(scrFile, Dest); return errflpath; } */

		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			Logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
		}

		//report.endTest(Logger);
	}

	public static String capture(WebDriver driver) throws IOException
	{
		File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

	@AfterClass

	public static void endTest()

	{

		report.flush();

	}

}
