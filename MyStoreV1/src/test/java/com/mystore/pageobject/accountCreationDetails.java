package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {

	//1. create object of webdriver
	WebDriver driver;

	//constructor
	public accountCreationDetails(WebDriver driver)
	{
		this.driver = driver;


		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id = "id_gender1") //Title-Mrs
	WebElement titleMr;
	
	public void selectTitleMr()
	{
		titleMr.click();
	}
	
	@FindBy(id="customer_firstname")
	WebElement custfirstName;
	
	public void enterCustomerFirstName(String fname)
	{
		custfirstName.sendKeys(fname);
	}
	
	
	
	

	//identify webelements
	@FindBy(id = "id_gender2") //Title-Mrs
	WebElement titleMrs;
	
	

	@FindBy(id="customer_lastname")
	WebElement custlastName;

	
	public void enterCustomerLastName(String lname)
	{
		custlastName.sendKeys(lname);
	}
	
	@FindBy(id="passwd")
	WebElement password;
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	@FindBy(id="submitAccount")
	WebElement register;
	
	
	public void clickOnRegister()
	{
		register.click();
	}
	

	
	

	
	
	
	
	/*@FindBy(id="firstname")
	WebElement addFirstname;

	@FindBy(id="lastname")
	WebElement addLastname;

	//address1
	@FindBy(id="address1")
	WebElement address1;

	@FindBy(id="city")
	WebElement city;

	//id_state
	@FindBy(id="id_state")
	WebElement state;

	@FindBy(id="postcode")
	WebElement postcode;


	@FindBy(id="id_country")
	WebElement country;

	//phone_mobile
	@FindBy(id="phone_mobile")
	WebElement phone_mobile;

	//alias
	@FindBy(id="alias")
	WebElement alias;


	
	//identify actions to be performed on web elements

	public void selectTitleMrs()
	{
		titleMrs.click();
	}

	
	

	

	

	public void enterAddressFirstName(String fname)
	{
		addFirstname.clear();

		addFirstname.sendKeys(fname);
	}

	public void enterAddressLastName(String lname)
	{
		addLastname.clear();

		addLastname.sendKeys(lname);
	}

	public void enterAddress(String address)
	{
		address1.sendKeys(address);
	}

	public void enterCity(String cityName)
	{
		city.sendKeys(cityName);
	}

	public void selectState(String text)
	{
		Select obj = new Select(state);
		obj.selectByVisibleText(text);
	}

	public void enterPostcode(String postcodeData)
	{
		postcode.sendKeys(postcodeData);
	}

	public void selectCountry(String text)
	{
		Select obj = new Select(country);
		obj.selectByVisibleText(text);
	}

	public void enterMobilePhone(String mobile)
	{
		phone_mobile.sendKeys(mobile);
	}

	public void enterAlias(String text)
	{
		alias.clear();
		alias.sendKeys(text);
	}
                                                                     */
	
}
