package com.letskodeit.anil.tomar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingNoSuchElementExceptionDemo {

	public static void main(String[] args) {
		
		String baseURL = "https://www.letskodeit.com/practice";
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(baseURL);
		
		driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a"));
		
		driver.findElement(By.name("email")).sendKeys("bobah97416@mobilesm.com");
		driver.findElement(By.id("login-password")).sendKeys("Passw0rd01");
		
		driver.quit();

	}

}
