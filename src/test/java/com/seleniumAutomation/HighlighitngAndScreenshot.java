package com.seleniumAutomation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HighlighitngAndScreenshot extends BaseTest {

	@Test
	public void highlightingAndSShot() throws InterruptedException, IOException {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement searchBox = driver.findElement(By.xpath("//div[@class='RNNXgb']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid yellow;');",
				searchBox);
//		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));

		// tacking screenshot
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\Screenshots\\SearchPage.png");
		FileUtils.copyFile(src, trg);

	}

}
