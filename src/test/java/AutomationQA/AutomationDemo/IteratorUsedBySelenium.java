package AutomationQA.AutomationDemo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IteratorUsedBySelenium {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://savemoneyindia.com/");
		
		//find the numbers of iFrame on the page
		WebElement openTabs = driver.findElement(By.xpath("//*[@id=\"post-473901\"]/div[2]"));
		System.out.println(openTabs.findElements(By.tagName("a")).size());

		for (int i=1; i<openTabs.findElements(By.tagName("a")).size(); i++) {
			
		String openTabsAgain = Keys.chord(Keys.CONTROL,Keys.ENTER);
		
		openTabs.findElements(By.tagName("a")).get(i).sendKeys(openTabsAgain);

		}
		
		Set<String> linkS = driver.getWindowHandles();
		Iterator<String> it = linkS.iterator();
		
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

//		Thread.sleep(3000l);
		driver.close();
		driver.quit();


	}

}
