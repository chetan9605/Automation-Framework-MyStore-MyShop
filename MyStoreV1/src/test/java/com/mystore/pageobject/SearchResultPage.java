package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver driver;

	//2. Create constructor
	public SearchResultPage(WebDriver driver)
	{
		driver = driver;
		PageFactory.initElements(driver, this);//driver that will be used to lookup the web element

	}

	//Identify the elements present in search result page



//	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")
//	WebElement searchResultProduct ;
	
	@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts' and @class='product-name']")
	WebElement searchResultProduct ;
	
	
	public String getSearchResultProductName()
	{
		return(searchResultProduct.getText());
	}
	
	
	
	//action methods on web elements of search result page
	
	/*@FindBy(linkText="More")
	WebElement more;
	
	public void ClickOnMoreLink()
	{
		more.click();
      }                                       */
	
	@FindBy(xpath="(//a[contains(text(),'Printed Summer Dress')])[1]")
	WebElement Dress;
	
	public void PrintedSummer()
	{
		Dress.click();
	}
}
