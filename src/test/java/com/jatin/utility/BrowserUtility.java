package com.jatin.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BrowserUtility {
	
	private WebDriver driver;
	
	

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver; //Initialize the instance variable driver!!
	}
	
	public void goToWebsite(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void manageTimeOut() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(27));
	}
	
	public void clickOnSignInLink(By locator) {
		WebElement signInLinkWebElement = driver.findElement(locator);
		signInLinkWebElement.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		WebElement emailTextBoxWebElement = driver.findElement(locator);
		emailTextBoxWebElement.sendKeys(textToEnter);
	}
	
	public void simulateKeyPress(By locator) {
		WebElement simulateEnterKeyPress = driver.findElement(locator);
		simulateEnterKeyPress.sendKeys(Keys.RETURN);
	}

}
