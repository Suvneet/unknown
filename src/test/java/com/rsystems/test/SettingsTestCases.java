package com.rsystems.test;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.utils.TestInitization;

public class SettingsTestCases extends TestInitization {

	@Test(priority=1)
	public void epgSettingScreenTitleMatch() throws InterruptedException, AWTException {

		String expectedTitle = TestInitization.getExcelKeyValue("screenTitles", "epgSetting", "name_nl");
		String actualTitle = null;

			reports.log(LogStatus.INFO, "Step 2: Navigate to the Settings Screen");
			TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000, TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));

			reports.log(LogStatus.INFO, "Step 3: Navigate to the System Screen");
			TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000, TestInitization.getExcelKeyValue("screenTitles", "System", "name_nl"));

			reports.log(LogStatus.INFO, "Step 4: Navigate to the epg setting Screen");
			TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000, TestInitization.getExcelKeyValue("screenTitles", "epgSetting", "name_nl"));

			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());

			actualTitle = driver.findElement(By.xpath("//div[@class='epgHeading']")).getText();

			
			if (actualTitle.equalsIgnoreCase(expectedTitle)) {
				reports.log(LogStatus.PASS, "epgSettingScreenTitleMatch() Actual Title : "+ actualTitle + " and Expected Title : " + expectedTitle +" Test case successfully Passed");
			}

			else {
				reports.log(LogStatus.FAIL, "epgSettingScreenTitleMatch() Actual Title : "+ actualTitle + " and Expected Title : " + expectedTitle +" Test case Failed");
			}
			
	
		
	}
}
