package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
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
		
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.id("open window")).click();
		driver.findElement(By.linkText("Open Tab")).click();
		
		Set<String> multipleWindowIds = driver.getWindowHandles();
		
		for (String ids:multipleWindowIds) {
			driver.switchTo().window(ids);
			System.out.println(driver.getTitle());
		}
		
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.cssSelector("input[value='radio1']")).click();
		
		Thread.sleep(3000);		
		driver.quit();
	}

}
