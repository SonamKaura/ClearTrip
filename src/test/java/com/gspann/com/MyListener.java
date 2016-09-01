package com.gspann.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class MyListener implements ITestListener
{
	WebDriver driver;
	
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart-"+result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess-"+result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Taking screenshot");
//		ClearTrip.driver=coz we want to access the driver which we have used in our testclass.
		File file=((TakesScreenshot)(ClearTripTest.driver)).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("D:/sonam/s1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("onTestFailure-"+result.getName());


	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped-"+result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage-"+result.getName());

	}

	public void onStart(ITestContext context) {
		System.out.println("onStart-"+context.getName());

	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish-"+context.getName());

	}

}
