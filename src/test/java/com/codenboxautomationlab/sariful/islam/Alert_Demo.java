package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Alert_Demo {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://codenboxautomationlab.com/practice/");
		
		//global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//maximize window
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#name")).sendKeys("Rakesh");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		//switch to alert window
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		
		Thread.sleep(1000);
		driver.quit();

	}

}
