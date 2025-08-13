package com.way2automation.rahul.arora;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

public class HandlingDropdown {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select select = new Select(driver.findElement(By.cssSelector("#searchLanguage")));
		select.selectByVisibleText("Dansk");
		Thread.sleep(3000);
		select.selectByValue("hi");
		Thread.sleep(3000);
		select.selectByIndex(5);
		
		List<WebElement> options = select.getOptions();
		System.out.println("Number of languages available are: " + options.size());
		
		for(int i=0; i<options.size(); i++) {
			
			System.out.println(options.get(i).getText());
			
		}
		System.out.println("====================================================");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());
		
		for(int j=0; j<links.size(); j++) {
			
			
			System.out.println(links.get(j).getAttribute("href"));
			
		}
		
//		driver.close();
		driver.quit();

	}

}
