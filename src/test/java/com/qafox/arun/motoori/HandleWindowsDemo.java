package com.qafox.arun.motoori;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleWindowsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(27));
		driver.navigate().to("https://omayo.blogspot.com/");
		System.out.println(driver.getTitle());
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1500)", "");
		
		driver.findElement(By.linkText("Open a popup window")).click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		Iterator<String> iterator = windowIDs.iterator();
		/*
		while(iterator.hasNext()) {
			String windowID = iterator.next();
			System.out.println(windowID);
		}
		*/
		String mainWindowID = iterator.next();
		String childWindowID = iterator.next();
		
		driver.switchTo().window(childWindowID);
		String childWindowText = driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
		System.out.println(childWindowText);
		driver.close();
		driver.switchTo().window(mainWindowID);
		String mainWindowText = driver.findElement(By.xpath("//h1[normalize-space()='omayo (QAFox.com)']")).getText();
		System.out.println(mainWindowText);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
