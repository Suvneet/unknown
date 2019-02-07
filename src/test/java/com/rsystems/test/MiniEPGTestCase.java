package com.rsystems.test;

import java.text.ParseException;
import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.EpgScreen;
import com.rsystems.pages.MiniEPGScreen;
import com.rsystems.utils.TestInitization;

public class MiniEPGTestCase extends TestInitization {

		
		MiniEPGScreen miniEPGScreen = null;
		/**
		 * This test cases is used to verify Zap Screen from Live TV.
		 * Created By Rahul Dhoundiyal
		 */
		@Test
		public void tc_Mini_EPG_Full_Scree_TV_ZapBanner() throws InterruptedException
		{
			miniEPGScreen = new MiniEPGScreen(driver);
			DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
			dtvChannel.openLiveTV();
			miniEPGScreen.launchAndVerifyZapScreen();
			reports.log(LogStatus.PASS, "Wait for 10 sec Zap banner should dismissed and navigate to LiveTv");
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
			try
			{
				if(miniEPGScreen.headerText.isDisplayed()){
					FailTestCase("Zap banner not getting dismissed");
				}
			}
			catch(NoSuchElementException ex)
			{
				reports.log(LogStatus.PASS, "Zap Banner Getting Dismissed and navigate to live TV");
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		}
		
		/**
		 * This test cases is used to verify mini epg long finished airing episode.
		 * Created By Rahul Dhoundiyal
		 */
		@Test
		public void tc_mini_epg_on_tstv() throws InterruptedException, ParseException{
			
			EpgScreen epgScreen = new EpgScreen(driver);
			epgScreen.goToEpgChannelScreen(true);
			miniEPGScreen = new MiniEPGScreen(driver);
			miniEPGScreen.verifyMiniEPG_long_finished_airing();	
		}
}
