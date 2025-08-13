package com.way2automation.rahul.arora;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestChromeHeadless {
	
	public static WebDriver driver;
	
	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		String fileName = d.toString().replace(":","_").replace(" ","_") + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".\\screenshot\\" + fileName));
	}

	public static void main(String[] args) throws IOException {
		
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--headless=new");
		chromeoptions.addArguments("window-size=1200x600");
		
		WebDriver driver = new ChromeDriver(chromeoptions);
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.findElement(By.linkText("ENTER TO THE TESTING WEBSITE")).click();
		captureScreenshot();		
				
		driver.close();
		driver.quit();

	}

}
