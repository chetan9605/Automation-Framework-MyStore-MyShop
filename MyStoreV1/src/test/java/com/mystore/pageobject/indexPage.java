package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	//1. create object of webdriver
	WebDriver driver;

	//constructor
	public indexPage(WebDriver driver)
	{
		this.driver=driver;
		

		PageFactory.initElements(driver, this);
	}


	//identify webelements
	@FindBy(linkText = "Sign in") 
	WebElement signIn;
	
	//identify action on webelement
		public void clickOnSignIn() {
			signIn.click();
		}
	
		
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	WebElement tshirtMenu;
	
	public void clickOnTShirtMenu()
	{
		tshirtMenu.click();
	}
	
	
	
	
	public String getPageTitle()
	{
		return(driver.getTitle());
	}
	
	
	
}
