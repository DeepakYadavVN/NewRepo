package com.qa.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.crm.Util.TestUtil;

public class TestBase {
	public static Properties prop;
	//public static WebDriver driver;
	public static RemoteWebDriver driver;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/qa/crm/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void intilization() {
		String Browseranme = prop.getProperty("browser");
		if (Browseranme.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/dy0618/SmartDeviceTestUS/DemoFreeCrm10/ChromeDriver/chromedriver 3");
			driver = new ChromeDriver();
		} else if (Browseranme.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/dy0618/Documents/ChromeDriver");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOADTIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	public void testDocker() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL u = new URL("http://localhost:4444/wd/hub");
		System.err.println("step2");
		Thread.sleep(5000);
		driver = new RemoteWebDriver(u, cap);
		System.err.println("step3");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOADTIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
