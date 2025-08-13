package com.codenboxautomationlab.sariful.islam;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Handle_SSL_error_Demo {

	public static void main(String[] args) throws InterruptedException {

		// ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		chromeOptions.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(chromeOptions);

		// delete all cookies
		driver.manage().deleteAllCookies();

		// pageload timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://self-signed.badssl.com/");

		// global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize window
		driver.manage().window().maximize();

		System.out.println("URL ===> " + driver.getCurrentUrl());
		System.out.println("Page Title ===> " + driver.getTitle());

		Thread.sleep(3000);
		driver.quit();
	}

}
