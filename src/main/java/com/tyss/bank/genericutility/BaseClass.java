package com.tyss.bank.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverWait explicitWait;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public JavaUtility javaLib=new JavaUtility();
	public FileUtility fileLib=new FileUtility();
	public WebDriverUtility webLib=new WebDriverUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void reportConfiguration() {
		String TIME = javaLib.getSystemTime().toString().replace(":", "-");
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport_"+TIME+".html");
		spark.config().setDocumentTitle("Execution Report");
		spark.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(spark);
	}
	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void browserSetup(@Optional("chrome") String browserName) throws IOException {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else{
			Reporter.log("Invalid browser name",true);
		}	
		String URL = fileLib.getDataFromPropertyFile("url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		explicitWait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get(URL);
		Reporter.log("Browser launched and Url is entered");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void reportBackup() {
		reports.flush();	
	}
}
