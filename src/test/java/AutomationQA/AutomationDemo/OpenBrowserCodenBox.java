package AutomationQA.AutomationDemo;

import java.awt.Window;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class OpenBrowserCodenBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://codenboxautomationlab.com/practice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("radioButton")).click();
		Thread.sleep(3000l);
		
		//locating element (radio button) using parent/child/descendant relationship
		driver.findElement(By.xpath("//div[@id='radio-btn-example']/fieldset/label[2]/input")).click();
		
		//working with dynamic drop-down
		driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys("in");
		
		//working with list
		WebElement dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select s = new Select(dropdown);
		s.selectByValue("option2"); //appium
		Thread.sleep(3000l);
		s.selectByVisibleText("Selenium"); //selenium
		Thread.sleep(3000l);
		s.selectByIndex(3);
		
		Thread.sleep(3000l);
		
		//use JavaScript to scroll down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 500)");
		
		driver.findElement(By.xpath("//div[@id='meta-4']/ul/li[1]/a")).click();
		driver.navigate().back();
		js.executeScript("window.scrollTo(500, 0)");
		Thread.sleep(3000l);
		driver.navigate().forward();
		Thread.sleep(3000l);
		System.out.println("The new page title is: " + driver.getTitle());
		driver.close();
		driver.quit();

	}

}
