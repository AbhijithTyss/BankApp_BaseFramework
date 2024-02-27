package com.tyss.bank.genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUtility extends BaseClass implements ITestListener,ISuiteListener{

	@Override
	public void onTestFailure(ITestResult result) {
		String TIME = javaLib.getSystemTime().toString().replace(":", "-");
		String methodName = result.getName();
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		test.addScreenCaptureFromBase64String(screenshot.getScreenshotAs(OutputType.BASE64));
		File temp = screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+methodName+"_"+TIME+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
