package com.jatin.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.jatin.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {
	
	private static final By SIGN_IN_LINK_LOCATOR = By.linkText("Sign in");
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_LOGIN_BUTTON_LOCATOR = By.id("passwd");

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void doLoginWith(String emailAddress, String password) {
		
		clickOnSignInLink(SIGN_IN_LINK_LOCATOR);
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOnSignInLink(SUBMIT_LOGIN_BUTTON_LOCATOR);
	}

}
