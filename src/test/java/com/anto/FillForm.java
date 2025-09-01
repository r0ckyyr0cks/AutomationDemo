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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FillForm {
	
	private static final String URL = "https://automationplayground.com/crm/";
	private static final String USERNAME = "stratus.noida.pb@gmail.com";
	private static final String PASSWORD = "mind2mind";
	private static final String homePageTextForVerification = "Customers Are Priority One!";
	private static final String loginPageTextForVerification = "Login";
	
	private static final String homePageTextLocation = "h2";
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1024, 1024));
		driver.manage().deleteAllCookies();
		driver.get(URL);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
		            webDriver -> ((JavascriptExecutor) webDriver)
		                .executeScript("return document.readyState")
		                .equals("complete")
		        );
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
				
		// Get text present on the home page
        String homePageText = driver.findElement(By.tagName(homePageTextLocation)).getText();
        System.out.println(homePageText);
        // Verify the expected text is present
//        Assert.assertTrue(homePageText.contains("Customers Are Priority One!"), "Text not found on the page");
        Assert.assertEquals(homePageText, homePageTextForVerification, "Text does not match!");
        driver.findElement(By.linkText("Sign In")).click();
        
        // Get text present on the login page
        String loginPageText = driver.findElement(By.tagName(homePageTextLocation)).getText();
        System.out.println(loginPageText);
        // Verify the expected text is present
//        Assert.assertTrue(loginPageText.contains("Login"), "Text not found on the page");
        Assert.assertEquals(loginPageText, loginPageTextForVerification, "Text does not match!");
        
        driver.findElement(By.id("email-id")).sendKeys(USERNAME);
        try {
        	Thread.sleep(3000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        try {
        	Thread.sleep(3000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
        driver.findElement(By.id("submit-id")).click();
        try {
        	Thread.sleep(3000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        
		driver.quit();

	}

}
