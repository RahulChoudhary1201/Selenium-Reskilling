package com.seleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingAmazon {

	// Searching Of Redmi phone on amazon and selct range 10000 - 20000 and click on
	// top brands then print the top searched result.
	WebDriver driver;

	@Test
	public void openingAmazon() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Redmi note 12");
		driver.findElement(By.id("nav-search-submit-button")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='priceRefinements']//span[@class='a-size-base a-color-base'])[4]")));

		driver.findElement(By.xpath("(//div[@id='priceRefinements']//span[@class='a-size-base a-color-base'])[4]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base'][normalize-space()='Redmi']")));

		driver.findElement(By.xpath(
				"//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base'][normalize-space()='Redmi']"))
				.click();

		String modelName = driver.findElement(By.xpath("//div[@data-index='3']//h2")).getText();
		System.out.println(modelName);

		Thread.sleep(2000);
		driver.quit();

	}

}
