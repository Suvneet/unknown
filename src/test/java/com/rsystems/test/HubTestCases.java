package com.rsystems.test;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.Hub;
import com.rsystems.utils.TestInitization;

public class HubTestCases extends TestInitization{

	Hub hubScreen = null;
	
	/**
	 * This test case is used to verify Menu Screen is launching or not using hot key
	 * Created by Rahul Dhoundiyal
	 */
	@Test
	public void tc_Hub_Menu_Button() throws InterruptedException{
		hubScreen = new Hub(driver);
		hubScreen.launchAndVerifyMenuScreen();	
	}
	
	/**
	 * This test case is used to verify Navigation in text line in Hub Screen
	 * Created by Rahul Dhoundiyal
	 */
	@Test
	public void tc_HUB_Navigation_Text_Line() throws InterruptedException{
		hubScreen = new Hub(driver);
		if (hubScreen.focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl")))
		{
			reports.log(LogStatus.PASS, "Expected Output - Focus should be on " +getExcelKeyValue("screenTitles", "LiveTV", "name_nl") + ". Actual Output - Focus is on " + hubScreen.focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Initial Focus is not on " +getExcelKeyValue("screenTitles", "LiveTV", "name_nl") + " Actual Focus is on " +hubScreen.focusHubElement.getText());
		}	
		hubScreen.verifyHubTextLineNavigation();	
	}
	/**
	 * This test case is used to verify Navigation in Asset line in Hub Screen
	 * Created by Rahul Dhoundiyal
	 */
	@Test
	public void tc_hub_navigation_asset_line() throws InterruptedException{
		hubScreen = new Hub(driver);
		sendKeyMultipleTimes("UP", 1, 1000);
		if (hubScreen.focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl")))
		{
			reports.log(LogStatus.PASS, "Expected Output - Focus should be on " +getExcelKeyValue("screenTitles", "LiveTV", "name_nl") + ". Actual Output - Focus is on " + hubScreen.focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Initial Focus is not on " +getExcelKeyValue("screenTitles", "LiveTV", "name_nl") + " Actual Focus is on " +hubScreen.focusHubElement.getText());
		}	
		hubScreen.verifyHubAssetLineNavigation();
	}
	/**
	 * This test case is used to verify existence and opacity of two lines in Hub Screen
	 * Created by Rahul Dhoundiyal
	 */
	@Test
	public void tc_sf001_hub() throws InterruptedException
	{
		hubScreen = new Hub(driver);
		setApplicationHubPage(1);	
		hubScreen.verifyLinesinHub();
		hubScreen.verifyOpactiyOfLines();
	}
	/**
	 * This test case is used to verify asset line in Hub Screen
	 * Created by Rahul Dhoundiyal
	 */
	@Test
	public void tc_hub_asset_line_in_hub() throws InterruptedException{
		hubScreen = new Hub(driver);
		sendKeyMultipleTimes("UP", 1, 1000);
		hubScreen.verifyAssetLine();
	}
	
	/**
	 * This test cases is used to check hub menu getting displayed when no package is assigned
	 * Created by Rahul Dhoundiyal
	 * 
	 */
	@Test
	public void tc_Hub_menu_button_no_package() throws InterruptedException{
		hubScreen = new Hub(driver);
		reports.log(LogStatus.PASS, "Test When No Package Is assigned");
		hubScreen.launchAndVerifyMenuScreen();
	}

}
