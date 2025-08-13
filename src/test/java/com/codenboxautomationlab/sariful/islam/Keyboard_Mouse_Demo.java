package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Keyboard_Mouse_Demo {

	public static void main(String[] args) throws InterruptedException {
		
		//reference: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://codenboxautomationlab.com/practice/");
						
		//global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						
		//maximize window
		driver.manage().window().maximize();
		
		Actions aktions = new Actions(driver);
		
		WebElement courses = driver.findElement(By.linkText("Courses"));
		aktions.moveToElement(courses).build().perform();
		
		driver.navigate().refresh();
		
//		Thread.sleep(3000);
		//click on search and type selenium (holding shift key) and double click
		WebElement searchButton = driver.findElement(By.xpath("//div[@id='search-2']//input[@placeholder='Search...']"));
		aktions.moveToElement(searchButton).click().keyDown(Keys.SHIFT).sendKeys("selenium").doubleClick().build().perform();
		
		//Right click on YouTube + open link in a new tab (select open link in new tab)
		WebElement youTube = driver.findElement(By.partialLinkText("YouTube"));
		aktions.moveToElement(youTube).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		
		Thread.sleep(9000);
		driver.quit();

	}

}
