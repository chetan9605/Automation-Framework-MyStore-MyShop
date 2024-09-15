package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPage {

	//1. create object of webdriver
	WebDriver driver;

	//constructor
	public myAccountPage(WebDriver driver)
	{
		this.driver = driver;


		PageFactory.initElements(driver, this);
	}


	//identify webelements
	
	//create new account
	@FindBy(id = "email_create") 
	WebElement createEmailId;
	
	public void enterCreateEmailAddress(String emailAdd) 
	{
		createEmailId.sendKeys(emailAdd);
	}
	

	@FindBy(id="SubmitCreate")
	WebElement SubmitCreate;
	
	public void clickSubmitCreate()
	{
		SubmitCreate.click();
	}

	
	//Already registered users
	@FindBy(id = "email") 
	WebElement registeredUsersEmail;
	
	public void enterEmailAddress(String emailAdd) 
	{
		registeredUsersEmail.sendKeys(emailAdd);
	}
	
	@FindBy(id = "passwd") 
	WebElement registeredUsersPwd;
	
	
	public void enterPassword(String pwd) 
	{
		registeredUsersPwd.sendKeys(pwd);
	}
	
	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;
	

	public void clickSignIn()
	{
		submitLogin.click();
	}

	
	
	//identify action on webelement
	
	
	
	

	
	
	
	//ACTIONS METHODS FOR ALREADY REGISTERED USERS
	
	

	

	
}
