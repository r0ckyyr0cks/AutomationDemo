package AutomationQA.AutomationDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenBrowserSauceLab {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		
		//before login fetch Title and URL
		String title1 = driver.getTitle();
		System.out.println("Title of the Landing Page = " + title1);
		String url1 = driver.getCurrentUrl();
		System.out.println("URL before Login = " + url1);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//after login fetch Title and URL
		String title2 = driver.getTitle();
		System.out.println("Title of the Page after Login = " + title2);
		String url2 = driver.getCurrentUrl();
		System.out.println("URL after Login = " + url2);
		driver.findElement(By.xpath("//div[text()='Swag Labs']"));
		
		//find the number of links with anchor tag
		System.out.println(driver.findElements(By.tagName("a")).size());
		System.out.println(driver.findElements(By.tagName("button")).size());
		
		Thread.sleep(3000l);
		driver.close();
		driver.quit();

	}

}
