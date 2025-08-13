package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButton_Demo {

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
		
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		Thread.sleep(1000);
		
		List<WebElement> radioButtons = driver.findElements(By.cssSelector(".radioButton"));
		System.out.println("Number of radio buttons available are: " + radioButtons.size());
		
		for(int i=0; i<radioButtons.size(); i++) {
			@SuppressWarnings("deprecation")
			String radioButton = radioButtons.get(i).getAttribute("value");
			
			if(radioButton.equalsIgnoreCase("radio3")) {
				radioButtons.get(i).click();
				System.out.println(radioButtons.get(i).isSelected());
				break;
			}
					
		}
				
	
		Thread.sleep(3000);
		driver.quit();
	}

}
