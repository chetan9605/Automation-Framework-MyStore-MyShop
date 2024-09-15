package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddressCheckOutPage {
	
	
	WebDriver driver;

	//constructor
	public OrderAddressCheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[contains(@class,'button btn btn')]")
	WebElement AddressClickCheckOut;
	
	public void AddressOrderProceedCheckOut() 
	{
		AddressClickCheckOut.click();
	}

}
