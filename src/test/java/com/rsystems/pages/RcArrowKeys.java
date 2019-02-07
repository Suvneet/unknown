package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;


public class RcArrowKeys extends TestInitization
{
	WebDriver driver;

    public RcArrowKeys(WebDriver driver) 
    {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }
	
    @FindBy(how = How.CLASS_NAME, using = ObjectRepository.RcArrowKey.heading)
	public WebElement heading;
    @FindBy(how = How.CLASS_NAME, using = ObjectRepository.RcArrowKey.type)
  	public WebElement type;
    @FindBy(how = How.ID, using = ObjectRepository.RcArrowKey.epgInfo)
  	public WebElement epgInfo;
    @FindBy(how = How.ID, using = ObjectRepository.RcArrowKey.background)
  	public WebElement background;
    @FindBy(how = How.ID, using = ObjectRepository.RcArrowKey.Id)
	public WebElement Id;
    @FindBy(how = How.ID, using = ObjectRepository.StoreFilterLayer.screenID)
	public WebElement screenID;
    
    public boolean verifyNavigationToEpgScreen() throws InterruptedException
    { 
    	
    	EpgScreen epg = new EpgScreen(driver);
    	
    	reports.log(LogStatus.PASS, "Navigation to Epg Screen");
    	epg.goToEpgSettingScreen();
    	String screenTitle=heading.getText();
    	System.out.println("Title is :"+screenTitle);
    	String Type=type.getText();
    	System.out.println("Type is :"+Type);
    	
    	//Navigating to various epg layers
    	reports.log(LogStatus.PASS, "Navigation to the Epg type");
    	String egyTypeStandard=epgInfo.getText();
    	TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
    	reports.attachScreenshot(captureCurrentScreenshot());
    	System.out.println("Epg Type "+egyTypeStandard);
    	
    	TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
    	reports.attachScreenshot(captureCurrentScreenshot());
    	String egyTypeSenior=epgInfo.getText();
    	
    	System.out.println("Epg Type "+egyTypeSenior);
    	TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
    	reports.attachScreenshot(captureCurrentScreenshot());
    	
    	String egyTypeStark=epgInfo.getText();
    	System.out.println("Epg Type "+egyTypeStark);
    	
    	//Forward Navigation in the Epg screen
    	reports.log(LogStatus.PASS, "Downward navigation in the Epg screen for 4 times");
    	reports.attachScreenshot(captureCurrentScreenshot());
    	for(int i=0;i<4;i++)
    	{
    	 TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
    	}
    	//Backward Navigation in the Epg screen
    	reports.log(LogStatus.PASS, "Upward navigation in the Epg screen for 4 times");
    	reports.attachScreenshot(captureCurrentScreenshot());
    	for(int i=0;i<4;i++)
    	{
    	  TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
    	}
    	
    	String expectedTitle=TestInitization.getExcelKeyValue("EpgScreen","Heading","name_nl");
    	if(screenTitle.equalsIgnoreCase(expectedTitle))
    	{
        reports.log(LogStatus.PASS, "HeadingName : "+ screenTitle + " and Expected Title : " + expectedTitle +" Test case successfully Passed");
		}
		else 
		{
		FailTestCase("Actual Title : "+ screenTitle + " and Expected Title : " + expectedTitle +" Test case Failed");	
    	}
       	return true;
    }
    
    public boolean verifyNavigationToVODScreen() throws InterruptedException
    {
    	TestInitization.setApplicationHubPage(2);
    	reports.log(LogStatus.PASS, "Navigate to the Shop Screen");
    	reports.attachScreenshot(captureCurrentScreenshot());
		TestInitization.sendKeyMultipleTimes("RIGHT",1,1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Navigate to the VOD Screen");
		TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
		TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		String actualFilmDetailScreenTitle=null;
		String expectedFilmDetailScreenTitle = TestInitization.getExcelKeyValue("screenTitles", "Films", "name_nl");
		System.out.println("Expected Film Title :: "+expectedFilmDetailScreenTitle);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		actualFilmDetailScreenTitle=screenID.getText();
		System.out.println("Actual Films Title####### "+actualFilmDetailScreenTitle);
		if (actualFilmDetailScreenTitle.equalsIgnoreCase(expectedFilmDetailScreenTitle)) 
		{
		reports.log(LogStatus.PASS, "Actual Film Details Title : "+ actualFilmDetailScreenTitle + " and Expected Title : " + expectedFilmDetailScreenTitle +" Test case successfully Passed");
		}
		else 
		{
		FailTestCase("Actual Film Details Title : "+ actualFilmDetailScreenTitle + " and Expected Title : " + expectedFilmDetailScreenTitle +" Test case Failed");
		}	
		
		//Forward Navigation in the VOD screen
		reports.log(LogStatus.PASS, "Upward Navigation of the VOD screen for 15 times");
		reports.attachScreenshot(captureCurrentScreenshot());
		for(int i=0;i<15;i++)
		{
		 TestInitization.sendKeyMultipleTimes("RIGHT",1,1000);	
		}
		//Backward Navigation in the VOD screen
		reports.log(LogStatus.PASS, "Downward Navigation of the VOD screen for 15 times");
		reports.attachScreenshot(captureCurrentScreenshot());
		for(int i=0;i<15;i++)
		{
		 TestInitization.sendKeyMultipleTimes("LEFT",1,1000);	
		}
    	return true;
    } 
}
