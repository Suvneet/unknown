package com.rsystems.test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.ActivateInfobanner;
import com.rsystems.utils.TestInitization;



public class ActivateInfoBannerTestCase extends TestInitization
{
	/*
	 * This test case is verifying the Active Banner screen
	 * 
	 * 
	 */
	
	@Test
	public void tc_BCDTVIB0603_verifyInfoBannerScreen() throws InterruptedException
	{
		ActivateInfobanner active = new ActivateInfobanner(driver);
		active.navigateToActivateInfoBannerScreen();
		if(active.verifyActiveInfoBannerScreen())
		{
			
			reports.log(LogStatus.PASS, "verifyActiveInfoBannerScreen has been passed");
			System.out.println("verifyActiveInfoBannerScreen is OK");
		}
		else
		{
			FailTestCase("Verify Active InfoBanner Screen has been Failed");
		}
		
		
	}
}
