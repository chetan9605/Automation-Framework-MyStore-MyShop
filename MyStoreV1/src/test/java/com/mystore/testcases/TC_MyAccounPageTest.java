package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;

import junit.framework.Assert;
import testBase.BaseClass;

public class TC_MyAccounPageTest extends BaseClass {
	
	
	@Test  (enabled=false)
	public void verifyRegistrationAndLogin()
	{
		
		logger.info("Test case started");

		
		indexPage ip=new indexPage(driver);
		
		logger.info("Index Page");

		ip.clickOnSignIn();
		
		logger.info("Click sign");

		
		myAccountPage ap=new myAccountPage(driver);
		
		logger.info("My Account Page");

		
		ap.enterCreateEmailAddress(randomeString()+"@gmail.com");
		
		logger.info("Enter email");

		
		ap.clickSubmitCreate();
		
		logger.info("Click of crate account");
		
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
	
	
	@Test (enabled=true)
	public void verifyLogin() throws InterruptedException, IOException
	{
	 
		indexPage ip=new indexPage(driver);
		
		 logger.info("index page");
		
		ip.clickOnSignIn();
		
		 logger.info("Click on sign in");
		
		myAccountPage ap=new myAccountPage(driver);
		
		 logger.info("my account page");
		
		ap.enterEmailAddress("xyzg@gmail.com");
		
		 logger.info("email");
		
		ap.enterPassword("Ankit@123");
		
		 logger.info("pass");
		
		Thread.sleep(5000);
		
		ap.clickSignIn();
		
		 logger.info("Click on sign in");
		
		registeredUserAccount rua=new registeredUserAccount(driver);
		
		 logger.info("register page");
		
		String NameOfUser = rua.getUserName();
		
		 logger.info("user name");
		
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
	
	
	@Test
	public void VerifySearchProduct() throws InterruptedException, IOException
	{
		indexPage ip=new indexPage(driver);
		
		ip.clickOnSignIn();
		
		myAccountPage ap=new myAccountPage(driver);
		
		ap.enterEmailAddress("xyzg@gmail.com");
		
		ap.enterPassword("Ankit@123");
		
		ap.clickSignIn();
		
		
		registeredUserAccount rg=new registeredUserAccount(driver);
		
		rg.EnterDataInSearchBox("T-shirt");
		
		
		Thread.sleep(5000);
		
		rg.ClickOnSearchButton();
		
		SearchResultPage sp=new SearchResultPage(driver);
		
		String TshirtName = sp.getSearchResultProductName();
		
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
