package com.qa.crm.pages;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class CreateDealPage extends TestBase {

	//Page objects
	@FindBy(xpath="//input[@type='text' and @data-field='dealname']")
	WebElement DealName;
	
	@FindBy(xpath="//button[@aria-owns='dropdown-187']//span[contains(@class,'uiDropdown__buttonContents private-dropdown__button__contents')]//span[contains(@class,'private-dropdown__button-label uiDropdown__buttonLabel')]") private List<WebElement> 
	SelectPipeStage;
	
	@FindBy(xpath="//button[starts-with(@id,'uid-ctrl-')]//span[contains(@class,'uiDropdown__buttonContents private-dropdown__button__contents')]//span[contains(@class,'private-dropdown__button-label uiDropdown__buttonLabel')]") private List<WebElement>
	SelectDealStage;
	
	
	public CreateDealPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void pipelineDropDownvalue() {
		List<String> Pipeval= new ArrayList();
		for (WebElement webelement:SelectPipeStage) {
			Pipeval.add(webelement.getText());
		}
		System.out.println(Pipeval);
	}
	
	public void selectDealStagePage() {
		List<String> Dealval= new ArrayList();
		for (WebElement webelement:SelectDealStage) {
			Dealval.add(webelement.getText());
		}
		System.out.println(Dealval);
	}
	
	public void enterDealname(String deal) throws InterruptedException {
		//WebElement ele = driver.findElement(By.xpath("//input[@type='text' and @data-field='dealname']"));
        //Create object of a JavascriptExecutor interface
		//JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments 
        //Here i pass values based on css style. Yellow background color with solid red color border. 
		//js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", DealName);
		DealName.click();
		DealName.sendKeys(deal);
	}
	
}
