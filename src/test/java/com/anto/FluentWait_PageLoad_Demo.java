package com.anto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWait_PageLoad_Demo {
	
	private static final String URL = "https://www.ebay.com/";
	private static final String SEARCH_BOX = "//*[@id=\"gh-ac\"]";
	private static final String SEARCH_RESULT = "#ebay-ac-suggestion-5 > span > span > span.suggestion-text > span";

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(By.xpath(SEARCH_BOX)).sendKeys("iphone");
        
        WebElement seleniumSearchResult = fluentWait(By.cssSelector(SEARCH_RESULT), driver);
        
	}
        
    public static WebElement fluentWait(final By locator, WebDriver driver) {
    	
    	// Create FluentWait
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // max wait time
                .pollingEvery(Duration.ofMillis(5000)) // check every 5 seconds
                .ignoring(NoSuchElementException.class); // ignore missing elements

        //f(x) = x, is any integer and gives back y , which is any integer
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
        	
        	@Override
        	public WebElement apply(WebDriver arg0) {
        		return arg0.findElement(locator);
        	}
        });
        return element;
    }
}
