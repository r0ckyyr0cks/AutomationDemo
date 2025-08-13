package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dynamic_Dropdown {

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
		
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("can");
		
		//locate list of elements of search result
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		int count = list.size();
		System.out.println("Total number of countries listed are: " + count);
		for(int i=0; i<count; i++) {
			String myCountryName = list.get(i).getText();
			if(myCountryName.equalsIgnoreCase("canada")) {
				list.get(i).click();
				break;
			}
		}
		
		
		Thread.sleep(3000l);
		driver.quit();
		

	}

}
