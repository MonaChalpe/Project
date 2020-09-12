package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PortalHomePage;
import resources.base;

public class HomePage extends base {
	
	//object creation for log4j
	public static Logger log =LogManager.getLogger(base.class.getClass());
	
	@BeforeTest
	public void initalize() throws IOException
	{
		driver = initalizeDriver();
		String s ="Java";
		
		
	}	
	@Test(dataProvider = "getData")
	public void ValidateWebUsers(String username,String password,String text) throws IOException
	{
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
				
	//Landing page - Login Click
		//to access property of landing page,you can inheit the class or create an object of it
		//creating an object and invoking it
		LandingPage landpg = new LandingPage(driver);
		
		if(landpg.getPopupNewsLetterSize()>0)
		{
			landpg.getPopup().click();
			
		}
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		landpg.getLogin().click();
		
		//Login page(enter email , password & Click  LogOn)
		LoginPage loginpg = new LoginPage(driver);
		loginpg.getEmail().sendKeys(username);
		loginpg.getPassword().sendKeys(password);
		loginpg.getLogin().click();
		System.out.println(text);
		log.info("Test case homepage with " +text+ ":user done sucessfully");
		
		PortalHomePage ph = new PortalHomePage(driver);
		Assert.assertTrue(ph.getmessageIncorrect().isDisplayed(),"incorrect password");
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//rows stand for how many times testcase should run
		//coloumn stand for how many types of data types your are passing like username,email and text
		//even though it starts from zero while declaring array you should give actual size
		Object[][] data =new Object[2][3]; 
		
		data[0][0]="monachalpe001@gmail.com";
		data[0][1]="monachalpe001";
		data[0][2]="Non-restricted User";
		 
		data[1][0]="mona.chalpe@gmail.com";
		data[1][1]="mona.chalpe";
		data[1][2]="Restricted User";
		
		return data;
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println("Driver closed for homePage");
		driver=null;
	}
}
