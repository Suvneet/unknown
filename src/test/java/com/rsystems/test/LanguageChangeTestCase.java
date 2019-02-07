package com.rsystems.test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.ChangePreference;
import com.rsystems.utils.TestInitization;

public class LanguageChangeTestCase extends TestInitization
{
	
	/*
	 * This test case is changing default language to French & again resetting the language to NL(Dutch)
	 * 
	 * 
	 */
	
	@Test
	public void LanguageChangeNltoFR() throws InterruptedException
	{
	     ChangePreference pref = new ChangePreference(driver);
	     pref.navigateToMyPreference();
		 
		 
	    //Change to French 
	    if(pref.changeAndVerifyLanguage(TestInitization.getExcelKeyValue("parameters", "language_FR", "name_nl")))
	    {
	    	reports.log(LogStatus.PASS, "Setting of Language to French has Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("verifyLanguageChangedOrNot OK");
	      	
	    }
	    else
	    {
	    	reports.log(LogStatus.FAIL, "Setting of Language to French has Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("verifyLanguageChangedOrNot OK");
	    	
	    }
	    
	    //default LanguageSet
	    if(pref.changeAndVerifyLanguage(TestInitization.getExcelKeyValue("parameters", "language_NL", "name_nl")))
	    {
	    	reports.log(LogStatus.PASS, "Setting of Language to Dutch has Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("verifyLanguageChangedOrNot OK");
	    }
	    else
	    {
	    	reports.log(LogStatus.FAIL, "Setting of Language to Dutch has Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("verifyLanguageChangedOrNot OK");
	    	
	    }   
	}
	    
	    @Test(priority=1)
		public void LanguageChangeFRToNL() throws InterruptedException
		{
		     ChangePreference pref = new ChangePreference(driver);
		     pref.navigateToMyPreference();
		    //Change to Dutch
		    if(pref.changeAndVerifyLanguage(TestInitization.getExcelKeyValue("parameters", "language_FR", "name_nl")))
		    {
		    	reports.log(LogStatus.PASS, "Setting of Language to French has Passed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				System.out.println("verifyLanguageChangedOrNot OK");
		      	
		    }
		    else
		    {
		    	reports.log(LogStatus.FAIL, "Setting of Language to French has Failed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				System.out.println("verifyLanguageChangedOrNot OK");
		    	
		    }
		    
		    //defaultLanguageSet
		    if(pref.changeAndVerifyLanguage(TestInitization.getExcelKeyValue("parameters", "language_NL", "name_nl")))
		    {
		    	reports.log(LogStatus.PASS, "Setting of Language to Dutch has Passed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				System.out.println("verifyLanguageChangedOrNot OK");
		    }
		    else
		    {
		    	reports.log(LogStatus.FAIL, "Setting of Language to Dutch has Failed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				System.out.println("verifyLanguageChangedOrNot OK");
		    	
		    }       
	    
	}
	

	
	
}
