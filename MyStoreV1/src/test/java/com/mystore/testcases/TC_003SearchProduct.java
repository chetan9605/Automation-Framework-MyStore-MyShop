package com.mystore.testcases;
                                                                    //1.Launch Browse
                                                                    //2.Open url 
                                                                    //3.Click on sign in link
                                                                    //4. Enter user name and pwd and click sign
                                                                    //5. Enter 'T-shirt' in search box
                                                                    //6.click on search button
                                                                    //7.validate that search result display 'T-shirt' Product
                                                                    //8.Click on sign out
import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;

import junit.framework.Assert;
import testBase.BaseClass;

public class TC_003SearchProduct extends BaseClass {
	
	
	@Test
	public void VerifySearchProduct() throws InterruptedException, IOException
	{
		 logger.info("Browser Launch"); 
		
		indexPage ip=new indexPage(driver);  
		
		 logger.info("Index page Open"); 
		
		 ip.clickOnSignIn(); 
		 
		 logger.info("Click on Sign in link");
		 
		myAccountPage ap=new myAccountPage(driver); 
		
		 logger.info("MyAccount Page Open"); 
		 
		ap.enterEmailAddress("xyzg@gmail.com");  
		
		 logger.info("Enter Email Address"); 
		 
		ap.enterPassword("Ankit@123");
		
		 logger.info("Emter password"); 
		 
		ap.clickSignIn();
		
		 logger.info("Click on Sign in link"); 
		
		
		registeredUserAccount rg=new registeredUserAccount(driver);
		
		 logger.info("Register page open"); 
		
		rg.EnterDataInSearchBox("T-shirt");
		
		 logger.info("Enter T-shirt in search box"); 
		
		//Thread.sleep(5000);
		
		rg.ClickOnSearchButton();
		
		 logger.info("Click on search Button"); 
		
		SearchResultPage sp=new SearchResultPage(driver);
		
		 logger.info("Search result page open"); 
		
		String TshirtName = sp.getSearchResultProductName();
		
		 logger.info("Getting name"); 
		
		System.out.println(TshirtName);                       //Faded Short Sleeve T-shirts

		
		if(TshirtName.contains("Faded Short Sleeve T-shirts"))
		{
			Assert.assertTrue(true);
			
			System.out.println("match t-shirt name");
			
			rg.clickOnSignOut();
			
		}
		else
		{
			captureScreenShot(driver,"verifySearchProduct");
			
			Assert.assertTrue(false);
		}
		
		
	}

}
