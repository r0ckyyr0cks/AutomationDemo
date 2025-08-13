package AutomationQA.AutomationDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.thetestingworld.com/testings/");
		driver.findElement(By.name("fld_username")).sendKeys("ranjan");
		driver.findElement(By.name("fld_email")).sendKeys("trianz.lead.qa@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Thi5I5MyPa55w0rd");
		driver.findElement(By.name("fld_cpassword")).sendKeys("Thi5I5MyPa55w0rd");
		driver.findElement(By.id("datepicker")).sendKeys("08/03/1993");
		driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("+918527003445");
		driver.findElement(By.name("address")).sendKeys("Delhi");

		Thread.sleep(3000l);
		driver.close();
		driver.quit();

	}

}
