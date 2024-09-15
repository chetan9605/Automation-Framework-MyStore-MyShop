package com.mystore.testcases;
//1.Launch Browser
//2.open url
//3.Login with username and pwd click on sign in
//4.Enter 'T-shirt' in search box
//5.Click on search button
//6.Click on 'Printed summer Dress'
//7.Select size 'M'
//8.Select quantity 2
//9.Click on add to card
//10.Click on 'Proceed to checkout'
//11.Click on Again to Proceed to CheckOut
//12.Click on Again Proceed to checkOut
//13.Click on Select Terms of Services
//14.Click on Proceed to CheckOut in Shopping
//15.Click on Pay with Cheque
//16.Click on Confirm Order
//17.Verify Your Order on My Shop is Complete.
import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.OrderAddressCheckOutPage;
import com.mystore.pageobject.OrderConfirmation;
import com.mystore.pageobject.OrderShippingTermsPage;
import com.mystore.pageobject.OrderSummeryPaymentPage;
import com.mystore.pageobject.PaymentPayByCheckPage;
import com.mystore.pageobject.PrintedSummerPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.ShoppingCartSummeryPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;

import junit.framework.Assert;
import testBase.BaseClass;

public class TC_004BuyProduct extends BaseClass {
	
	@Test
	public void VerifyBuyProduct() throws InterruptedException, IOException
	{
		logger.info("Browser Launch"); 
		indexPage ip=new indexPage(driver); 
		
		logger.info("Index page open");
		
		ip.clickOnSignIn();     
		
		logger.info("Click On sign in Link"); 
		
		myAccountPage ap=new myAccountPage(driver);     
		
		logger.info("Account page open"); 
		
		ap.enterEmailAddress("xyzg@gmail.com"); 
		
		logger.info("Enter email address"); 
		
		ap.enterPassword("Ankit@123");  
		
		logger.info("Enter pwd"); 
		
		ap.clickSignIn();   
		
		logger.info("Click on Sign in link");
		
		registeredUserAccount ra=new registeredUserAccount(driver); 
		
		logger.info("Register page open"); 
		
		ra.ClickOnSearchButton();  
		
		
		ra.EnterDataInSearchBox("T-shirt");                          
		
		SearchResultPage  sp=new SearchResultPage(driver);
		
		sp.PrintedSummer();
		
		PrintedSummerPage ps=new PrintedSummerPage(driver);
		
		ps.SelectSize("M");
		
		ps.increaseSize();
	
		ps.AddToCart();
		
		ps.proceedToCheckOut();
		
		ShoppingCartSummeryPage scsp=new ShoppingCartSummeryPage(driver);
		
		scsp.proceedCheckOutSCSP();
		
		OrderAddressCheckOutPage oac=new OrderAddressCheckOutPage(driver);
		
		oac.AddressOrderProceedCheckOut();
		
		OrderShippingTermsPage os=new OrderShippingTermsPage(driver);
		
		os.CheckBoxClick();
		
		os.AddressShippingCheckOut();
		
		
		PaymentPayByCheckPage chck=new PaymentPayByCheckPage(driver);
		
		chck.PaybyCheck();
		
		
		OrderSummeryPaymentPage pp=new OrderSummeryPaymentPage(driver);
		
		pp.ConfirmOrderClick();
		
		OrderConfirmation oc=new OrderConfirmation(driver);
		
		String verify = oc.ConfirmationOfOrder();
		
		if(verify.equals("Your order on My Shop is complete."))
		{
			System.out.println("pass");
			
			ra.clickOnSignOut();
			
             logger.info("Click on sign out");
			
			Assert.assertTrue(true);
		}
		else
		{
			
			System.out.println("failed");
			
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
		
		
		Thread.sleep(5000);
		
		
		
	
	}


}
