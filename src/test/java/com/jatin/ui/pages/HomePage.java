package com.jatin.ui.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jatin.utility.BrowserUtility;

public final class HomePage extends BrowserUtility{
	
	private static final By SIGN_IN_LINK_LOCATOR = By.linkText("Sign in");
	
	public HomePage(WebDriver driver) {
		super(driver); //to call the Parent Class constructor from the Child Class constructor
		goToWebsite("http://www.automationpractice.pl/");

	}
	
	public LoginPage goToLoginPage() { //page functions--------------------->
		try {
			clickOnSignInLink(SIGN_IN_LINK_LOCATOR);
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException");
//			e.printStackTrace();
		}
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}


}
