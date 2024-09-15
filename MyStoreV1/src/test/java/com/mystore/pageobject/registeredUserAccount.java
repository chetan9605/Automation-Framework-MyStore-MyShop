package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUserAccount {

	//1. create object of webdriver
	WebDriver driver;

	//constructor
	public registeredUserAccount(WebDriver driver)
	{
		this.driver = driver;


		PageFactory.initElements(driver, this);
	}


	//identify webelements
	//@FindBy(xpath = "//a[@title='View my customer account']") 
	@FindBy(xpath = "//a[@class='account']/child::span") 
	WebElement userName;
	
	
	public String getUserName()
	{
		String text = userName.getText();

		return text;
	}
	
	

	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	
	public void clickOnSignOut()
	{
		signOut.click();
	}
	
	
	
	
	
	@FindBy(name ="search_query")
	WebElement searchBox;
	
	public void EnterDataInSearchBox(String searchKey)
	{
		searchBox.sendKeys(searchKey);
	}


	@FindBy(name ="submit_search")
	WebElement submit_search;
	
	public void ClickOnSearchButton()
	{
		submit_search.click();

	}
	
	
	

	@FindBy(linkText = "Women")
	WebElement WomenMenu;

	@FindBy(linkText="T-shirts")
	WebElement TShirtMenu;

	
	
	
	
	



	
	

	
	public void MouseOverTShirtMenu()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(WomenMenu).moveToElement(TShirtMenu).click().perform();
	}




}
