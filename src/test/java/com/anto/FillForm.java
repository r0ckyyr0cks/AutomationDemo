package com.anto;

import java.time.Duration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;

public class FillForm {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1024, 1024));
		driver.manage().deleteAllCookies();
		driver.get("https://automationplayground.com/crm/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
		driver.findElement(By.linkText("Sign In"));
		
		// Get all the visible text from the page
        String pageText = driver.findElement(By.tagName("h2")).getText();

        // Verify the expected text is present
        Assert.assertTrue(pageText.contains("Customers Are Priority One!"), "Text not found on the page");
		
		
		driver.quit();

	}

}
