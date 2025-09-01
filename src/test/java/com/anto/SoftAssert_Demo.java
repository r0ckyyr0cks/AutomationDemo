package com.anto;
//Need to look into this - SoftAssert not working correctly
import java.io.File;
import java.io.IOException;
import java.time.Duration;
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

import org.testng.asserts.SoftAssert;

public class SoftAssert_Demo {
	
	private static final String URL = "https://automationplayground.com/crm/";
	private static final String USERNAME = "stratus.noida.pb@gmail.com";
	private static final String PASSWORD = "mind2mind";

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
        String homePageText = driver.findElement(By.tagName("h2")).getText();
//        System.out.println(homePageText);
        // Verify the expected text is present
        SoftAssert softAssert = new SoftAssert();
        
//        softAssert.assertEquals(homePageText, "Customers Are Priority!", "Text does not match!");
        softAssert.assertTrue(homePageText.contains("Customers Are King!"), "Text not found");
        driver.findElement(By.linkText("Sign In")).click();
        
        // Get text present on the login page
        String loginPageText = driver.findElement(By.tagName("h2")).getText();
//        System.out.println(loginPageText);
        // Verify the expected text is present
//        softAssert.assertEquals(loginPageText, "Sign In", "Text does not match!");
        softAssert.assertTrue(loginPageText.contains("Sign In"), "Text not found");
        softAssert.assertAll();
        driver.findElement(By.id("email-id")).sendKeys(USERNAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submit-id")).click();

		driver.quit();

	}

}
