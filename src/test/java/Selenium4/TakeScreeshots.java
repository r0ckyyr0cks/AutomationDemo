package Selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreeshots {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://codenboxautomationlab.com/practice/");
		WebElement myName = driver.findElement(By.cssSelector("input#name"));
		myName.sendKeys("Rakesh");

		File srcFile = myName.getScreenshotAs(OutputType.FILE);

		String projectPath = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(projectPath + "/test-output/" + "name" + Math.random() + ".png"));
		
				
		driver.close();
		driver.quit();

	}

}
