package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tyss.bank.genericutility.BaseClass;
import com.tyss.bank.genericutility.WebDriverUtility;

public class Sample extends BaseClass{
	@Test
	public void run() {
		Reporter.log("Test case is running");
		driver.findElement(By.partialLinkText("BOOKS")).click();
		WebElement sortByDropdown = driver.findElement(By.id("products-orderby"));
		WebDriverUtility webdriverLib=new WebDriverUtility();
		webdriverLib.selectValuesInListbox(sortByDropdown, "Name: Z to A");
	}
}