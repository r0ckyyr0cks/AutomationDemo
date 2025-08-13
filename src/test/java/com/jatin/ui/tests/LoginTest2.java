package com.jatin.ui.tests;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.jatin.ui.pages.HomePage;
import com.jatin.ui.pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver wd = new ChromeDriver(chromeOptions);
		
		HomePage homePage = new HomePage(wd);		
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("bobah97416@mobilesm.com", "Passw0rd01");
	}

}
