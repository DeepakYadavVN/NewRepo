package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage Loginpage;
	HomePage homepage;
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		Loginpage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void LoginPageEnterTest() {
		homepage=Loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
}
