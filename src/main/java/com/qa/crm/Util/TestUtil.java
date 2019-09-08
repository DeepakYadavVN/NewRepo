package com.qa.crm.Util;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.crm.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOADTIME_OUT=20;
	public static long IMPLICITWAIT=30;
	
	
	public void switchToFrame() {
		driver.switchTo().frame("");
	}
	
	//Select value from DropDown Box
	
	public void selectDropDownValue(WebElement xpath, String Value) {
		List<WebElement> listVal= driver.findElements((By) xpath);
		for(int i=0;i<listVal.size();i++) {
			try {
			if(listVal.get(i).equals(Value)) {
				listVal.get(i).click();
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//Start Docker-- Idea Implement docker with selenium Grid
	
//	public void startDocker() throws IOException {
//		Runtime runtime= Runtime.getRuntime();
//		runtime.exec("\\DemoFreeCrm10\\DockerFile\\DockerCompose.bat");
//		
//	}
}
