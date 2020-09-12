package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

public class base {
	
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initalizeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Mona\\Project\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser"); 
		System.out.println("Browser Name mentioned in properties file is "+browserName);
		
		if(browserName.equals("chrome"))
		{ 
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mona\\Project\\src\\main\\java\\resources\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Mona\\Project\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mona\\Project\\src\\main\\java\\resources\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println("Browser launched sucessfully");
		
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		// Open the current date and time
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

		File DestFile = new File("D:\\screenshot\\"+result+"screenshot"+timestamp+".png");
		org.apache.commons.io.FileUtils.copyFile(scr,DestFile);
	} 
}
