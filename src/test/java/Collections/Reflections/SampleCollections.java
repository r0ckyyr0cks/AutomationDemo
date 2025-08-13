package Collections.Reflections;

import java.net.SocketException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SampleCollections {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.ptinews.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.manage().window().fullscreen();
		
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		HashMap<String, String> usr = new HashMap<>();
		
		usr.put("admin", "admin:Passw0rd");
		
		String arr[] = usr.get("admin").split(":");
		System.out.println(arr[0]);
		
//		driver.close();
		driver.quit();

	}

}
