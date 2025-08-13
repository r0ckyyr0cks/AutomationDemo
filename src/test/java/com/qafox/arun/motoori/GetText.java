package com.qafox.arun.motoori;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetText {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(27));
		driver.navigate().to("https://omayo.blogspot.com/");

//		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		
		System.out.println(driver.findElement(By.id("pah")).getText());
		System.out.println("Title of the Page: " + driver.getTitle());
		System.out.println("URL of the Page: " + driver.getCurrentUrl());
		
		driver.findElement(By.linkText("onlytestingblog")).click();
		System.out.println("Current URL of the Page: " + driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1500)", "");
		/*
		driver.findElement(By.linkText("Blogger")).click();
		System.out.println("URL of the new Page: " + driver.getCurrentUrl());
		driver.quit();
		System.out.println("URL of the original Page: " + driver.getCurrentUrl());
		*/
		Thread.sleep(3000);
		String text = driver.findElement(By.id("textbox1")).getAttribute("value");
		System.out.println(text);
		
		System.out.println("Button2 is Displayed: " + driver.findElement(By.id("but2")).isDisplayed());
		System.out.println("Button2 is Enabled: " + driver.findElement(By.id("but2")).isEnabled());
		
		System.out.println("Button1 is Displayed: " + driver.findElement(By.id("but1")).isDisplayed());
		System.out.println("Button1 is Enabled: " + driver.findElement(By.id("but1")).isEnabled());
		
		System.out.println("Checkbox Orange is selected: " + driver.findElement(By.id("checkbox1")).isSelected());
		System.out.println("Checkbox Blue is selected: " + driver.findElement(By.id("checkbox2")).isSelected());
		
		driver.quit();

	}

}
