package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;

import testBase.BaseClass;

public class TC_005LogOut extends BaseClass {
	
	
	@Test
	public void VerifyLogOut() throws InterruptedException, IOException
	{
		indexPage ip=new indexPage(driver);                                //1.Launch Browser
		                                                                   //2.Open url
		 logger.info("index page");                                        //3.Click on sign in link
		                                                                   //4.Enter username
		ip.clickOnSignIn();                                                //5.Enter pwd
		                                                                   //6.Click on sign in link
		 logger.info("Click on sign in");                                  //7.Click o sign out link                         
		                                                                   //8. On click on Sign out user navigate to webpage and having page title 'Login-MyStore'
		myAccountPage ap=new myAccountPage(driver);
		
		 logger.info("my account page");
		
		ap.enterEmailAddress("xyzg@gmail.com");
		
		 logger.info("email");
		
		ap.enterPassword("Ankit@123");
		
		 logger.info("pass");
		
		
		
		ap.clickSignIn();
		
		 logger.info("Click on sign in");
		
		registeredUserAccount rua=new registeredUserAccount(driver);
		
		 logger.info("register page");
		 
		 rua.clickOnSignOut();
		 
		 String Title = ip.getPageTitle();
		 
		 System.out.println(Title);
		 
		 if(Title.equals("Login - My Shop"))
		 {
			 System.out.println("Pass");
			 
			 Assert.assertTrue(true);
		 }
		 
		 else
		 {
			 System.out.println("Fail");
			 
			 captureScreenShot(driver,"verifyLogOut");
			 
				Assert.assertTrue(false);
		 }
		 
		 
		 
		
		
		
		
		
	}

}
