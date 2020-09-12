package stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PortalHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class myStepDefinations extends base {
	

	@Given("Initilize browser with chrome")
	public void initilize_browser_with_chrome() throws IOException 
	{
		driver = initalizeDriver();
	}

	@And("navigate to {string} site")
	public void navigate_to_site(String url) 
	{

		driver.manage().window().maximize();
		driver.get(url);
		
	}

	@And("Click on login link in homepage to land on secure sign in page")
	public void click_on_login_link_in_homepage_to_land_on_secure_sign_in_page() {
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
	}

	@When("User enters {string} and {string} logs in")
	public void user_enters_and_and_logs_in(String username, String password){
        
		LoginPage loginpg = new LoginPage(driver);
		loginpg.getEmail().sendKeys(username);
		loginpg.getPassword().sendKeys(password);
		loginpg.getLogin().click();
		
	}

	@Then("Verify user sucessfully logged in")
	public void verify_user_sucessfully_logged_in() 
	{
		PortalHomePage ph = new PortalHomePage(driver);
		Assert.assertTrue(ph.getmessageIncorrect().isDisplayed(),"incorrect password");
		driver.close();
	}



}
