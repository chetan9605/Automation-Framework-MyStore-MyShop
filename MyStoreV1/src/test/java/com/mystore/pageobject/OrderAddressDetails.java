package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderAddressDetails {
	
	
	WebDriver driver;

	//constructor
	public OrderAddressDetails(WebDriver driver)
	{
		this.driver=driver;
		

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="address1")
	WebElement address;
	
	public void AddressEnter(String Add) 
	{
		address.sendKeys(Add);
	}
	
	
	@FindBy(id="city")
	WebElement City;
	
	public void CityEnter(String cty) 
	{
		City.sendKeys(cty);
	}
	
	@FindBy(id="id_state")
	WebElement State;
	
	public void StateEnter(String state) 
	{
		Select s=new Select(State);
		s.selectByVisibleText(state);
	}
	
	@FindBy(id="postcode")
	WebElement PostCode;
	
	public void PostCodeEnter(String code) 
	{
		PostCode.sendKeys(code);
	}
	

	@FindBy(id="id_country")
	WebElement Country;
	
	public void CountryEnter(String country) 
	{
		Select s=new Select(Country);
		
		s.selectByVisibleText(country);
	}
	
	@FindBy(id="phone")
	WebElement HomePhone;
	
	public void HomePhoneEnter(String homephone) 
	{
		HomePhone.sendKeys(homephone);
	}
	
	
	@FindBy(id="phone_mobile")
	WebElement MobilePhone;
	
	public void MobilePhoneEnter(String Mobilephone) 
	{
		MobilePhone.sendKeys(Mobilephone);
	}

	
	@FindBy(id="alias")
	WebElement AddressTitle;
	
	public void AddressTitleEnter(String addressTitle) 
	{
		AddressTitle.sendKeys(addressTitle);
	}
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement saveClck;
	
	public void saveClick() 
	{
		saveClck.click();
	}
}
