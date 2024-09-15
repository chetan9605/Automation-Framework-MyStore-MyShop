package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummeryPage {
	
	
	WebDriver driver;

	//constructor
	public ShoppingCartSummeryPage(WebDriver driver)
	{
		this.driver = driver;


		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@class,'button btn btn')]")
	WebElement checkProceedOut;
	
	public void proceedCheckOutSCSP()
	{
		checkProceedOut.click();
	}

	
	

}
