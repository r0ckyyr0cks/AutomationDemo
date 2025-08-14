package com.anto;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWait_PageLoad_Demo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.nytimes.com/");

        // Create FluentWait
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // max wait time
                .pollingEvery(Duration.ofMillis(500)) // check every 0.5 sec
                .ignoring(NoSuchElementException.class); // ignore missing elements

        // Wait until page is fully loaded
        wait.until((Function<WebDriver, Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState")
                        .equals("complete")
        );

        System.out.println("Page fully loaded.");
        driver.quit();

	}

}
