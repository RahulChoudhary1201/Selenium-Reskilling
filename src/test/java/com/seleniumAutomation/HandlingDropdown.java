package com.seleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandlingDropdown extends BaseTest {

	String url = "https://www.facebook.com/reg/";

	@Test
	public void capturingErrorMsg() {
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Choudhary");
		driver.findElement(By.xpath("(//input[contains(@name,'reg_email')])[1]")).sendKeys("1234567890");
		driver.findElement(By.id("password_step_input")).sendKeys("Rahul@123#");

		WebElement dayDropdown = driver.findElement(By.id("day"));
		Select select = new Select(dayDropdown);
		select.selectByValue("12");

		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByIndex(1);// Mar -> for selectByVisibleText.

		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("2000");

		driver.findElement(By.xpath("(//input[contains(@name,'sex')])[2]")).click();
		driver.findElement(By.xpath("//button[contains(@name,'websubmit')]")).click();

		// div[@id='reg_error_inner']
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_error_inner")));

		String errorMsg = driver.findElement(By.xpath("//div[@id='reg_error_inner']")).getText();
		System.out.println(errorMsg);
	}

}
