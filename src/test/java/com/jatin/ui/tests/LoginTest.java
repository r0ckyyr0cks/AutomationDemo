package com.jatin.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.jatin.utility.BrowserUtility;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver wd = new ChromeDriver(chromeOptions);
		
		/*
		BrowserUtility browserUtility = new BrowserUtility(wd);
		
		browserUtility.manageTimeOut();
		browserUtility.goToWebsite("http://www.automationpractice.pl/");
		browserUtility.maximizeWindow();
		
		System.out.println(wd.getTitle());
		
		By signInLinkLocator = By.linkText("Sign in");
		browserUtility.clickOnSignInLink(signInLinkLocator);
		
		By emailTextBoxLocator = By.id("email");
		browserUtility.enterText(emailTextBoxLocator, "bobah97416@mobilesm.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator, "Passw0rd01");
		
		By submitLoginButtonLocator = By.id("passwd");
		browserUtility.simulateKeyPress(submitLoginButtonLocator);
		*/
		
		Thread.sleep(3000);
		wd.quit();
	}

}
