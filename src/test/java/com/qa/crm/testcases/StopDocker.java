package com.qa.crm.testcases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;

public class StopDocker {

	public void stopDockerFile() throws IOException {
		boolean flag = false;
		Runtime run = Runtime.getRuntime();
		try {
			run.exec("/Users/dy0618/SmartDeviceTestUS/DemoFreeCrm10/StopDocker.sh");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String textfile = "output.txt";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 60);
		long stoptime = cal.getTimeInMillis();

		while (System.currentTimeMillis() < stoptime) {

			if (flag) {
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader(textfile));
			String Currentline = reader.readLine();
			while (Currentline != null && !flag) {
				if (Currentline.contains("selenium-hub exited")) {
					System.out.println("finally close selenium-hub");
					flag = true;
					break;
				}
				Currentline = reader.readLine();
			}
			reader.close();
		}
		Assert.assertTrue(flag);
	}
}
