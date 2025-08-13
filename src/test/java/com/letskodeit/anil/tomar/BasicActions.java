package com.letskodeit.anil.tomar;

import static org.junit.Assert.fail;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicActions {
	
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "http://letskodeit.teachable.com";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get(baseURL);
	}

}
