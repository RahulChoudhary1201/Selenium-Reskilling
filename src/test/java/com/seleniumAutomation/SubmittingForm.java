package com.seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SubmittingForm extends BaseTest {

	@Test
	public void submittingForm() {
		driver.get("https://www.globalsqa.com/samplepagetest/");
		driver.findElement(By.id("g2599-name")).sendKeys("Rahul Choudhary");
		driver.findElement(By.id("g2599-email")).sendKeys("rk155898@gmailcom");
		driver.findElement(By.id("g2599-website")).sendKeys("www.example.com");

		WebElement experience = driver.findElement(By.id("g2599-experienceinyears"));
		Select se = new Select(experience);
		se.selectByValue("3-5");

		driver.findElement(By.xpath("//input[@value='Functional Testing']")).click();
		driver.findElement(By.xpath("//input[@value='Automation Testing']")).click();
		driver.findElement(By.xpath("//input[@value='Manual Testing']")).click();

		driver.findElement(By.xpath("//input[@value='Graduate']")).click();
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//textarea[@id='contact-form-comment-g2599-comment']"))
				.sendKeys("sampel comment.");
		driver.findElement(By.xpath("//textarea[@id='contact-form-comment-g2599-comment']")).submit();
	}

}
