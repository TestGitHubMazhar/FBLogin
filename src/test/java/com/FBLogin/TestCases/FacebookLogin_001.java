package com.FBLogin.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Flipkart.Utility.ScreenShot;
import com.Flipkart.Utility.XLUtility;

import PageObjectModel.PageObjectModel;

import com.Flipkart.Utility.Configue;
import com.Flipkart.Utility.OpenBrowser;

public class FacebookLogin_001 {
	WebDriver driver;
	ScreenShot s = new ScreenShot();

	@BeforeMethod
	@Parameters("browser")
	public void openBro(String br) {
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Configue.chromeDriver);

			driver = new ChromeDriver();
	
		}
		else if(br.equals("fireFox"))
		{
			try
			{
				System.setProperty("webdriver.gecko.driver", Configue.firweFoxDriver);

				driver = new FirefoxDriver();
			}
			catch(Exception e)
			{
				driver.get(Configue.url);
			}
		}

		driver.get(Configue.url);
		
	}

	@Test(dataProvider = "login", dataProviderClass = XLUtility.class,priority=1)
	public void browserOpen(String email, String pass) throws InterruptedException, IOException {

		PageObjectModel p = new PageObjectModel(driver);
		driver.manage().window().maximize();
		p.fEmail(email);

		p.fPass(pass);

		p.fButton();
		Thread.sleep(2000);
		String gettitle = driver.getTitle();
		if (gettitle.equals("(6) Facebook")) {
			System.out.println("Login Successful...");
		} else {
			System.out.println("Login fail...");
		}
		s.takeScreenshot(driver, "validUserNameAndInvalidPass");
		driver.findElement(By.xpath("(//input[@type=\"search\"])[1]")).sendKeys("mazhar");
		Thread.sleep(10000);

	}
	
	public void searchFB() throws InterruptedException
	{
	
	}

	@AfterMethod
	public void closeBr() {
		driver.close();
	}

}
