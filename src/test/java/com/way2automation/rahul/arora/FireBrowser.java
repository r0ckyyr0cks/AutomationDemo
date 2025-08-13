package com.way2automation.rahul.arora;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		String browser = "Chrome";
		
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("Chrome")) {
		
		// Ctrl + Shift + O to import
		driver = new ChromeDriver();
		
		}else if(browser.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
			
		}else if(browser.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
		}
		
		
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("ENTER TO THE TESTING WEBSITE")).click();
		
		System.out.println("Page Title => " + driver.getTitle());
		System.out.println("Page URL is => " + driver.getCurrentUrl());
		
		Thread.sleep(3000);
//		driver.close();
		driver.quit();

	}

}
