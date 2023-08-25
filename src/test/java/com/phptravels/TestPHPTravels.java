package com.phptravels;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumAutomation.BaseTest;

public class TestPHPTravels extends BaseTest {

	@Test(dataProvider = "myData")
	public void test1(String email, String password) {
//		System.out.println(email + " || " + password);
		driver.get("https://phptravels.org/login");
		driver.findElement(By.id("inputEmail")).sendKeys(email);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//iframe[@title='reCAPTCHA']")));
		
		WebElement iFrame=driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
		driver.switchTo().frame(iFrame);
		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']")));
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		System.out.println(errorMsg);
		
	}

	@DataProvider(name = "myData")
	public Object[][] excelDataReader() throws Exception {
		Object[][] data = ExcelReader.excelReader(
				"C:\\Users\\2122119\\eclipse-workspace\\Selenium\\src\\test\\java\\com\\testdata",
				"PHPTravels_TestData.xlsx", "Sheet1");
		return data;
	}
	
}
