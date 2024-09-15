package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PrintedSummerPage {
	
	WebDriver driver;

	//constructor
	public PrintedSummerPage(WebDriver driver)
	{
		this.driver = driver;


		PageFactory.initElements(driver, this);
	}

	@FindBy(id="group_1")
	WebElement size;
	
	
	
	public void SelectSize(String setSize)
	{
		
		
		Select s=new Select(size);
		s.selectByVisibleText(setSize);
	}
	
	@FindBy(xpath="//i[@class='icon-plus']")
	WebElement sizeIncrease;
	
	public void increaseSize()
	{
		sizeIncrease.click();
	}
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement cartAddTo;
	
	public void AddToCart()
	{
		cartAddTo.click();
	}
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement checkOutProceedTo;
	
	public void proceedToCheckOut()
	{
		checkOutProceedTo.click();
	}
}
