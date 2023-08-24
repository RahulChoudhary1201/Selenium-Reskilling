package com.standalone;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampleClass {

	public void captureWindow() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("sample url");
		
		Set<String> windowIds=driver.getWindowHandles();
		
		try {
			for (String string : windowIds) {
				driver.switchTo().window("id");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
	}

}
