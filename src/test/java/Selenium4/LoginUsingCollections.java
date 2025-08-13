package Selenium4;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LoginUsingCollections {

	public static void main(String[] args) throws InterruptedException {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("Admin", "admin:admin123");
		map.put("Manager", "Manager:Manager123");
		map.put("HR", "HR:Hr123");
		
		System.out.println(map.get("Admin"));
		
		String arr[] = map.get("Admin").split(":");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(arr[0]);
//		By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.name("password"));
		driver.findElement(By.name("password")).sendKeys(arr[1]);
		driver.findElement(By.cssSelector("button[type=submit]")).click();
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		

	}

}
