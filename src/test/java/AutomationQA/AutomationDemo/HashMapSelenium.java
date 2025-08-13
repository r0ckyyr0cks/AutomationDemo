package AutomationQA.AutomationDemo;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HashMapSelenium {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		String customer_credentials = getCredentialsMap().get("user1");
		
		driver.findElement(By.cssSelector("input#user-name")).sendKeys(customer_credentials.split(":")[0]);
		driver.findElement(By.cssSelector("input#password")).sendKeys(customer_credentials.split(":")[1]);
		driver.findElement(By.cssSelector("input#login-button")).click();
		
		WebElement bodyText = driver.findElement(By.className("app_logo"));
		String ExpectedBodyText = "Swag Labs";
		Assert.assertEquals(ExpectedBodyText, bodyText.getText());
		System.out.println("Swag Labs is expected – Assert passed");
		
		System.out.println(getCredentialsMap());
		System.out.println(getCredentialsMap().get("user2"));
		
		driver.close();
		driver.quit();
	}
	
	public static HashMap<String, String> getCredentialsMap() {
		
		HashMap<String, String> userMap = new HashMap<>();
		userMap.put("customer", "rakesh:test@123");
		userMap.put("admin", "admin:admin@123");
		userMap.put("distributor", "ranjan:ranj@123");
		userMap.put("seller", "rocky:rock@123");
		userMap.put("deliveryperson", "raj:ranj@123");
		userMap.put("user1", "standard_user:secret_sauce");
		userMap.put("user2", "locked_out_user:secret_sauce");
		userMap.put("user3", "problem_user:secret_sauce");
		userMap.put("user4", "performance_glitch_user:secret_sauce");
		userMap.put("user5", "error_user:secret_sauce");
		userMap.put("user6", "visual_user:secret_sauce");
		
		return userMap;
	}

}
