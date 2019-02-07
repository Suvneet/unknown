package com.rsystems.test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.PIPScreen;
import com.rsystems.utils.TestInitization;
public class PIPTestCases extends TestInitization {

	
	
	PIPScreen pipScreen = null;
	/**
	 * This test cases is used to verify the pip setting screen elements to links
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_pip_001_pip_setting_ui() throws InterruptedException{
		pipScreen = new PIPScreen(driver);
		pipScreen.goToPIPSettingScreen();
		reports.log(LogStatus.PASS, "Verify PIP Setting Screen");
		reports.log(LogStatus.PASS, "Verify PIP position options available");
		String[] options = {"standaard","links"};
		pipScreen.verifyAvailablePIPPostion(options);
		//Verify Heading Text
		pipScreen.verifyPIPSettingScreenHeadingText();
		//verify Confirm BUttom
		pipScreen.confirmBtnExist();
		//verify Cancel BUttom
		pipScreen.cancelBtnExist();
	}
	
	/**
	 * This test cases is used to verify the pip setting changed to links
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_BCPIPHPG01_pip_confirmation_setting_links() throws InterruptedException{
		pipScreen = new PIPScreen(driver);
		pipScreen.changePIPSetting(TestInitization.getExcelKeyValue("PIPScreen","PIPLink", "name_nl"));
		if (pipScreen.verifyPIPSettingChanged(TestInitization.getExcelKeyValue("PIPScreen","PIPLink", "pip_position"))){
			reports.log(LogStatus.PASS , "Expected Pip Postion - " + TestInitization.getExcelKeyValue("PIPScreen","PIPLink", "pip_position") + "  Actual Pip Position - Top Right Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL , "Expected Pip Postion - " + TestInitization.getExcelKeyValue("PIPScreen","PIPLink", "pip_position") + "  Actual Pip Position - Top Left Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		// Change PIP Setting to default
		reports.log(LogStatus.PASS,"Change PIP Setting to Default" + TestInitization.getExcelKeyValue("PIPScreen", "Default", "name_nl"));
		pipScreen.changePIPSetting(TestInitization.getExcelKeyValue("PIPScreen", "Default", "name_nl"));
	}
	/**
	 * This test cases is used to verify the pip setting changed to standaard
	 * Created By Rahul Dhoundiyal
	 * @throws AWTException 
	 */
	@Test
	public void tc_pip_003_pip_setting_default() throws InterruptedException{
		pipScreen = new PIPScreen(driver);
		pipScreen.changePIPSetting(TestInitization.getExcelKeyValue("PIPScreen", "Default", "name_nl"));
		if (pipScreen.verifyPIPSettingChanged(TestInitization.getExcelKeyValue("PIPScreen","Default", "pip_position"))){
			reports.log(LogStatus.FAIL , "Expected Pip Postion - " + TestInitization.getExcelKeyValue("PIPScreen","Default", "pip_position") + "  Actual Pip Position - Top Right Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.PASS , "Expected Pip Postion - " + TestInitization.getExcelKeyValue("PIPScreen","Default", "pip_position") + "  Actual Pip Position - Top Left Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		// Change PIP Setting to default
		reports.log(LogStatus.PASS,"Change PIP Setting to Default" + TestInitization.getExcelKeyValue("PIPScreen", "Default", "name_nl"));
		pipScreen.changePIPSetting(TestInitization.getExcelKeyValue("PIPScreen", "Default", "name_nl"));
	}
	/**
	 * This test cases is used to verify the pip setting changed to links and Verify changed on all screen
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_BCPIPHPG04_pip_position_links_all_screen() throws InterruptedException{
		pipScreen = new PIPScreen(driver);
		pipScreen.changePIPSetting(TestInitization.getExcelKeyValue("PIPScreen","PIPLink", "name_nl"));
		System.out.println(TestInitization.getExcelKeyValue("PIPScreen","PIPLink", "pip_position"));
		if (pipScreen.verifyPIPSettingOnAllScreen(TestInitization.getExcelKeyValue("PIPScreen","PIPLink", "pip_position"))){
			reports.log(LogStatus.PASS, "Pip position is on right ride of every screen");
		}
		else
		{
			reports.log(LogStatus.FAIL, "Pip position is not on right ride of every screen");
		}
		// Change PIP Setting to default
		reports.log(LogStatus.PASS,"Change PIP Setting to Default" + TestInitization.getExcelKeyValue("PIPScreen", "Default", "name_nl"));
		pipScreen.changePIPSetting(TestInitization.getExcelKeyValue("PIPScreen", "Default", "name_nl"));
		
	}
	/**
	 * This test cases is used to verify the pip setting changed to links and verify on Menu Screen,Zapping Screen and Mini EPG Screen
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_BCPIPHPG05_pip_position_links_Menu_Zap_MiniEPG_Screen() throws InterruptedException
	{
		pipScreen = new PIPScreen(driver);
		pipScreen.changePIPSetting(TestInitization.getExcelKeyValue("PIPScreen","PIPLink", "name_nl"));
		if (pipScreen.verifyPIPSettingsOnMenu_Zap_MiniEPG_Screen(TestInitization.getExcelKeyValue("PIPScreen","PIPLink", "pip_position")))
		{
			reports.log(LogStatus.PASS, "Pip position is on right ride of every screen");
		}
		else
		{
			reports.log(LogStatus.FAIL, "Pip position is not on right ride of every screen");
		}
		// Change PIP Setting to default
		reports.log(LogStatus.PASS,"Change PIP Setting to Default" + TestInitization.getExcelKeyValue("PIPScreen", "Default", "name_nl"));
		pipScreen.changePIPSetting(TestInitization.getExcelKeyValue("PIPScreen", "Default", "name_nl"));
	}
}