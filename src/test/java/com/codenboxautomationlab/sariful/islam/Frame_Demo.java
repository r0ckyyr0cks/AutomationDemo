package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frame_Demo {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver = new ChromeDriver(chromeOptions);
				
		//delete all cookies
		driver.manage().deleteAllCookies();
				
		//pageload timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://codenboxautomationlab.com/practice/");
												
		//global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
												
		//maximize window
		driver.manage().window().maximize();
		
		List<WebElement> frames = driver.findElements(By.xpath("//iframe | //frame"));
		System.out.println("Total number of frames on page: " + frames.size());
		
		driver.switchTo().frame(0);
		String features = driver.findElement(By.xpath("//span[normalize-space()='Awesome features']")).getText();
		System.out.println(features);
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
