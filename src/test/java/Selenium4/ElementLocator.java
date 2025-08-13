package Selenium4;

import java.awt.Window;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class ElementLocator {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.navigate().to("https://codenboxautomationlab.com/practice/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//TODO: locate element using above method
		
		
		driver.close();
		driver.quit();

	}

}
