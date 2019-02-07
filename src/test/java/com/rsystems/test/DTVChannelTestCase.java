package com.rsystems.test;

import java.text.ParseException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.RentMovie;
import com.rsystems.pages.ZapList;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class DTVChannelTestCase extends TestInitization {

	/**
	 * @throws InterruptedException
	 *             Test case validate the info banner in live TV screen
	 */

	@Test
	public void tc_BCDTVDT0105_DTVChannelInfobanner() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.openLiveTV();

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);

		driver.switchTo().frame(getCurrentFrameIndex());

		isDisplayed(dtvChannelScreen.chnlNoIn_Infobar, "Channel Number");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.programDurationIn_Infobar, "program duration");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.programTitle, "Program title");

		// Now wit for 5 second to hide the info banner
		Thread.sleep(5000);

		isNotDisplayed(dtvChannelScreen.chnlNoIn_Infobar, "Channel Number");
		isNotDisplayed(dtvChannelScreen.programDurationIn_Infobar, "program duration");
		isNotDisplayed(dtvChannelScreen.programTitle, "Program title");

	}

	/**
	 * @throws InterruptedException
	 *             Test case open the live TV and validate the corresponding
	 *             channel number
	 */

	@Test
	public void tc_BCDTVDT0106_DTV_ChannelZapViaChannelNumberExisting() throws InterruptedException {

		String pressChannelNumber = "5";

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();

		reports.log(LogStatus.PASS, "Press a channel number which is available");
		sendKeyMultipleTimes("NUMPAD5", 1, 4000);
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());

		String ActualChannelNo = dtvChannelScreen.chnlNoIn_Infobar.getText();
		if (ActualChannelNo.equalsIgnoreCase(pressChannelNumber)) {
			reports.log(LogStatus.PASS, "Verification of Channel ZapVia Channel Number Existing Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}

		else {
			FailTestCase("Verification of Channel ZapVia Channel Number Existing Failed Actual Channel: "
					+ ActualChannelNo + "and expected : " + pressChannelNumber);
		}
	}

	/**
	 * @throws InterruptedException
	 *             Press a channel number which is not available in list also
	 *             validate the Zap list
	 * 
	 */

	@Test
	public void DTV_ChannelZapViaChannelNumberNotExisting() throws InterruptedException {

		ZapList zapList = new ZapList(driver);
		new DTVChannelScreen(driver).openLiveTV();

		reports.log(LogStatus.PASS, "Press a channel number which is NOT available");
		sendNumaricKeys(321);
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

		Thread.sleep(2000);
		/** Verify the zap list */
		driver.switchTo().frame(getCurrentFrameIndex());
		String actualFocousChannel = zapList.focousChannelNumber.getText();

		if (actualFocousChannel
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "ExpectedFocousChannel", "Values"))) {
			reports.log(LogStatus.PASS, "Page Successfully move to zaplist page");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}

		else {
			FailTestCase("Unable to move zaplist page " + " Expected Focus channel : "
					+ TestInitization.getExcelKeyValue("DTVChannel", "ExpectedFocousChannel", "Values")
					+ "Actual Focus Channel : " + actualFocousChannel);

		}
	}

	/**
	 * @throws InterruptedException
	 *             Test case validate the functionality of CH+/CH- and first and
	 *             last channel
	 */

	@Test
	public void DTV_Channel_Zap_Via_Up_Down() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());
		int currentChannelNo = Integer.parseInt(dtvChannelScreen.chnlNoIn_Infobar.getText());

		// Channel up and validation
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS, (currentChannelNo + 1) + "",
				"Navigate Screen to next channel");
		// Channel down and validation
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_CHANNEL_MINUS, (currentChannelNo) + "",
				"Navigate Screen to previous channel");

		// Go to first channel
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "FirstChannelNumber", "Values"))));

		Thread.sleep(1000);

		// Check last channel of Live TV
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_CHANNEL_MINUS,
				TestInitization.getExcelKeyValue("DTVChannel", "LastChannelNumber", "Values"),
				"Navigate Screen to last channel");

		// Check the first Channel Number
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS,
				TestInitization.getExcelKeyValue("DTVChannel", "FirstChannelNumber", "Values"),
				"Navigate Screen to First channel");

	}

	/**
	 * @throws InterruptedException
	 *             Test case validate the HD and SD channel
	 */

	@Test
	public void tc_BCDTVDT0110_DTV_HD_SD_Zap() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.openLiveTV();
		// Change channel to HD and validation

		reports.log(LogStatus.PASS, "Navigate to HD channel");
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "HDChannelNumber", "Values"))));
		reports.attachScreenshot(captureCurrentScreenshot());

		// validate live TV has been move to HD channel
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(dtvChannelScreen.hdIcon, "HD Icon");

		reports.log(LogStatus.PASS, "Navigate to SD channel");
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "SDChannelNumber", "Values"))));
		reports.attachScreenshot(captureCurrentScreenshot());

		// validate live TV has been move to HD channel
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		isNotDisplayed(dtvChannelScreen.hdIcon, "HD Icon");

	}

	/**
	 * @throws InterruptedException
	 *             Test case validate the ZAP banner item [Channel Logo ,
	 *             channel number] After changing the channel number using RC
	 */

	@Test
	public void DTVZAP002ZappinginFullscreenDTVShowinfoonzapsettingYES() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.openLiveTV();

		driver.switchTo().frame(getCurrentFrameIndex());
		// channel plus and validation
		dtvChannelScreen.changeChnlAndInfoBannerValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS);

		// channel Minus and validation
		dtvChannelScreen.changeChnlAndInfoBannerValidation(Unicode.VK_CHANNEL_MINUS);

		// change channel and check again
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "HDChannelNumber", "Values"))));

		// channel plus and validation
		dtvChannelScreen.changeChnlAndInfoBannerValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS);

		// channel Minus and validation
		dtvChannelScreen.changeChnlAndInfoBannerValidation(Unicode.VK_CHANNEL_MINUS);

	}

	/**
	 * @throws InterruptedException
	 *             Test case validate the functionality of pause and play from
	 *             RC
	 */

	@Test
	public void pause_LiveTV_play() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		dtvChannelScreen.pressPauseButtonAndValidation();
		Thread.sleep(5000);
		dtvChannelScreen.pressPlayButtonAndValidation();

	}

	/**
	 * @throws InterruptedException
	 *             test case validate the functionality of pause and play in
	 *             back to live page
	 */

	@Test
	public void pause_LiveTV_PLTV_BackToLive() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		reports.log(LogStatus.PASS, "Navigate to DTV Screen");
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Changed channel to 1");
		TestInitization.sendNumaricKeys(1);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Navigate to action list");
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		try {

			if (!dtvChannelScreen.backToLive.isDisplayed()) {
				// code when pause functionality is working
			}
		}

		catch (NoSuchElementException e) {

			// Back to live button is not displayed on webpage
			reports.log(LogStatus.PASS, "Click on Pause button");
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 3000);
			reports.attachScreenshot(captureCurrentScreenshot());

			driver.switchTo().frame(getCurrentFrameIndex());
			String currentImgSource = dtvChannelScreen.pauseAndPlayImg.getAttribute("src");
			String[] currentImgToArr = currentImgSource.split("/");
			String imageName = currentImgToArr[(currentImgToArr.length) - 1];
			if (imageName.equalsIgnoreCase(
					TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
				reports.log(LogStatus.PASS, "Pause Sucessfully");
				reports.attachScreenshot(captureCurrentScreenshot());
			}

			else {
				FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
			}

			reports.log(LogStatus.PASS, "Play and Navigate to action list");
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 2000);
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());

			isDisplayed(dtvChannelScreen.backToLive, "Back to live TV");

		}

	}

	@Test
	public void pause_LiveTV_PLTV_cancelPopupMessage() throws InterruptedException {

		/**
		 * Pop Up functionality not implemented yet so we verify this scenario
		 * through channel number
		 * 
		 */
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();

		reports.log(LogStatus.PASS, "Press pause button");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Waiting for two minute for making buffer");
		// wait for 2 minute for making buffer
		Thread.sleep(120000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Press play button");
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 0);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());

		// channel change
		reports.log(LogStatus.PASS, "Navigate to another channel");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 0);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		if (dtvChannelScreen.chnlNoIn_Infobar.isDisplayed()) {
			FailTestCase("Pop is not showing");
		}

		else {

			reports.log(LogStatus.PASS, "pop up is visible on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

	}

	@Test
	public void Pause_LiveTV_trickplay() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();

		reports.log(LogStatus.PASS, "Tune a channel");
		sendKeyMultipleTimes("NUMPAD2", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		// Wait for 5 minute for buffering the Live program
		Thread.sleep(30000);
		dtvChannelScreen.pressRewindButtonAndValidation();
		dtvChannelScreen.pressPlayButtonAndValidation();
	}

	@Test
	public void pause_LiveTV_PLTV_ExceedingBuffer() throws InterruptedException, ParseException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();

		dtvChannelScreen.pressPauseButtonAndValidation();

		Thread.sleep(3660000);

		// validate play video automatically
		String currentImgSource = dtvChannelScreen.pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PauseButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Play successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Pause button is not highlight on webpage");
		}

	}

	/**
	 * 
	 * First Locked the PLTV package then Execute
	 * 
	 * @throws InterruptedException
	 */

	@Test
	public void tc_Pause_LiveTV_PLTV_package_not_assigned() throws InterruptedException {

		DTVChannelScreen dtvScreen = new DTVChannelScreen(driver);
		dtvScreen.openLiveTV();

		reports.log(LogStatus.PASS, "Press pause button");
		dtvScreen.errorMsgValidation(Unicode.VK_PAUSE.toString(),
				TestInitization.getExcelKeyValue("ErrorMessages", "PLTV_Lock_Error_Message", "Value"));
		dtvScreen.errorMsgValidation(Unicode.VK_BACKWARD.toString(),
				TestInitization.getExcelKeyValue("ErrorMessages", "PLTV_Lock_Error_Message", "Value"));

	}

	@Test
	public void tc_BCVODVD0130_VOD_FOD() throws InterruptedException {

		DTVChannelScreen dtvScreen = new DTVChannelScreen(driver);
		RentMovie rentMovie = new RentMovie(driver);
		dtvScreen.navigateToFilmScreenAndRentMovie(TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			reports.log(LogStatus.FAIL, rentMovie.rentOption.getText() + "is visible on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		} catch (NoSuchElementException e) {

			reports.log(LogStatus.PASS, " Rent Option is not visible on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		sendKeyMultipleTimes("DOWN", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		dtvScreen.pressPauseButtonAndValidation();
		// navigate to menu page
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 2000);
	}

}
