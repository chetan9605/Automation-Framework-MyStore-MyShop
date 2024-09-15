package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingTermsPage {
	
	

	WebDriver driver;

	//constructor
	public OrderShippingTermsPage(WebDriver driver)
	{
		this.driver=driver;
		

		PageFactory.initElements(driver, this);
	}

	@FindBy(id="cgv")
	WebElement CheckBox;
	
	public void CheckBoxClick()
	{
		CheckBox.click();
	}
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement AddressShippingClickCheckOut;
	
	public void AddressShippingCheckOut() 
	{
		AddressShippingClickCheckOut.click();
	}
}
