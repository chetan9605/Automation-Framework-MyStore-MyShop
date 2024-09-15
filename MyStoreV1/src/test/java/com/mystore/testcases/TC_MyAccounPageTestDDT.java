package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;
import com.mystore.utilities.ReadExcelFile;

import junit.framework.Assert;
import testBase.BaseClass;

public class TC_MyAccounPageTestDDT extends BaseClass {
	
	
	@Test  (enabled=true)
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
	
	
	@Test ( dataProvider="LoginDataProvider")
	public void verifyLogin(String userEmail, String pwd ,String expectedUsername) throws InterruptedException, IOException
	{
	 
		
		
		indexPage ip=new indexPage(driver);
		
		logger.info("index page open");
		
		ip.clickOnSignIn();
		
		logger.info("Sign in click");

		
		myAccountPage ap=new myAccountPage(driver);
		
		logger.info("My account page open");

		
		ap.enterEmailAddress(userEmail);
		
		logger.info("Enter email");

		
		ap.enterPassword(pwd);
		
		logger.info("Enter password");

		
		
		ap.clickSignIn();
		
		logger.info("Click on sign");
		
		

		
		registeredUserAccount rua=new registeredUserAccount(driver);
		
		logger.info("Register page");
		
		
		String NameOfUser = rua.getUserName();
		
		logger.info("getting username");
		
		if(NameOfUser.equals(expectedUsername))
		{
			logger.info("check expected and actual");
			
			System.out.println("pass");
			
			rua.clickOnSignOut();
			
			logger.info("sign out");
			
			Assert.assertTrue(true);
		}
		else
		{
			
			System.out.println("failed");
			
			logger.info("failed");
			
			captureScreenShot(driver,"VerifyLogin");
			
			logger.info("screenshot capture");
			Assert.assertTrue(false);
		}                                                                       
		
	
	}
		
		
		
		@DataProvider(name = "LoginDataProvider")
		public String[][] LoginDataProvider()
		{
			//System.out.println(System.getProperty("user.dir"));
			String fileName = System.getProperty("user.dir") + "\\TestData\\MyStroreTestData.xlsx";


			int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginData"); // excel file name and sheet name
			int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginData");
		

			String data[][]=new String[ttlRows-1][ttlColumns];

			for(int i=1;i<ttlRows;i++)//rows =1,2
			{
				for(int j=0;j<ttlColumns;j++)//col=0, 1,2
				{

					data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginData", i,j);
				}

			}
			return data;
		}
		
		

	

}
