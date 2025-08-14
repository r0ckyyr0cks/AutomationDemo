package com.anto;

import java.time.Duration;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FluentWait_Demo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement el = driver.findElement(By.linkText("Popular"));
                if (el.isDisplayed()) {
                    return el;
                }
                return null;
            }
        });

        System.out.println("Found element: " + element.getText());
        		
		driver.quit();

	}

}
