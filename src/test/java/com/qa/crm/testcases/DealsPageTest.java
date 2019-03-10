package com.qa.crm.testcases;

import org.testng.annotations.BeforeMethod;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.DealsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class DealsPageTest extends TestBase {
	public LoginPage loginpage;
	public HomePage homepage;
	public DealsPage deals;

	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		deals=new DealsPage();
	}
	
	public void createDealPageTest() {
		homepage.clickSalesLink();
		deals.clickCreateDealsLink();
		
	}
}
