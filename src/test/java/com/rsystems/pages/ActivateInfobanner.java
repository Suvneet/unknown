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

public class ActivateInfobanner extends TestInitization
{
	
	WebDriver driver;
    public ActivateInfobanner(WebDriver driver) 
    {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }
    
    @FindBy(how = How.ID, using = ObjectRepository.ActiveInfoBanner.channelInfo)
  	public WebElement channelInfo;
    
    @FindBy(how = How.CLASS_NAME, using = ObjectRepository.ActiveInfoBanner.programID)
  	public WebElement programID;
   
    @FindBy(how = How.CLASS_NAME, using = ObjectRepository.ActiveInfoBanner.duration)
  	public WebElement duration;

    public void navigateToActivateInfoBannerScreen() throws InterruptedException
    {
    	reports.log(LogStatus.PASS, "Navigation to Activate Banner Screen");
    	TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
    	TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
    	reports.log(LogStatus.PASS, "Channel is getting displayed");
    	TestInitization.sendKeyMultipleTimes("PAGE_UP", 1, 1000);
    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
    	TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1,0);
    }
    
    
    //Verifying the Info banner is correct or not
    public boolean verifyActiveInfoBannerScreen() throws InterruptedException
    {
    	TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
    	driver.switchTo().frame(getCurrentFrameIndex());
    	String actaulChannelID=channelInfo.getText();
    	System.out.println("actaulChannelID :"+actaulChannelID);
    	String actaulProgramTitle=programID.getText();
    	System.out.println("actaulProgramTitle :"+actaulProgramTitle);
    	String actualProgramDuration=duration.getText();
    	System.out.println("programDuration :"+actualProgramDuration);
    	
    	reports.log(LogStatus.PASS, "Channel is getting changed");
    	TestInitization.sendKeyMultipleTimes("HOME", 1, 1000);
    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
    	TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1,0);
    	
    	
    	driver.switchTo().frame(getCurrentFrameIndex());
    	String actaulChannelnoID=channelInfo.getText();
    	System.out.println("actaulChannelID :"+actaulChannelnoID);
    	String actaulProgramTitleChannelOne=programID.getText();
    	System.out.println("actaulProgramTitle :"+actaulProgramTitleChannelOne);
    	String actualProgramDurationChannelOne=duration.getText();
    	System.out.println("programDuration :"+actualProgramDurationChannelOne);
    	
    	if(actaulChannelID.equalsIgnoreCase(actaulChannelnoID)&&actaulProgramTitle.equalsIgnoreCase(actaulProgramTitleChannelOne)
    			&&actualProgramDuration.equalsIgnoreCase(actualProgramDurationChannelOne))
    	{
    		FailTestCase(" Test case Failed as both the channels is having same program running");
    	}
    	else
    	{
    		reports.log(LogStatus.PASS, "Test case passed as both the channel is showing different program");
    	}
    	
    	return true;
    } 
}
