package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation {
	
	
	WebDriver driver;
	
	public OrderConfirmation(WebDriver driver)
	{
		this.driver=driver;
		

		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement OrderConfirmation;
	
	public String ConfirmationOfOrder()
	{
		return(OrderConfirmation.getText());
	}

}
