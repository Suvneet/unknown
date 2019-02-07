package com.rsystems.test;

import org.testng.annotations.Test;

import com.rsystems.pages.RcArrowKeys;
import com.rsystems.pages.RecordingScreen;
import com.rsystems.utils.TestInitization;

public class RcArrowKeysTestCase extends TestInitization
{
   // This test case is verifying the key navigations of Epg,VOD,PVR screen 
	@Test
	public void tc_BCREMC0107_verifyNavigationEpgScreen() throws InterruptedException
	{
		RcArrowKeys rc = new RcArrowKeys(driver);
	    rc.verifyNavigationToEpgScreen();
	    rc.verifyNavigationToVODScreen();
	    RecordingScreen record = new RecordingScreen(driver);
		record.verifyNavigationInPlannedRecording();
	}
}