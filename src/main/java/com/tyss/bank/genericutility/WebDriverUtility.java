package com.tyss.bank.genericutility;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public void switchToWindowByUrl(WebDriver driver,String url) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().equals(url)){
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver,String title){
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			if(driver.getTitle().equals(title)){
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * 
	 * @param  driver 
	 * @return Alert type of object reference
	 */
	
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void selectValuesInListbox(WebElement element, String indexOrvalueOrVisibleText) {
		Select listbox=new Select(element);
		try {
			int index = Integer.parseInt(indexOrvalueOrVisibleText);
			System.out.println(index);
			listbox.selectByIndex(index);
		} catch (NumberFormatException e) {
			System.out.println("value is not index");
			System.out.println(indexOrvalueOrVisibleText);
			try {
				listbox.selectByValue(indexOrvalueOrVisibleText);
			} catch (Exception e2) {
				listbox.selectByVisibleText(indexOrvalueOrVisibleText);
			}
		}
	}
	public void jsEnterData(WebDriver driver,WebElement element,String value) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+value+"'",element);
	}
}
