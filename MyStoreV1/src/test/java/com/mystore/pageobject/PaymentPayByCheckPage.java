package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPayByCheckPage {
	
	
	WebDriver driver;

	//constructor
	public PaymentPayByCheckPage(WebDriver driver)
	{
		this.driver=driver;
		

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='cheque']")
	WebElement Check;
	
	public void PaybyCheck()
	{
		Check.click();
	}

}
