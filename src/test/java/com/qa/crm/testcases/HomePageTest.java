package com.qa.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.DealsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	public LoginPage loginpage;
	public HomePage homepage;
	public DealsPage dealspage;
	public HomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		intilization();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealspage= new DealsPage();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

	
	@Test
	public void clickDealTest() {
	}
	
	
}
