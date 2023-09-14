package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectModel {
	
	WebDriver ldriver;
	public PageObjectModel(WebDriver rdriver)
	{

	
		 ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public static String clcikbtnimg="(//div[@id=\"container\"]//img)[1]";
	public static String clcikpopbtn="//div[@class=\"_2QfC02\"]/button";
	
	
@FindBy(xpath="(//div[@id=\"container\"]//img)[1]")
WebElement clickLogoButton;

@FindBy(xpath="//div[@class=\"_2QfC02\"]/button")
WebElement closePopupWindow;
@FindBy(name="email")
WebElement facebooEmail;
@FindBy(name="pass")
WebElement facebookPass;
@FindBy(name="login")
WebElement facebookButton;




public void clickOnLogo()
{
	clickLogoButton.click();
}

public void popUpWindow()
{
	 closePopupWindow.click();

	 
}
public void fEmail(String emailId)
{
	facebooEmail.sendKeys(emailId);
}
public void fPass(String pass)
{
	facebookPass.sendKeys(pass);
}
public void fButton()
{
	facebookButton.click();
}
}


