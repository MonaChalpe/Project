package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage 
{

	public WebDriver driver;
	
	By messageIncorrect = By.cssSelector(".alert.alert-danger");
	
	public PortalHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getmessageIncorrect()
	{
		return driver.findElement(messageIncorrect);
	}
}
