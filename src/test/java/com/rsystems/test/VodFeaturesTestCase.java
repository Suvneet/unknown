package com.rsystems.test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.VodFeatures;
import com.rsystems.utils.TestInitization;

public class VodFeaturesTestCase extends TestInitization
{
	@Test
	 public void tc_BCVODVD0118_naviagteToVODTrailer() throws InterruptedException
	 {
		 VodFeatures vod = new VodFeatures(driver);
		 if(vod.naviagteToVideoOndemandScreen())
		 {
			 reports.log(LogStatus.PASS, "Navigation to VOD trailer test case passed");
			 System.out.println("Navigation to VOD trailer is OK");
			 
		 }
		 else
		 {
			 FailTestCase("Navigation to VOD trailer and program running is Failed");
		 }
	 }
	 
	 @Test
	 public void tc_BCVODVD0101_navigateToOndemandScreenHotKey() throws InterruptedException
	 {

			VodFeatures vod = new VodFeatures(driver);
		    if(vod.navigateToVideoOnDemandScreenHotkey())
		    {
		    	reports.log(LogStatus.PASS, "Navigation to VOD test case on demand Screen via hot key is passed");
				System.out.println("Navigation to VOD on demand screen is OK");
		    }
		    else
		    {
		    	FailTestCase("Navigation to VOD on demand screen is Failed");
		    }
		 
	 }
	 
	@Test
	public void tc_BCVODBG0312_VOD_Rent() throws InterruptedException
	{
		VodFeatures vod = new VodFeatures(driver);
		vod.vodOnRent(TestInitization.getExcelKeyValue("RentMovie", "POD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "MovieName"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "PinNumber"));
	}
	
	@Test
	public void tc_BCVODVD0131_VOD_Rent_Zero_Euro() throws InterruptedException
	{
		VodFeatures vod = new VodFeatures(driver);
		vod.rentFreeMovie();
	}
	
	
	@Test
	public void tc_BCVODVD0114_VOD_Current_Rentals() throws InterruptedException
	{
		VodFeatures vod = new VodFeatures(driver);
		vod.rentalVodDeatils();
	}
	 
}
