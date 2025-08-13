package com.letskodeit.anil.tomar;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class RadioButtonAndCheckbox {
	
	WebDriver driver;
	String baseURL;

	@BeforeEach
	void setUp() throws Exception {
		
		baseURL = "https://www.letskodeit.com/practice";
		
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		
	}

	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	void verifyRadioButton() {
		if(driver.findElement(By.id("bmwradio")).isEnabled()) {
			System.out.println("BMW radio button is enabled");
			driver.findElement(By.id("bmwradio")).click();
		}else{
			System.out.println("BMW radio button is not enabled");
		}
	}
	
	@Test
	void verifyCheckbox() {
		if(driver.findElement(By.id("bmwcheck")).isEnabled()) {
			System.out.println("BMW checkbox is enabled");
			driver.findElement(By.id("bmwcheck")).click();
		}else {
			System.out.println("BMW checkbox is disabled");
		}
	}
	
	@Test
	void testDropdown() {
		WebElement element = driver.findElement(By.id("carselect"));
		Select selekt = new Select(element);
		
		selekt.selectByValue("benz");
		
		selekt.selectByIndex(2);
		
//		selekt.selectByVisibleText("BMW");
		
		List<WebElement> options = selekt.getOptions();
		int size = options.size();
		
		for(int i=0; i<size; i++) {
			String optionsName = options.get(i).getText();
			System.out.println(optionsName);
		}
	}
	
}
