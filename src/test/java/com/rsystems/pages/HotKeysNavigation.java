package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class HotKeysNavigation extends TestInitization
{

	static WebDriver driver;
    public HotKeysNavigation(WebDriver driver) 
    {
	this.driver = driver;
	PageFactory.initElements(driver,this);
    }
    
    @FindBy(how = How.ID, using = ObjectRepository.DtvChannel.chnlNoIn_Infobar)
    public WebElement chnlNoIn_Infobar;
    
    @FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.programDurationIn_Infobar)
    public WebElement programDurationIn_Infobar;
    
    @FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.programTitle)
    public WebElement programTitle;
    
    @FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.channelLogo)
    public WebElement channelLogo;
    
    @FindBy(how = How.ID, using = ObjectRepository.DtvChannel.hdIcon)
    public WebElement hdIcon;
    
    
	public void navigateToDTvFromShopScreen() throws InterruptedException
	{
		reports.log(LogStatus.PASS, "Navigate to the Shop Screen");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
	}

	
	public void navigateToDtvScreenFromEpgScreen() throws InterruptedException
	{
		EpgScreen epg = new EpgScreen(driver);
		epg.goToEpgChannelScreen(true);
	}
	
	
	public boolean navigateToRadioScreen() throws InterruptedException
	{
		reports.log(LogStatus.PASS, "Returning to the Hub Screen");
		TestInitization.setApplicationHubPage(2);
		reports.log(LogStatus.PASS, "Navigate to the Radio Screen");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_RADIO.toString(), 1,0);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_RADIO.toString(), 1,0);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1,0);
		reports.attachScreenshot(captureCurrentScreenshot());
		return true;
	}
	
	
	public boolean navigateToRadioScreenToDTvScreen() throws InterruptedException
	{
		navigateToRadioScreen();
		return true;
	}
}
