package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static Logger logger;

public WebDriver driver;

public Properties p;
	
   
	@BeforeClass
	public void setup() throws IOException
	{
	
	FileInputStream fis=new FileInputStream("C:\\Auto2\\MyWorkplace\\ChetanAutomation\\MyStoreV1\\Configuration\\config.properties");
	
	p=new Properties();
	
	p.load(fis);
	
	
	
	    driver=new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(p.getProperty("url"));
		
		logger=LogManager.getLogger("MyStoreV1");
	
	
	
/*	switch (p.getProperty("browser")) {
	case "chrome":
		driver=new ChromeDriver();
		break;
		
	case "firefox":
		driver=new FirefoxDriver();
		break;
		
	case "edge":
		driver=new EdgeDriver();
		break;

        default:
		System.out.println("Invalid browser");
		
		break;                         */
		
	  
	
		
		
	}
	  /*   driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(p.getProperty("url"));
		
		logger=LogManager.getLogger("MyStoreV1");  
	}         */

	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	public String randomeString()
	{
		String genratedString =RandomStringUtils.randomAlphabetic(5);
		
		
		return genratedString;
	}
	
	public String randomeNumber()
	{
		String genratedNumber =RandomStringUtils.randomNumeric(10);
		
		
		return genratedNumber;
	}
	
	public String randomeAlphaNumeric()
	{
		String genratedString =RandomStringUtils.randomAlphabetic(3);
		
		String genratedNumber =RandomStringUtils.randomNumeric(3);
		
		
		return (genratedString+genratedNumber);
	}
	
	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}

}
