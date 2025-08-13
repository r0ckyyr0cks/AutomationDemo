package com.codenboxautomationlab.sariful.islam;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLink_Demo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://omayo.blogspot.com/");
//		driver.navigate().to("https://codenboxautomationlab.com/waits-in-selenium-automation/");
								
		//global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
								
		//maximize window
		driver.manage().window().maximize();
		
		//get all the links
		List<WebElement> allLinksOnHomePage = driver.findElements(By.tagName("a"));
		int totalLinkCount = allLinksOnHomePage.size();
		System.out.println("Total number of links on home page: " + totalLinkCount);
		
		for(WebElement link:allLinksOnHomePage) {
			String url = link.getAttribute("href");
			
			if (url==null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}
			
			//if it's not empty; check the url is broken or empty
			try {
				HttpURLConnection urlRequest = (HttpURLConnection)(new URL(url).openConnection());
				urlRequest.connect(); //connect to server
				if(urlRequest.getResponseCode() >= 400) {
					System.out.println(url + " ====> is broken");
				}else {
					System.out.println(url + " ====> is valid");
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		Thread.sleep(3000);		
		driver.quit();
	}

}
