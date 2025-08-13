package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Traditional_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://codenboxautomationlab.com/practice/");
		
		//global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select selekt = new Select(dropdown);
		
		Thread.sleep(1000);
		selekt.selectByIndex(2);
		
		Thread.sleep(1000);
		selekt.selectByValue("option3");
		
		Thread.sleep(1000);
		selekt.selectByContainsVisibleText("Select");
		
		Thread.sleep(1000);
		selekt.selectByContainsVisibleText("Selenium");
		
		Thread.sleep(1000);
		driver.quit();

	}

}
