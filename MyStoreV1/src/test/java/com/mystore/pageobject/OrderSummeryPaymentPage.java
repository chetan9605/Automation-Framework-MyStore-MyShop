package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummeryPaymentPage {
	
	WebDriver driver;

	//constructor
	public OrderSummeryPaymentPage(WebDriver driver)
	{
		this.driver=driver;
		

		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//span[text()='I confirm my order']")
	WebElement OrderConfirm;
	
	public void ConfirmOrderClick()
	{
		OrderConfirm.click();
	}
}
