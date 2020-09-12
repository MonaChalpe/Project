package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
   public  WebDriver driver;
	
	By signIn = By.cssSelector("a[href=\'http://qaclickacademy.usefedora.com/sign_in\']");
	By subtitle= By.xpath("/html//section[@id='content']//h2[.='Featured Courses']");
	By navigationBarHeader = By.xpath("//body[@id='homepage']//div[@role='navigation']//nav");
	By PopupNewsLetter = By.xpath("//button[text='NO THANKS']");
			
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getLogin()
    {
        return driver.findElement(signIn);
    }
	
	public WebElement getSubTitle()
	{
		return driver.findElement(subtitle);
	}
	
	public WebElement navigationBar()
	{
	return driver.findElement(navigationBarHeader);	
	}
	
	public int getPopupNewsLetterSize()
	{
	return driver.findElements(PopupNewsLetter).size();	
	}

	public WebElement getPopup()
	{
	return driver.findElement(PopupNewsLetter);	
	}
}
