package com.rsystems.test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.SystemInfoScreen;
import com.rsystems.utils.TestInitization;

public class SystemInfoScreenTestCase extends TestInitization
{
	
	/**
	 * 
	 * Test Case is validating the System Information Screen eg.Software Version
	 * Hardware Version
	 * 
	 * @throws InterruptedException
	 *
	 */
	@Test
	public void verifySettingInfoScreen() throws InterruptedException
	{
		
		SystemInfoScreen systeminfo= new SystemInfoScreen(driver);
		
		if(systeminfo.validationSystemInfoScreen())
		{
			
			reports.log(LogStatus.PASS, "Verification of SystemInfoScreen has Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of SystemInfoScreen OK");
		}
		else
		{
			reports.log(LogStatus.FAIL, "Verification of SystemInfoScreen has Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of SystemInfoScreen OK");
		}
	}
	
}
	
	

	
	


