package com.standalone;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumAutomation.BaseTest;

public class FlipkartHeadphones extends BaseTest {

	public void waitingForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	String productName = null;

	@Test(priority = 0)
	public void closingPopUp() {
		driver.get("http://www.flipkart.com/");
		waitingForElement(By.xpath("(//button[contains(text(),'✕')])[1]"));
		try {
			WebElement popUp = driver.findElement(
					By.xpath("(//button[contains(text(),'✕')])[1]"));
			if (popUp.isDisplayed()) {
				Set<String> windowIDs = driver.getWindowHandles();
				for (String windowId : windowIDs) {
					driver.switchTo().window(windowId);
				}
				driver.findElement(
						By.xpath("(//button[contains(text(),'✕')])[1]"))
						.click();
				driver.switchTo().parentFrame();
				Thread.sleep(2000);
			}

		} catch (Exception e) {
			System.out.println("PopUp is not displayed.");
		}
	}
	@Test(priority = 1)
	public void searchingHeadphone() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='q']"))
				.sendKeys("Sony headphones");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		waitingForElement(By.xpath("//span[contains(text(),'Sony')]"));
		productName = driver.findElement(By.xpath(
				"(//a[normalize-space()='SONY ZX110A Wired without Mic Headset'])[1]"))
				.getAttribute("title");
		System.out.println("Product Name on the home page: " + productName);
		driver.findElement(By.xpath(
				"(//a[normalize-space()='SONY ZX110A Wired without Mic Headset'])[1]"))
				.click();

	}

	@Test(priority = 2)
	public void switchingToNextWindow() {
		Set<String> searchWindowID = driver.getWindowHandles();
		for (String windowId : searchWindowID) {
			driver.switchTo().window(windowId);
		}
		waitingForElement(By.xpath("//span[contains(text(),'SONY ZX110A')]"));
		String text = driver
				.findElement(By.xpath("//span[contains(text(),'SONY ZX110A')]"))
				.getText();
		WebElement errorMsg = driver
				.findElement(By.xpath("//div[contains(text(),'Currently')]"));
		System.out.println(errorMsg.getText());
		Assert.assertNotEquals(productName, text,
				"Product Name not matched with the searched result.");

	}

}
