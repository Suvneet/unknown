package com.rsystems.test;

import org.testng.annotations.Test;

import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.HotKeysNavigation;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class HotKeysTestCase extends TestInitization {

	/*
	 * This test case is navigating to Shop screen & Epg screen and from there
	 * clicking on the TV Hot key it was returning to the TV screen
	 */

	@Test
	public void tc_BCDTVDT0101_navigateMultipleScreensToDTV() throws InterruptedException {
		HotKeysNavigation keys = new HotKeysNavigation(driver);
		keys.navigateToDTvFromShopScreen();
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		dtv.openLiveTV();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		dtv.changeChnlAndInfoBannerValidation(Unicode.VK_INFO);
		keys.navigateToDtvScreenFromEpgScreen();
		dtv.openLiveTV();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		dtv.changeChnlAndInfoBannerValidation(Unicode.VK_INFO);
	}

	// This test case is navigating to Radio screen and verifying the channel
	// number

	@Test
	public void tc_BCDTVRAD0501_navigateToRadioScreen() throws InterruptedException {
		HotKeysNavigation keys = new HotKeysNavigation(driver);
		keys.navigateToRadioScreen();
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		dtv.openLiveTV();
		driver.switchTo().frame(getCurrentFrameIndex());
		dtv.changeChnlAndInfoBannerValidation(Unicode.VK_INFO);

	}

	// This test case is navigating from Radio screen to DTV screen and
	// verifying the channel number

	@Test
	public void tc_BCDTVRAD0503_navigateRadioToDtvScreen() throws InterruptedException {
		HotKeysNavigation keys = new HotKeysNavigation(driver);
		keys.navigateToRadioScreenToDTvScreen();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		dtv.openLiveTV();
		driver.switchTo().frame(getCurrentFrameIndex());
		dtv.changeChnlAndInfoBannerValidation(Unicode.VK_INFO);
	}
}
