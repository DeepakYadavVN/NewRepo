package com.qa.crm.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
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
	public StartDocker startdocker;
	public StopDocker stopdocker;
	public HomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void Setup() throws InterruptedException, IOException {
		File fi= new File("output.txt");
		if(fi.delete()) {
			System.out.println("file successfully deleted");
		}
		startdocker = new StartDocker();
		startdocker.startfile();
		testDocker();
		loginpage= new LoginPage();
		//homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealspage= new DealsPage();
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		stopdocker.stopDockerFile();
		//driver.quit();
	}

	
	@Test
	public void clickDealTest() {
		homepage.testlink();
	}
	
	
}
