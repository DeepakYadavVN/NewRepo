package com.qa.crm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.CreateDealPage;
import com.qa.crm.pages.DealsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class CreateDealPageTest extends TestBase {
	public LoginPage loginpage;
	public HomePage homepage;
	public DealsPage deals;
	public CreateDealPage createDealPage;
	
	public CreateDealPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		loginpage = new LoginPage();
		//homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		deals=new DealsPage();
		createDealPage = new CreateDealPage();
	}
	
	@Test
	public void CreateDealTest() throws InterruptedException {
		homepage.clickSalesLink();
		homepage.clickDealsLink();
		deals.clickCreateDealsLink();
		createDealPage.enterDealname("Deepak");
		createDealPage.pipelineDropDownvalue();
		createDealPage.selectDealStagePage();
	}
}
