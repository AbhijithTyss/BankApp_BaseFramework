package accounts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.tyss.bank.genericutility.BaseClass;

public class CreateAccount extends BaseClass{
	@Test
	public void createSavingsAccount() throws IOException, InterruptedException {
		Faker faker=new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String fatherName = faker.name().firstName();
		String motherName = faker.name().firstName();
		String email = faker.internet().safeEmailAddress().replace("example", "gmail");
		String address = faker.address().fullAddress();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String BM_email = fileLib.getDataFromPropertyFile("BM_email");
		String BM_password = fileLib.getDataFromPropertyFile("BM_password");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.linkText("Employee")).click();
		driver.findElement(By.id("email")).sendKeys(BM_email);
		driver.findElement(By.id("password")).sendKeys(BM_password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//p[text()='Accounts']")).click();
		driver.findElement(By.linkText("All Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("middlename")).sendKeys("S");
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		webLib.selectValuesInListbox(driver.findElement(By.id("nameprefix")),"1");
		driver.findElement(By.id("fatherName")).sendKeys(fatherName);
		driver.findElement(By.id("motherName")).sendKeys(motherName);
		driver.findElement(By.id("male")).click();
//		webLib.jsEnterData(driver, driver.findElement(By.id("dob")), "1998-01-01");
		webLib.selectValuesInListbox(driver.findElement(By.id("maritalstatus")), "1");
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("panNumber")).sendKeys("NVPA3421");
		driver.findElement(By.id("phoneNumber")).sendKeys(phoneNumber);
		webLib.selectValuesInListbox(driver.findElement(By.id("qualification")), "1");
		webLib.selectValuesInListbox(driver.findElement(By.id("occupation")), "1");
		driver.findElement(By.id("annualIncome")).sendKeys("400000");
		driver.findElement(By.id("address")).sendKeys(address);
		webLib.selectValuesInListbox(driver.findElement(By.id("country")), "India");
		webLib.selectValuesInListbox(driver.findElement(By.id("State")), "Karnataka");
		webLib.selectValuesInListbox(driver.findElement(By.id("city")), "Bengaluru");
		driver.findElement(By.id("pincode")).sendKeys("560078");
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dob').value='1998-01-01'");
		Thread.sleep(5000);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement nextButton = driver.findElement(By.xpath("(//a[@href='/bankmanager/create-account'])[2]"));
//		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
//		nextButton.click();
//		Thread.sleep(10000);
//		Actions act=new Actions(driver);
//		act.sendKeys(Keys.TAB).perform();
//		act.sendKeys(Keys.ENTER).perform();
		js.executeScript("arguments[0].click()", nextButton);
		Thread.sleep(10000);
	}
}
