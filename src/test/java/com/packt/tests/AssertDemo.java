package com.packt.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.Test;

public class AssertDemo {
	
	private static final String URL = "http://automatetheboringstuff.com/eval/";
	
	@Test	
	public void assertDemo() {
		
		WebDriver driver = new EdgeDriver();
		
		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1024, 1024));
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.linkText("2-2.html")).click();
//		Thread.sleep(3000);
		driver.quit();

	}

}
