package AutomationQA.AutomationDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;


public class OpenBrowserOfiFrame {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ptinews.com/");
		
		//find the numbers of iFrame on the page
		List<WebElement> totalNumberOfFramesAvailable = driver.findElements(By.tagName("iframe"));
		
		System.out.println("Total number of frames are: " + totalNumberOfFramesAvailable.size());

		for (int i=0; i<totalNumberOfFramesAvailable.size(); i++) {
			
			driver.switchTo().frame(i);
			System.out.println("##########################################################################");
			List<WebElement> totalNumberOfLinksPresent = driver.findElements(By.tagName("a"));
			System.out.println(totalNumberOfLinksPresent.size());
			String pageTitle = driver.getTitle();
			System.out.println(pageTitle);
			try {
			assertEquals(true, driver.getPageSource().contains("Press Trust of India"));
			} catch (AssertionError e) {
				System.out.println("expected [false] but found [true]");
				e.printStackTrace();
				System.out.println("Message is: " + e.getMessage());
				System.out.println("Cause is: " + e.getCause());
			} finally {
				System.out.println("This is the finally block!");
			}
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		}

//		Thread.sleep(3000l);
		driver.close();
		driver.quit();

	}

}
