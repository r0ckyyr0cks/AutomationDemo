package AutomationQA.AutomationDemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.navigate().to("https://codenboxautomationlab.com/");
//		driver.switchTo().window();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
		//use JavaScript to scroll down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 500)");
		
		driver.findElement(By.linkText("Practice")).click();
		
		Thread.sleep(5000);
//		driver.close();
		driver.quit();

	}

}
