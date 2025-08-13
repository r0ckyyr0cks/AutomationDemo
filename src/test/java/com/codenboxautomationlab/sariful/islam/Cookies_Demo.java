package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Cookies_Demo {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		//pageload timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("http://www.automationpractice.pl/index.php");
						
		//global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						
		//maximize window
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.cssSelector("#email")).sendKeys("bobah97416@mobilesm.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Passw0rd01");
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
		
		//get all cookies
		Set<Cookie> allCookies = driver.manage().getCookies();
		int countCookies =  allCookies.size();
		System.out.println("Total number of cookies count are: " + countCookies);
		
		for (Cookie cookies:allCookies) {
			System.out.println("Cookie name: " + cookies.getName());
			System.out.println("Cookie path: " + cookies.getPath());
			System.out.println("Cookie value: " + cookies.getValue());
			System.out.println("Cookie expiry: " + cookies.getExpiry());
			System.out.println("Cookie domain: " + cookies.getDomain());
		}
		
		//Delete cookies
		driver.manage().deleteAllCookies();
		
		Thread.sleep(3000);
		driver.quit();

	}

}
