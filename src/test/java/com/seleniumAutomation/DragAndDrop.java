package com.seleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseTest {

	@Test
	public void dragAndDrop() throws InterruptedException {
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
//		Thread.sleep(3000);
		int iframeNum = driver.findElements(By.tagName("iframe")).size();
		System.out.println(iframeNum);
		WebElement iFrame = driver.findElement(By.xpath("(//iframe[@class='demo-frame lazyloaded'])[1]"));
		driver.switchTo().frame(iFrame);
		System.out.println("Switched to Iframe.");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Delete this image'])[1]")));
//		driver.findElement(By.xpath("(//a[@title='Delete this image'])[1]")).click();
//		Thread.sleep(2000);
		WebElement source = driver.findElement(By.xpath("//li[1]"));
		WebElement dest = driver.findElement(By.id("trash"));
		WebElement img_3 = driver.findElement(By.xpath("//ul[@id='gallery']//li[2]"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, dest).build().perform();
		action.clickAndHold(img_3).moveToElement(dest).release().build().perform();
//		action.perform();
		Thread.sleep(3000);
	}

}
