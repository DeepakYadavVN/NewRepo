package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class LoginPage extends TestBase {
	//PageFactory-OR
	
		@FindBy(xpath="//input[@type='email']")
		WebElement Email;
		
		@FindBy(xpath="//input[@type='password']")
		WebElement Password;
		
		@FindBy(xpath="//button[@type='submit' and @id='loginBtn']")
		WebElement LoginBtn;
		
		// Intilization PageObject
		public LoginPage() {
			PageFactory.initElements(driver,this);
		}
		
		//Actions
//		public HomePage login(String un, String pwd) {
//			Email.sendKeys(un);
//			Password.sendKeys(pwd);
//			LoginBtn.click();
//			return new HomePage();
//		}
		
		public void login() {
			driver.get("http://google.com");
			System.out.println(driver.getTitle());
		}
		
		public void login1(){
			driver.get("https://clarity.dexcom.eu/");
			System.out.println("Item 1"+ driver.getTitle());
		}
}
