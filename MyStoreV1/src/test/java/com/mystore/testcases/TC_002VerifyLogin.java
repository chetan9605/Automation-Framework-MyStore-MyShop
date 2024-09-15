package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;

import junit.framework.Assert;
import testBase.BaseClass;

public class TC_002VerifyLogin extends BaseClass {
	
	
	@Test (enabled=true)
	public void verifyLogin() throws InterruptedException, IOException   
	{
		 logger.info("Browser is Launch"); 
		
		indexPage ip=new indexPage(driver);                        //1.Launch browser
		                                                           //2.open url https://automationPractice.com
		 logger.info("index page open");                                //3.click on sign in link
		                                                           //4.enter email in already register section
		                                                           //5.Enter pwd
		ip.clickOnSignIn();                                       // 6. click on sign in link
		                                                          //7.Verify logged in username is visible on webpage
		 logger.info("Click on sign in");                         //8.click on sign out
		
		myAccountPage ap=new myAccountPage(driver);
		
		 logger.info("my account page Opne ");
		
		ap.enterEmailAddress("xyzg@gmail.com");
		
		 logger.info(" Enter email");
		
		ap.enterPassword("Ankit@123");
		
		 logger.info(" Enter password");
		
		//Thread.sleep(5000);
		
		ap.clickSignIn();
		
		 logger.info("Click on sign in");
		
		registeredUserAccount rua=new registeredUserAccount(driver);
		
		 logger.info("register page Opne");
		
		String NameOfUser = rua.getUserName();
		
		 logger.info("user name we are Getting");
		
		if(NameOfUser.equals("Ankit desha"))
		{
			
			 logger.info("verify user name equal or not");
			
			System.out.println("pass");
			
			rua.clickOnSignOut();
			
			 logger.info("Click on sign out");
			
			Assert.assertTrue(true);
		}
		else
		{
			
			System.out.println("failed");
			
			captureScreenShot(driver,"VerifyLogin");
			
			Assert.assertTrue(false);
		}
		
		
		
	}

}
