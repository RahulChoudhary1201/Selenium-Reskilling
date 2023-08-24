package com.seleniumAutomation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WindowHandling extends BaseTest {

	// Window handling

	@Test
	public void windowHandling() throws InterruptedException {
		driver.get("http://www.amazon.in");

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Redmi note 12");
		driver.findElement(By.id("nav-search-submit-button")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-index='3']//h2")));
		driver.findElement(By.xpath("//div[@data-index='3']//h2")).click();

		Set<String> windowIDs = driver.getWindowHandles();
		for (String window : windowIDs) {
			driver.switchTo().window(window);
//			System.out.println("Window Title: " + windowTitle);
		}
 
		//Clicking on the cartbutton on the search page.
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

		//waiting for the element to visible.
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@id='attach-sidesheet-checkout-button']//span)[1]")));

		//Clicking on the cart button on the left side dynamic page displayed.
		driver.findElement(By.xpath("(//span[@id='attach-sidesheet-view-cart-button']//span)[1]")).click();
		
		//Waiting for delete element to visible on the cart page.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Delete']")));
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
	}

}
