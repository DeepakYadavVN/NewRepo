package com.qa.crm.testcases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StartDocker {

	public void startfile() throws IOException, InterruptedException {
		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("/Users/dy0618/SmartDeviceTestUS/DemoFreeCrm10/StartDocker.sh");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("docker start1");
		Thread.sleep(3000);
		String text = "output.txt";
		// Read any text file using BufferedReader and passing the object inside
		// buffered class.

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 80);
		long stoptime = cal.getTimeInMillis();
		System.err.println("docker start2");
		while (System.currentTimeMillis() < stoptime) {
			if (flag) {
				break;
			}
			// Read the data from text file.
			BufferedReader reader = new BufferedReader(new FileReader(text));
			String currentline = reader.readLine();
			while (currentline != null && !flag) {
				if (currentline.contains("Selenium Grid hub is up and running")) {
					System.out.println("found my text");
					flag = true;
					break;
				}

				currentline = reader.readLine();
			}
			reader.close();
		}
		Assert.assertTrue(flag);
	}
	
//	@Test
//	public void test() {
//		String selectedTime="10:34";
//		String[]arrTime=selectedTime.split(":",0);
//		System.out.println(arrTime[0]);
//		System.out.println(arrTime[1]);
//	}
}
