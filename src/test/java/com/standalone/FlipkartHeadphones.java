package com.standalone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumAutomation.BaseTest;

public class FlipkartHeadphones extends BaseTest {

	public void closingPopUp() {
		driver.get("http://www.flipkart.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'✕')])[1]")));

		driver.findElement(By.xpath("(//button[contains(text(),'✕')])[1]")).click();
		driver.findElement(By.name("q")).sendKeys("Sony headphones");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sony')]")));

		//Getting the name of the product
		String productName = driver
				.findElement(By.xpath("(//a[normalize-space()='SONY ZX110A Wired without Mic Headset'])[1]"))
				.getAttribute("title");
		//continue from step 4 -> add to cart
		
	}

}
