package com.seleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MouseHoveringAction extends BaseTest {

	@Test
	public void selectingRange() throws InterruptedException {
		driver.get("https://www.globalsqa.com/demo-site/sliders/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='resp-tabs-list ']//li[2]")));
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@class='resp-tabs-list ']//li[2]")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//iframe[@class='demo-frame lazyloaded'])[2]")));
		WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame lazyloaded'])[2]"));
		driver.switchTo().frame(frame);

		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//span[1]"))).moveByOffset(33, 0).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//span[2]"))).moveByOffset(137, 0).click().build().perform();
//		Thread.sleep(2000);

	}
}
