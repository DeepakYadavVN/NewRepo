package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class HomePage extends TestBase {

	//PageFactory
	
	@FindBy(xpath="//a[contains(text(),'Marketing')]")
	WebElement MarketingLink;
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	WebElement SalesLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//span[@class='account-name ']")
	WebElement UserName;
	
	//Initialization the page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickMarketingLink() {
		MarketingLink.click();
	}
	
	public void clickSalesLink() {
		SalesLink.click();
	}
	
	public DealsPage clickDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}
	
	public boolean verifyUsername() {
		return UserName.isDisplayed();
	}
}
