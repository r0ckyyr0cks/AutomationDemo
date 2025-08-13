package AutomationQA.AutomationDemo;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PatnaProperty {

	public static void main(String[] args) throws InterruptedException {
		
		//ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(27));
		driver.get("https://pmcptax.bihar.gov.in/pmc/public/property/search_list.html");
		driver.findElement(By.name("pid")).sendKeys("2041492");
		driver.findElement(By.id("btn_search")).click();
		driver.findElement(By.linkText("View")).click();
		driver.findElement(By.linkText("View Demand Details")).click();
		String textToVerify = driver.findElement(By.cssSelector("body > div.container > div > div:nth-child(5) > div.col-sm-12.col-md-12.col-xs-12")).getText();
		Assert.assertTrue("There is no demand dues.", textToVerify.contains("There is no demand dues."));
		
		System.out.println(textToVerify);
		
//		driver.close();
		driver.quit();

	}

}
