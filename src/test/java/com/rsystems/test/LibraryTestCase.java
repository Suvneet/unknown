package com.rsystems.test;
import java.util.List;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.LibraryScreen;
import com.rsystems.pages.RecordingScreen;
import com.rsystems.utils.TestInitization;

import junit.framework.Assert;
public class LibraryTestCase extends TestInitization {

	/**
	 * This Test case verify the text for all the library Menu Items
	 * Created By Rahul Dhoundiyal
	 * 
	 */

	@Test(priority = 2)
	public void verifyLibraryItemsFontSize() throws InterruptedException{
		List<String> actualFontSizeList = LibraryScreen.getLibraryMenuItemFontSize();
		boolean validateText = LibraryScreen.VerifyMenuItemsTextOrFonts(actualFontSizeList,"font-size");
		if (validateText){
			Assert.assertEquals(validateText, true);
			reports.log(LogStatus.PASS, "Font for Menu Text is matched successfully");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			Assert.assertEquals(validateText, false);
			reports.log(LogStatus.FAIL, "Font for Menu Text not matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}
	/**
	 * 
	 * This test case is used to verify the text of Library Sub Menu Items
	 * Created By Rahul Dhoundiyal
	 * 
	 */
	@Test(priority = 3)
	public void verifyLibraryMenuSubListText() throws InterruptedException{
		List<String> subMenuTextList = LibraryScreen.getLibrarySubMenuListText();
		boolean validateText = LibraryScreen.verifyLibrarySubMenuTextOrFonts(subMenuTextList,"name_nl");
		if (validateText){
			Assert.assertEquals(validateText, true);
			reports.log(LogStatus.PASS, "Text for Sub Menu is matched successfully");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			Assert.assertEquals(validateText, false);
			reports.log(LogStatus.FAIL, "Text for Sub Menu not matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}
	/**
	 * 
	 * This test case is used to verify the font-size of Library Sub Menu Items
	 * Created By Rahul Dhoundiyal
	 * 
	 */
	@Test(priority = 4)
	public void verifyLibraryMenuSubListFontSize() throws InterruptedException{
		List<String> subMenuFontList = LibraryScreen.getLibrarySubMenuFontSize();
		boolean validateText = LibraryScreen.verifyLibrarySubMenuTextOrFonts(subMenuFontList,"font-size");
		if (validateText){
			Assert.assertEquals(validateText, true);
			reports.log(LogStatus.PASS, "Text for Sub Menu is matched successfully");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			Assert.assertEquals(validateText, false);
			reports.log(LogStatus.FAIL, "Text for Sub Menu not matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}
	
	/**
	 * This Test case verify the line movement while navigating through the Library Screen
	 * 
	 * 
	 */
	@Test
	public void verifyLibraryMenuItemsText() throws InterruptedException
	{
		RecordingScreen record = new RecordingScreen(driver);
    	record.verifyNavigationInPlannedRecording();
    	
    	reports.log(LogStatus.PASS, "Returning to the hub screen");
    	TestInitization.setApplicationHubPage(2);
    	
    
		List<String> actualMenuItemText = LibraryScreen.getLibraryMenuItemsText();
		System.out.println(actualMenuItemText);
		boolean validateText = LibraryScreen.VerifyMenuItemsTextOrFonts(actualMenuItemText,"name_nl");
		if (validateText){
			Assert.assertEquals(validateText, true);
			reports.log(LogStatus.PASS, "Menu Text is matched successfully");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			Assert.assertEquals(validateText, false);
			reports.log(LogStatus.FAIL, "Menu Text not matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		
		reports.log(LogStatus.PASS, "Returning to the hub screen");
		TestInitization.setApplicationHubPage(2);
		List<String> actualFontSizeList = LibraryScreen.getLibraryMenuItemFontSize();
		boolean validateTextOne = LibraryScreen.VerifyMenuItemsTextOrFonts(actualFontSizeList,"font-size");
		if (validateText){
			Assert.assertEquals(validateTextOne, true);
			reports.log(LogStatus.PASS, "Font for Menu Text is matched successfully");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			Assert.assertEquals(validateTextOne, false);
			reports.log(LogStatus.FAIL, "Font for Menu Text not matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		
		reports.log(LogStatus.PASS, "Returning to the hub screen");
		TestInitization.setApplicationHubPage(2);
		List<String> subMenuTextList = LibraryScreen.getLibrarySubMenuListText();
		boolean validateTexttwo = LibraryScreen.verifyLibrarySubMenuTextOrFonts(subMenuTextList,"name_nl");
		if (validateText){
			Assert.assertEquals(validateTexttwo, true);
			reports.log(LogStatus.PASS, "Text for Sub Menu is matched successfully");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			Assert.assertEquals(validateTexttwo, false);
			reports.log(LogStatus.FAIL, "Text for Sub Menu not matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		
		reports.log(LogStatus.PASS, "Returning to the hub screen");
		TestInitization.setApplicationHubPage(2);
		List<String> subMenuFontList = LibraryScreen.getLibrarySubMenuFontSize();
		boolean validateTextthree = LibraryScreen.verifyLibrarySubMenuTextOrFonts(subMenuFontList,"font-size");
		if (validateText){
			Assert.assertEquals(validateTextthree, true);
			reports.log(LogStatus.PASS, "Text for Sub Menu is matched successfully");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			Assert.assertEquals(validateTextthree, false);
			reports.log(LogStatus.FAIL, "Text for Sub Menu not matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		
	}
}