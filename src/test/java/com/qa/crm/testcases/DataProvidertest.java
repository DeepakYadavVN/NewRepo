package com.qa.crm.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidertest {

	String sheetname = "Test";

	
	// Read Data from Excel sheet and call this method in Testclass
	@DataProvider
	public Object[][] gettestReadData() {
		Object data[][] = GetDataReader.getTestData(sheetname);
		return data;
	}

	// Example to get data and print the data and how to pass parameter in methods
	@Test(dataProvider = "gettestReadData")
	public void ReadData(String title, String FirstName, String lastName, String id, String SchoolName, String city) {
		System.out.println(title);
		System.out.println(FirstName);
		System.out.println(lastName);
		System.out.println(id);
		System.out.println(SchoolName);
		System.out.println(city);
	}
}
