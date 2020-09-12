package Academy;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.base;

public class validateNavigation extends base {
	public static Logger log =LogManager.getLogger(base.class.getClass());
	
	@BeforeTest
	public void initalize() throws IOException
	{
		driver = initalizeDriver();
		log.info("Browser launched");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("URL opened");
	}
	
	@Test
	public void ValidateWebNavigation() throws IOException
	{
			
		//Landing page - Login Click
		//to access property of landing page,you can inherit the class or create an object of it
		//creating an object and invoking it
		LandingPage landpg = new LandingPage(driver);
		
		//Checking if navigation bar header found or not
		Assert.assertTrue(landpg.navigationBar().isDisplayed(),"Navgiation bar with 'HOME','COURCES','VIDEO',etc is not displayed");
		System.out.println("Navgiation bar with 'HOME','COURCES','VIDEO',etc is displayed");
		log.info("Navgiation bar in Validation Navigation Sucessfully dispalyed");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println("Driver closed for Validate Navigation");
		driver=null;
	}
}
