package com.qa.crm.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.Util.TestUtil;
import com.qa.crm.base.TestBase;
import com.qa.crm.pages.DealsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class DealsPageTest extends TestBase {
	public LoginPage loginpage;
	public HomePage homepage;
	public DealsPage deals;
	public TestUtil testutil;
	public StartDocker startdocker;
	public StopDocker stopdocker;

	public DealsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		// intilization();
		startdocker = new StartDocker();
		stopdocker = new StopDocker();
		loginpage = new LoginPage();
		// homepage=loginpage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		deals = new DealsPage();
		startdocker.startfile();
		testDocker();
	}

	@AfterMethod
	public void tearDown() {
		try {
			stopdocker.stopDockerFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createDealPageTest() {
		homepage.clickSalesLink();
		deals.clickCreateDealsLink();

	}

	@Test
	public void testDeal() throws IOException, InterruptedException {
		deals.testdeal();

	}
}
