package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.OrderAddressCheckOutPage;
import com.mystore.pageobject.OrderAddressDetails;
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

public class TC_BuyProduct extends BaseClass {
	
	
	@Test
	public void VerifyBuyProduct() throws InterruptedException, IOException
	{
		indexPage ip=new indexPage(driver);
		
		ip.clickOnSignIn();
		
		myAccountPage ap=new myAccountPage(driver);
		
		ap.enterEmailAddress("xyzg@gmail.com");
		
		ap.enterPassword("Ankit@123");
		
		ap.clickSignIn();
		
		registeredUserAccount ra=new registeredUserAccount(driver);
		
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
