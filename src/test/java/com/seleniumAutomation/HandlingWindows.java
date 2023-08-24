package com.seleniumAutomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingWindows extends BaseTest {

	@Test
	public void handlingFramesAndWindows() {
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#");

		String homePageTitle = driver.getTitle();
		driver.findElement(By.id("Open New Window")).click();
		driver.findElement(By.xpath("(//a[text()='Click Here'])[2]")).click();

		Set<String> windowIds = driver.getWindowHandles();
		for (String wName : windowIds) {
			driver.switchTo().window(wName);
		}
		String newWindowTitle = driver.getTitle();

		Assert.assertEquals(homePageTitle, newWindowTitle);
		System.out.println("Both Page has the same title.");

	}

}
