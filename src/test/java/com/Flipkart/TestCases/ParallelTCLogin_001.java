package com.Flipkart.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Flipkart.Utility.Configue;

public class ParallelTCLogin_001 {

	WebDriver driver;

	@Test
	public void chromeBrowser() {
		System.setProperty("webdriver.chrome.driver", Configue.chromeDriver);
		driver = new ChromeDriver();

		driver.get(Configue.url);
		
		driver.manage().window().maximize();
		System.out.println("This is chrome Browser");

	}

	@Test
	public void fireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", Configue.firweFoxDriver);
		driver = new FirefoxDriver();
		driver.get(Configue.url);
		driver.manage().window().maximize();
		System.out.println("This is FirefixDriver");
	}

}
