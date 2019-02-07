package com.rsystems.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;


public class PIPScreen extends TestInitization {

	
	WebDriver driver;
	public PIPScreen(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID,using = ObjectRepository.PIPElements.pipPositonIDElement)
	public WebElement pipPositionSetting;
	
	@FindAll({@FindBy(className = "cItem")})
	public List<WebElement> itmes;
	
	@FindBy(how = How.CLASS_NAME,using = ObjectRepository.PIPElements.pipHeadingElement)
	public WebElement pipHeading;
	
	@FindBy(how = How.XPATH,using = ObjectRepository.PIPElements.confirmElement)
	public WebElement confirm;
	
	@FindBy(how = How.XPATH,using = ObjectRepository.PIPElements.cancelElement)
	public WebElement cancel;
	/**
	 * This function is used to get PIP position element on Screen
	 * Created By Rahul Dhoundiyal
	 */
	public WebElement getPIPPostionOnScreen()
	{
		driver.switchTo().defaultContent();
		WebElement currentElement;
		try {
			currentElement = driver.findElement(By.xpath(ObjectRepository.PIPElements.currentPIPClassElement));
		}
		catch(org.openqa.selenium.NoSuchElementException ex)
		{
			currentElement = null;
		}
		return currentElement;
	}
	
	/**
	 *  This function is used to navigate to PIP Section under Setting Screen
	 *  Created By Rahul Dhoundiyal
	 */
	public void goToPIPSettingScreen() throws InterruptedException {
		TestInitization.setApplicationHubPage(2);
		reports.log(LogStatus.PASS, "Navigate to the Setting Screen");
		TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));

		reports.log(LogStatus.PASS, "Step : Navigate to the System Screen");
		TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "System", "name_nl"));

		reports.log(LogStatus.PASS, "Step : Navigate to the PIP Setting Screen");
		TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,DOWN,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "pipSetting", "name_nl"));
	}

	/**
	 *  This function is used to change the PIP Settings
	 *  Created By Rahul Dhoundiyal
	 */
	public void changePIPSetting(String pipPosition) throws InterruptedException{
		goToPIPSettingScreen();
		reports.log(LogStatus.PASS, "Change PIP Setting to - "+pipPosition);
		if (!pipPositionSetting.getText().equals(pipPosition))
		{	
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
		}
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS, "PIP Setting Changed to - "+pipPosition);
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	}
	/**
	 *  This function is used to verify the PIP Settings set successfully or not
	 *  Created By Rahul Dhoundiyal
	 */
	public boolean verifyPIPSettingChanged(String pipPositon) throws InterruptedException
	{
		boolean validateLinksPIP = false;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		if (getPIPPostionOnScreen()!=null)
		{
			WebElement logoOnRightSide = getPIPPostionOnScreen().findElement(By.className("logo"));
			WebElement dateElementOnRightSide = getPIPPostionOnScreen().findElement(By.id("dateTimeHeader"));
			if (getPIPPostionOnScreen().isDisplayed() && logoOnRightSide.isDisplayed() && dateElementOnRightSide.isDisplayed() && pipPositon.equals("Right")){
					validateLinksPIP = true;
			}
		}
		return validateLinksPIP;
	}

	public void verifyPIPSettingScreenHeadingText() throws InterruptedException {
		if (pipHeading.getText().equals(TestInitization.getExcelKeyValue("screenTitles", "pipSetting", "name_nl")))
		{
			reports.log(LogStatus.PASS, "Expected Heading - " + TestInitization.getExcelKeyValue("screenTitles", "pipSetting", "name_nl") + " Actual heading - " +pipHeading.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL, "Expected Heading - " + TestInitization.getExcelKeyValue("screenTitles", "pipSetting", "name_nl") + " Actual heading - " +pipHeading.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}

	public void confirmBtnExist() throws InterruptedException {

		try {
			if (confirm.isDisplayed()) {
				reports.log(LogStatus.PASS, "Confirm button is visible on webpage");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {
				FailTestCase("Confirm button is not visible on webpage");
			}

		} catch (NoSuchElementException e) {
			FailTestCase("Confirm button is not visible on webpage");
		}
	}

	public void cancelBtnExist() throws InterruptedException {

		try {
			if (cancel.isDisplayed()) {
				reports.log(LogStatus.PASS, "Cancle button is visible on webpage");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {
				FailTestCase("Cancle button is not visible on webpage");
			}

		} catch (NoSuchElementException e) {
			FailTestCase("Cancle button is not visible on webpage");
		}
	}

	public void verifyAvailablePIPPostion(String[] options) throws InterruptedException {
		int maxcount = options.length+1;
		boolean foundElement = false;
		for (String option : options)
		{
			while(maxcount>=1)
			{
				if(option.equalsIgnoreCase(pipPositionSetting.getText())){
					reports.log(LogStatus.PASS, option + " is visible on webpage");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					foundElement = true;
					break;
				}
				else
				{
					TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
					maxcount--;
				}
			}
			if (!foundElement)
			{
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				throw new SkipException("Option is not available in PIP Position Expected Option: " + option);
			}
		}

	}

	public boolean verifyPIPSettingOnAllScreen(String pipPosition) throws InterruptedException {
		return (verifyPIPPostionOnHubScreen(pipPosition) && verifyPIPPositionOnLibraryScreen(pipPosition) && verifyPIPPositionOnEPGScreen(pipPosition) && verifyPIPPositionOnSettingScreen(pipPosition) && verifyPIPPositionOnShopScreen(pipPosition));
	}

	private boolean verifyPIPPositionOnShopScreen(String pipPosition) throws InterruptedException {
		//Navigate to Shop Screen
		reports.log(LogStatus.PASS, "Navigate to Shop Screen");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		TestInitization.setApplicationHubPage(2);
		TestInitization.sendKeyMultipleTimes("RIGHT", 1	, 500);
		TestInitization.sendKeyMultipleTimes("ENTER", 1	, 500);
		if(verifyPIPSettingChanged(pipPosition))
		{
			reports.log(LogStatus.PASS, "Expected Pip Postion -" +pipPosition + "  Actual Pip Position - Top Right Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL, "Expected Pip Postion -" +pipPosition + "  Actual Pip Position - Top Left Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		return verifyPIPSettingChanged(pipPosition);
	}

	private boolean verifyPIPPositionOnSettingScreen(String pipPosition) throws InterruptedException {
		//Navigate to Setting Screen
		reports.log(LogStatus.PASS, "Navigate to Setting Screen");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		TestInitization.setApplicationHubPage(2);
		TestInitization.sendKeyMultipleTimes("RIGHT", 3	, 500);
		TestInitization.sendKeyMultipleTimes("ENTER", 1	, 500);
		if(verifyPIPSettingChanged(pipPosition))
		{
			reports.log(LogStatus.PASS, "Expected Pip Postion - " +pipPosition + "  Actual Pip Position - Top Right Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL, "Expected Pip Postion - " +pipPosition + "  Actual Pip Position - Top Left Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		return verifyPIPSettingChanged(pipPosition);
		
	}

	private boolean verifyPIPPositionOnEPGScreen(String pipPosition) throws InterruptedException {
		
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgChannelScreen(true);
		if(verifyPIPSettingChanged(pipPosition))
		{
			reports.log(LogStatus.PASS, "Expected Pip Postion - " +pipPosition + "  Actual Pip Position - Top Right Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL, "Expected Pip Postion - " +pipPosition + "  Actual Pip Position - Top Left Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		return verifyPIPSettingChanged(pipPosition);
		
	}

	private boolean verifyPIPPositionOnLibraryScreen(String pipPosition) throws InterruptedException {
		//Navigate to Library Screen
		reports.log(LogStatus.PASS, "Navigate to Library Screen");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		TestInitization.setApplicationHubPage(2);
		TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		if(verifyPIPSettingChanged(pipPosition))
		{
			reports.log(LogStatus.PASS, "Expected Pip Postion - " +pipPosition + "  Actual Pip Position - Top Right Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL, "Expected Pip Postion - " +pipPosition + "  Actual Pip Position - Top Left Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		return verifyPIPSettingChanged(pipPosition); 
	}

	private boolean verifyPIPPostionOnHubScreen(String pipPosition) throws InterruptedException {
		TestInitization.setApplicationHubPage(2);
		Thread.sleep(10);
		if(verifyPIPSettingChanged(pipPosition))
		{
			reports.log(LogStatus.PASS, "Expected Pip Postion - " + pipPosition + "  Actual Pip Position - Top Right Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL, "Expected Pip Postion - " +pipPosition + "  Actual Pip Position - Top Left Corner");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		return verifyPIPSettingChanged(pipPosition); 
	}

	public boolean verifyPIPSettingsOnMenu_Zap_MiniEPG_Screen(String pipPosition) throws InterruptedException{
		return(verifyPIPSettingOnMenuScreen(pipPosition) && verifyPIPSettingOnZapScreen(pipPosition) && verifyPIPPositionOnMiniEPGScreen(pipPosition) );
	}

	private boolean verifyPIPPositionOnMiniEPGScreen(String pipPosition) throws InterruptedException {
		TestInitization.setApplicationHubPage(2);
		reports.log(LogStatus.PASS,"Navigate to MINI EPG Screen");
		TestInitization.sendKeyMultipleTimes("UP", 1, 500);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 500);
		TestInitization.sendKeyMultipleTimes("RIGHT", 2, 1000);
		reports.log(LogStatus.PASS, "MINI EPG Screen getting displayed");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if (verifyPIPSettingChanged(pipPosition)){
			reports.log(LogStatus.PASS, "PIP is displayed on " + pipPosition + " top corner of screen" );
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return true;
		}
		else
		{
			reports.log(LogStatus.FAIL, "PIP is not displayed on " + pipPosition + " top corner of screen" );
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return false;
		}
	}

	private boolean verifyPIPSettingOnZapScreen(String pipPosition) throws InterruptedException {
		TestInitization.setApplicationHubPage(2);
		reports.log(LogStatus.PASS,"Navigate to Zapping Screen");
		TestInitization.sendKeyMultipleTimes("UP", 1, 500);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 500);
		TestInitization.sendKeyMultipleTimes("DOWN", 2, 1000);
		reports.log(LogStatus.PASS, "Zapping Screen getting displayed");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if (verifyPIPSettingChanged(pipPosition)){
			
			reports.log(LogStatus.PASS, "PIP is displayed on " + pipPosition + " top corner of screen" );
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return true;
		}
		else
		{
			reports.log(LogStatus.FAIL, "PIP is not displayed on " + pipPosition + " top corner of screen" );
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return false;
		}
	}
	private boolean verifyPIPSettingOnMenuScreen(String pipPosition) throws InterruptedException{
		// TODO Auto-generated method stub
		//Navigate to Menu Screen
		reports.log(LogStatus.PASS, "Navigate to Menu Screen");
		TestInitization.setApplicationHubPage(1);
		reports.log(LogStatus.PASS, "Menu Screen getting displayed");
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		if (verifyPIPSettingChanged(pipPosition))
		{
			reports.log(LogStatus.PASS, "PIP is displayed on " + pipPosition + " top corner of screen" );
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return true;
		}
		else
		{
			reports.log(LogStatus.FAIL, "PIP is not displayed on " + pipPosition + " top corner of screen" );
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return false;
		}
	}
}