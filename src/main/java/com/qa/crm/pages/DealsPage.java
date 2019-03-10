package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class DealsPage extends TestBase {

	//Page Objects
	@FindBy(xpath="//span[contains(text(),'Create deal')]")
	WebElement CreateDealsLink;
	
	
	//Intilization Page Objects
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CreateDealPage clickCreateDealsLink() {
		CreateDealsLink.click();
		return new CreateDealPage();
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}
}
