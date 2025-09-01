package com.anto;

import java.time.Duration;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitForPageLoad_Demo {
	
	private static final String URL = "https://www.flipkart.com/";

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().setSize(new Dimension(1024, 1024));
		driver.manage().deleteAllCookies();
		driver.get(URL);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
		            webDriver -> ((JavascriptExecutor) webDriver)
		                .executeScript("return document.readyState")
		                .equals("complete")
		        );
		System.out.println("Page fully loaded.");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
			
		driver.quit();
	}

}
