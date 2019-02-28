package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.crm.Util.TestUtil;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/qa/crm/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void intilization() {
		
		String Browseranme=prop.getProperty("browser");
		if(Browseranme.equals("chrome")) {
			System.setProperty("Webdriver.chrome.driver","/Users/dy0618/SmartDeviceTestUS/DemoFreeCrm10/ChromeDriver");
			driver = new ChromeDriver();
		}else if(Browseranme.equals("FF")) {
			System.setProperty("Webdriver.gecko.driver","/Users/dy0618/Documents/ChromeDriver");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOADTIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
