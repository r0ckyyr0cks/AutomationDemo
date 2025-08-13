package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Static_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.easemytrip.com/flights.html");
		
		//global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//maximize window
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#FromSector_show")).sendKeys("Delhi");
		driver.findElement(By.cssSelector("#Editbox13_show")).sendKeys("Bangalore");
		driver.findElement(By.cssSelector("#spnTraveller")).click();
		WebElement addAdultTraveller = driver.findElement(By.xpath("//*[@id=\"add\"]"));
		for (int i=1; i<9; i++) {
			addAdultTraveller.click();
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
