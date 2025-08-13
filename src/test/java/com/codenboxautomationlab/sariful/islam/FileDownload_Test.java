package com.codenboxautomationlab.sariful.islam;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownload_Test {

	public static void main(String[] args) throws InterruptedException {

		// ref: https://www.lambdatest.com/blog/selenium-page-load-strategy/
		ChromeOptions chromeOptions = new ChromeOptions();

		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("profile.default_content_settings.popups", 0);
		String dfilePath = System.getProperty("user.dir");
		hm.put("download.default_directory", dfilePath);

		chromeOptions.setExperimentalOption("prefs", hm);

		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		chromeOptions.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(chromeOptions);

		File downloadDir = new File(dfilePath);
		File[] downloadedFiles = downloadDir.listFiles();
		if (downloadedFiles != null) {
			for (File file : downloadedFiles) {
				if (file.getName().startsWith("APKFiles")) {
					file.delete();
					System.out.println("Deleted old file:" + file.getName());
				}
			}
		}

		// delete all cookies
//		driver.manage().deleteAllCookies();

		// pageload timeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://codenboxautomationlab.com/practice");

		driver.findElement(By.linkText("Download APK files")).click();

		// global wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize window
		driver.manage().window().maximize();

		File downloadedFile = new File(dfilePath + "\\APKFiles-1.zip");
		if (downloadedFile.exists()) {
			System.out.println("File downloaded successfully");
		} else {
			System.out.println("File did not download");
		}

		System.out.println("URL ===> " + driver.getCurrentUrl());
		System.out.println("Page Title ===> " + driver.getTitle());

		Thread.sleep(3000);
		driver.quit();

	}

}
