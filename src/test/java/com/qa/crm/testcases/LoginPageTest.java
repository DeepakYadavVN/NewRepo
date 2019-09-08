package com.qa.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	public LoginPage Loginpage;
	public HomePage homepage;
	public StartDocker startdocker;
	public StopDocker stopdocker;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		//intilization();
		File fi= new File("output.txt");
		if(fi.delete()) {
			System.out.println("file successfully deleted");
		}
		startdocker = new StartDocker();
		startdocker.startfile();
		testDocker();
		Loginpage = new LoginPage();
		stopdocker = new StopDocker();
	}
	
	@AfterMethod
	public void tearDown() throws IOException {
		stopdocker.stopDockerFile();
		//driver.quit();
	}
	
//	@Test
//	public void LoginPageEnterTest() {
//		homepage=Loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
//		homepage.verifyUsername();
//		System.out.println("Docker");
//	}
	@Test
	public void LoginPageEnterTest() {
		Loginpage.login();
	}
	
	@Test
	public void LoginPageEnterTest1(){
		Loginpage.login1();
	}
}
