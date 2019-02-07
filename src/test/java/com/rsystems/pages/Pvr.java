package com.rsystems.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class Pvr extends TestInitization
{
	WebDriver driver;
	public Pvr(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = ObjectRepository.DtvChannel.pauseAndPlayImg)
	public WebElement pauseAndPlayImg;
	public void navigateToTheVODPlayback() throws InterruptedException
	{
		reports.log(LogStatus.PASS, "Navigate to Library Screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("mijn bibliotheek")){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if(driver.findElement(By.id("titleHeading")).getText().equalsIgnoreCase("opnames"))
		{
			reports.log(LogStatus.PASS, "Recording List getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Recording List not getting displayed");
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS, "PVR Playback video is playing");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = new DTVChannelScreen(driver).pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Playback Video is playing.Play button is now highlight on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
			sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		}

		else {
			FailTestCase("Play button is not highlight on webpage. Might be Video is not playing in this channel");
		}


		/*  sendKeyMultipleTimes("UP", 1, 1000);
	   sendKeyMultipleTimes("RIGHT", 1, 1000);
	   sendKeyMultipleTimes("ENTER", 1, 1000);
	   sendKeyMultipleTimes("DOWN", 1, 1000);
	   sendKeyMultipleTimes("ENTER", 1, 1000);
	   reports.attachScreenshot(captureCurrentScreenshot());
	   sendNumaricKeys(1);
	   sendNumaricKeys(1);
	   sendNumaricKeys(1);
	   sendNumaricKeys(1);*/

	}

	public void PvrPlayBackMenu() throws InterruptedException
	{
		navigateToTheVODPlayback();

		reports.log(LogStatus.PASS, "Forwarding the Video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);

		reports.attachScreenshot(captureCurrentScreenshot());


		reports.log(LogStatus.PASS, "Backward the Video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(),1,4000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassName = new DTVChannelScreen(driver).rewindBtn.getAttribute("class");
		System.out.println("class name " + currentClassName);
		if (currentClassName.contentEquals("enable")) {
			reports.log(LogStatus.PASS, "Live TV is rewind");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to rewind Live TV");
		}


		reports.log(LogStatus.PASS, "Playing the Video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		String currentImgSource = pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PauseButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "play Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Pause button is not highlight on webpage");
		}



		reports.log(LogStatus.PASS, "Pause the Video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource1 = pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr1 = currentImgSource1.split("/");
		String imageName1 = currentImgToArr1[(currentImgToArr1.length) - 1];

		System.out.println(imageName1);
		if (imageName1
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}


		reports.log(LogStatus.PASS, "Stop the Video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Returning to the Hub Menu");

	}	

	public void PvrRcTrickPlay() throws InterruptedException
	{
		navigateToTheVODPlayback();

		reports.log(LogStatus.PASS, "Forwarding the Video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());


		reports.log(LogStatus.PASS, "Returning to the Main Menu");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")){
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Rewinding the video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(),1,4000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassName = new DTVChannelScreen(driver).rewindBtn.getAttribute("class");
		System.out.println("class name " + currentClassName);
		if (currentClassName.contentEquals("enable")) {
			reports.log(LogStatus.PASS, "Live TV is rewind");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to rewind Live TV");
		}

		reports.log(LogStatus.PASS, "Pressing on the Ondemand Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")){
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Forwarding the Video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());


		reports.log(LogStatus.PASS, "Pressing on the PVR hot key");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("mijn bibliotheek")){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Forwarding the Video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());


		reports.log(LogStatus.PASS, "Rewinding the video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(),1,4000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassName1 = new DTVChannelScreen(driver).rewindBtn.getAttribute("class");
		System.out.println("class name " + currentClassName1);
		if (currentClassName1.contentEquals("enable")) {
			reports.log(LogStatus.PASS, "Live TV is rewind");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to rewind Live TV");
		}

		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Pressing on the Pause button");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Rewinding the video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 4000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		currentClassName1 = new DTVChannelScreen(driver).rewindBtn.getAttribute("class");
		System.out.println("class name " + currentClassName1);
		if (currentClassName1.contentEquals("enable")) {
			reports.log(LogStatus.PASS, "Live TV is rewind");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to rewind Live TV");
		}
		reports.log(LogStatus.PASS, "Pressing on the Pause button");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource1 = pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr1 = currentImgSource1.split("/");
		String imageName1 = currentImgToArr1[(currentImgToArr1.length) - 1];

		System.out.println(imageName1);
		if (imageName1
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}
		reports.log(LogStatus.PASS, "Pressing on the PVR button");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("mijn bibliotheek")){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Pressing on the Pause button");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		currentImgSource1 = pauseAndPlayImg.getAttribute("src");
		currentImgToArr1 = currentImgSource1.split("/");
		imageName1 = currentImgToArr1[(currentImgToArr1.length) - 1];

		System.out.println(imageName1);
		if (imageName1
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}

		reports.log(LogStatus.PASS, "Pressing on the Ondemand hot key button");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(),1,1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")){
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Pressing on the Pause button");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		currentImgSource1 = pauseAndPlayImg.getAttribute("src");
		currentImgToArr1 = currentImgSource1.split("/");
		imageName1 = currentImgToArr1[(currentImgToArr1.length) - 1];

		System.out.println(imageName1);
		if (imageName1
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}

		reports.log(LogStatus.PASS, "Pressing on the Menu button");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(),1,1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")){
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");

	}

	public void VODplayback() throws InterruptedException
	{

		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Forward the Video");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Pause the Video");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource1 = pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr1 = currentImgSource1.split("/");
		String imageName1 = currentImgToArr1[(currentImgToArr1.length) - 1];

		System.out.println(imageName1);
		if (imageName1
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}

		reports.log(LogStatus.PASS, "Play the Video");
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Stopping the Video");
		sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
	}

	public void VodRCKeysTrickplay() throws InterruptedException
	{
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Forward the Video");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1,0);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Press on the Menu key");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1,0);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")){
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Press on the Forward key");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Press on Demand Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")){
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Press on the back key");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(),1, 4000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassName1 = new DTVChannelScreen(driver).rewindBtn.getAttribute("class");
		System.out.println("class name " + currentClassName1);
		if (currentClassName1.contentEquals("enable")) {
			reports.log(LogStatus.PASS, "Live TV is rewind");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to rewind Live TV");
		}
		reports.log(LogStatus.PASS, "Press on PVR Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("mijn bibliotheek")){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Press on the Forward key");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());


		reports.log(LogStatus.PASS, "Pause the Video");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource1 = pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr1 = currentImgSource1.split("/");
		String imageName1 = currentImgToArr1[(currentImgToArr1.length) - 1];

		System.out.println(imageName1);
		if (imageName1
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}
		reports.log(LogStatus.PASS, "Press the Back key");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(),1, 4000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		currentClassName1 = new DTVChannelScreen(driver).rewindBtn.getAttribute("class");
		System.out.println("class name " + currentClassName1);
		if (currentClassName1.contentEquals("enable")) {
			reports.log(LogStatus.PASS, "Live TV is rewind");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to rewind Live TV");
		}
		reports.log(LogStatus.PASS, "Pause the Video");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		currentImgSource1 = pauseAndPlayImg.getAttribute("src");
		currentImgToArr1 = currentImgSource1.split("/");
		imageName1 = currentImgToArr1[(currentImgToArr1.length) - 1];

		System.out.println(imageName1);
		if (imageName1
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}
		reports.log(LogStatus.PASS, "Pressing the PVR key");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("mijn bibliotheek")){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Pause the Video");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		currentImgSource1 = pauseAndPlayImg.getAttribute("src");
		currentImgToArr1 = currentImgSource1.split("/");
		imageName1 = currentImgToArr1[(currentImgToArr1.length) - 1];

		System.out.println(imageName1);
		if (imageName1
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}
		reports.log(LogStatus.PASS, "Pressing the on demand hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")){
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		navigateToTheVODPlayback();
		reports.log(LogStatus.PASS, "Pause the Video");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		currentImgSource1 = pauseAndPlayImg.getAttribute("src");
		currentImgToArr1 = currentImgSource1.split("/");
		imageName1 = currentImgToArr1[(currentImgToArr1.length) - 1];

		System.out.println(imageName1);
		if (imageName1
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}
		reports.log(LogStatus.PASS, "Press Menu key hot key");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());	
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")){
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");

	}
}
