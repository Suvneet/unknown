package com.rsystems.test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.TvFilterLayer;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class TvFilterLayerTestCase extends TestInitization
{
	
	/*
	 * This test case is checking the TV Filter Layer Screen 
	 */
	
	@Test
	public void verifyTvFilterLayerScreen() throws InterruptedException
	{
		TvFilterLayer tv= new TvFilterLayer(driver);
		if(tv.tvFilterLayerVerify())
		{
			reports.log(LogStatus.PASS, "Content in the TV filter layer screens has been matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Content has been matched");
		}
		else
		{
			FailTestCase("Content in the TV filter layer screens has not been matched");
		}
	}

}
