package com.Flipkart.Utility;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.File;


public class OpenBrowser extends Configue {
	

	public static  WebDriver driver;
public static Logger logger=	LogManager.getLogger(OpenBrowser.class);
@Parameters("browser")

	
@BeforeClass
	public void setup(String br) {
	if(br.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		
		
		
			driver = new ChromeDriver();

	
	
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("browser is open....");
	}
	else if(br.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver", ieDriver);

		driver = new InternetExplorerDriver();
	
		PropertyConfigurator.configure("Log4j.properties");
	}
	
		
		driver.get(url);
		
		

	}
	

	
	
	
	
	

	@AfterClass
	public void quit() {
		driver.quit();
	}

}
