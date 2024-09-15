package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;

import junit.framework.Assert;
import testBase.BaseClass;

public class TC_001VerifyUserRegisterLogin  extends BaseClass  {  //1. Launch Browser
	                                                              //2.open url https://automationPractice.com
	                                                              //3.click on sigh in link
	                                                              //4.Enter email in create account section
	@Test  (enabled=true)                                         //5.Click on create account button
	public void verifyRegistrationAndLogin()                      //6.Enter your personal information address and contact
	{                                                             //7.click on register button
		                                                          //8.Validate the user is created
		logger.info("Launch Browser");                            //9.Click on sign out

		
		indexPage ip=new indexPage(driver);
		
		logger.info("Index page Open");

		ip.clickOnSignIn();
		
		logger.info("Click sign link ");

		
		myAccountPage ap=new myAccountPage(driver);
		
		logger.info("My Account Page");

		
		ap.enterCreateEmailAddress(randomeString()+"@gmail.com");
		
		logger.info("Enter email for create account");

		
		ap.clickSubmitCreate();
		
		logger.info("Click of create account");
		
		accountCreationDetails acd=new accountCreationDetails(driver);
		
		logger.info("account deatils page");
		
		acd.selectTitleMr();
		
		logger.info("Click on Mr");
		
		 acd.enterCustomerFirstName("Ankit");
		
		logger.info("Write first namet");
		
		acd.enterCustomerLastName("desha");
		
		logger.info("Write last name");
		
		acd.enterPassword(randomeAlphaNumeric());
		
		logger.info("Write passowrd");
		
	    acd.clickOnRegister();
		
		logger.info("Click on register");
		
		registeredUserAccount  rg=new registeredUserAccount(driver);
		
		logger.info("My account sign out page");
		
		String username = rg.getUserName();
		
		Assert.assertEquals("Ankit desha",username); 
		
		logger.info("get user name");
		
		
       rg.clickOnSignOut();
       
       logger.info("Click on sign out");
		
		
	}
	

}
