package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calendar_Demo {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		//delete all cookies
		driver.manage().deleteAllCookies();
		
		//pageload timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://codenboxautomationlab.com/about/booking/");
										
		//global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
										
		//maximize window
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		//select a future month
		String bookingMonth = driver.findElement(By.cssSelector("div[class='datepick-header'] span:nth-child(1)")).getText();
		//select a future year
		String bookingYear = driver.findElement(By.cssSelector("div[class='datepick-header'] span:nth-child(2)")).getText();
		
		while (!(bookingMonth.equals("January") && bookingYear.equals("2026"))) {
			driver.findElement(By.xpath("//a[normalize-space()='>>']")).click();
			bookingMonth = driver.findElement(By.cssSelector("div[class='datepick-header'] span:nth-child(1)")).getText();
			bookingYear = driver.findElement(By.cssSelector("div[class='datepick-header'] span:nth-child(2)")).getText();
		}
		driver.findElement(By.xpath("//a[normalize-space()='20']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
