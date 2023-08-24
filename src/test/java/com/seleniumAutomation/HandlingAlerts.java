package com.seleniumAutomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandlingAlerts extends BaseTest {

	@Test
	public void handlingAlerts() throws InterruptedException {
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		alert.accept();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		driver.switchTo().alert().sendKeys("Rahul Choudhary");
		Thread.sleep(2000);
	}

}
