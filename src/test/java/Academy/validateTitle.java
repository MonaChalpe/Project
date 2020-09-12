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

public class validateTitle extends base {
	
	//object creation for log4j
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
	public void ValidateWebTitle()  throws IOException
	{
			
		//Landing page - Login Click
		//to access property of landing page,you can inherit the class or create an object of it
		//creating an object and invoking it
		LandingPage landpg = new LandingPage(driver);
		
		//checking if subtitle is coming as expected or not
		String actual = landpg.getSubTitle().getText();
		System.out.println("Actual title : " + actual);
		String expected = "FEATURED COURSES";
		System.out.println("expected title : " + expected);
		Assert.assertEquals(actual, expected);
		System.out.println("actual and expected sub title both are equal");
		
		//Checking if navigation bar header found or not
		Assert.assertTrue(landpg.navigationBar().isDisplayed(),"Navgiation bar with 'HOME','COURCES','VIDEO',etc is not displayed");
		System.out.println("Navgiation bar with 'HOME','COURCES','VIDEO',etc is displayed");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println("Driver closed for Validate Title");
		driver=null;
	}
}
