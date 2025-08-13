package com.letskodeit.anil.tomar;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ElementState {
	WebDriver driver;
	String baseURL;

	@Before
	void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
