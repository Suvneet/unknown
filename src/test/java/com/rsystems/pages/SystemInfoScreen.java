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

public class SystemInfoScreen extends TestInitization
{
	
	WebDriver driver;

    public SystemInfoScreen(WebDriver driver) 
    {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }
    
	@FindBy(how = How.XPATH, using = ObjectRepository.VerifySystemInfoScreen.systemInfoXpath)
	public WebElement systemInfoXpath;

	@FindBy(how = How.ID, using = ObjectRepository.VerifySystemInfoScreen.softwareVersion)
	public WebElement softwareVersion;

	@FindBy(how = How.ID, using = ObjectRepository.VerifySystemInfoScreen.hardwareVersion)
	public WebElement hardwareVersion;
	
	@FindBy(how = How.ID, using = ObjectRepository.VerifySystemInfoScreen.serialNumber)
	public WebElement serialNumber;
	
	@FindBy(how = How.ID, using = ObjectRepository.VerifySystemInfoScreen.hpgVersion)
	public WebElement hpgVersion;

public void goTosytemInfoScreen() throws InterruptedException 
{
	reports.log(LogStatus.PASS, "Navigate to the Settings Screen");
	TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));
	
	reports.log(LogStatus.PASS, "Navigate to the System Screen");
	TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "System", "name_nl"));
	
	
	reports.log(LogStatus.PASS, "Navigate to the Systeminfo Screen");
	TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,DOWN,DOWN,DOWN,DOWN,DOWN,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "SystemInfo", "name_nl"));
	
} 

public  boolean validationSystemInfoScreen() throws InterruptedException 
{
        goTosytemInfoScreen();
        
	    String actualScreenTitle = null;
	    String ActualhardwareVersion=null;
	    String ActualSoftwareVersion=null;
	    String ActualHpgVersion=null;
	    String ActualserialNumber=null;
	    
	    
	    
	    String expectedScreenTitle = TestInitization.getExcelKeyValue("screenTitles", "SystemInfo", "name_nl");
	    String expectedHardwareVersion = TestInitization.getExcelKeyValue("SystemInfoScreen", "Hardwareversion", "name_nl");
	    String expectedSoftwareVersion = TestInitization.getExcelKeyValue("SystemInfoScreen", "Softwareversion", "name_nl");
	    String expectedHpgVersion = TestInitization.getExcelKeyValue("SystemInfoScreen", "HPGVersion", "name_nl");
	    String expectedSerialNumber = TestInitization.getExcelKeyValue("SystemInfoScreen", "SerialNumber", "name_nl");
	    
	    
	    
	    actualScreenTitle = systemInfoXpath.getText();
		if (actualScreenTitle.equalsIgnoreCase(expectedScreenTitle)) 
		{
		reports.log(LogStatus.PASS, "Actual Title : "+ actualScreenTitle + " and Expected Title : " + expectedScreenTitle +" Test case successfully Passed");
		}
		else 
		{
		reports.log(LogStatus.FAIL, "Actual Title : "+ actualScreenTitle + " and Expected Title : " + expectedScreenTitle +" Test case Failed");
		throw new SkipException("Actual Title : "+ actualScreenTitle + " and Expected Title : " + expectedScreenTitle +" Test case Failed");
		}	
		
		
		ActualhardwareVersion=hardwareVersion.getText();
		if(ActualhardwareVersion.equalsIgnoreCase(expectedHardwareVersion))
		{
		reports.log(LogStatus.PASS, "Actual Hardware Version : "+ ActualhardwareVersion + " and Expected Hardware Version : " + expectedHardwareVersion +" Test case successfully Passed");	
		}
		else 
		{
		reports.log(LogStatus.FAIL, "Actual  Hardware Version  : "+ ActualhardwareVersion + " and Expected  Hardware Version  : " + expectedHardwareVersion +" Test case Failed");
		throw new SkipException("Actual  Hardware Version : "+ ActualhardwareVersion + " and Expected  Hardware Version : " + expectedHardwareVersion +" Test case Failed");
		}	
		
		ActualSoftwareVersion=softwareVersion.getText();
		if(ActualSoftwareVersion.equalsIgnoreCase(expectedSoftwareVersion))
		{
		reports.log(LogStatus.PASS, "Actual Software Version : "+ ActualSoftwareVersion + " and Expected Software Version : " + expectedSoftwareVersion +" Test case successfully Passed");	
		}
		else 
		{
		
		reports.log(LogStatus.FAIL, "Actual Software Version : "+ ActualSoftwareVersion + " and Expected Software Version : " + expectedSoftwareVersion +" Test case Failed");
		throw new SkipException("Actual Software Version : "+ ActualSoftwareVersion + " and Expected Software Version : " + expectedSoftwareVersion +" Test case Failed");
		}	
		
		ActualHpgVersion=hpgVersion.getText();
		if(ActualHpgVersion.equalsIgnoreCase(expectedHpgVersion))
		{
		reports.log(LogStatus.PASS, "Actual HPG Version : "+ ActualHpgVersion + " and Expected HPG Version : " + expectedHpgVersion +" Test case successfully Passed");	
		}
		else 
		{
		reports.log(LogStatus.FAIL, "Actual HPG Version : "+ ActualHpgVersion + " and Expected HPG Version : " + expectedHpgVersion +" Test case Failed");
		throw new SkipException("Actual HPG Version : "+ ActualHpgVersion + " and Expected HPG Version : " + expectedHpgVersion +" Test case Failed");
		}	
		
		
		ActualserialNumber=serialNumber.getText();
		if(ActualserialNumber.equalsIgnoreCase(expectedSerialNumber))
		{
		reports.log(LogStatus.PASS, "Actual Serial Number : "+ ActualserialNumber + " and Expected Serial Number : " + expectedSerialNumber +" Test case successfully Passed");	
		}
		else 
		{
			
			
		reports.log(LogStatus.FAIL, "Actual Serial Number : "+ ActualserialNumber + " and Expected Serial Number : " + expectedSerialNumber +" Test case Failed");
		throw new SkipException("Actual Serial Number : "+ ActualserialNumber + " and Expected Serial Number : " + expectedSerialNumber +" Test case Failed");
		}	
		return true;		
}
public void navigateToSytemScreen() throws InterruptedException
{
	reports.log(LogStatus.PASS, "Navigate to the Settings Screen");
	TestInitization.sendKeyMultipleTimes("RIGHT",1,1000);
	TestInitization.sendKeyMultipleTimes("RIGHT",1,1000);
	TestInitization.sendKeyMultipleTimes("RIGHT",1,1000);
	TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
    reports.log(LogStatus.PASS, "Navigate to the System Screen");
	TestInitization.sendKeyMultipleTimes("DOWN",1,1000);
	TestInitization.sendKeyMultipleTimes("DOWN",1,1000);
	TestInitization.sendKeyMultipleTimes("DOWN",1,1000);
	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
}
}	
	

