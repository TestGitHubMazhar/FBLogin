package com.Flipkart.Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	WebDriver driver;
	public  void takeScreenshot(WebDriver driver, String tname) throws IOException
	{

	File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	Date d=new Date();
	String date = d.toString().replace(":","_")+".PNG";

	
	File destinationFile=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+date);
	FileHandler.copy(sourceFile, destinationFile);
	
	}

}
