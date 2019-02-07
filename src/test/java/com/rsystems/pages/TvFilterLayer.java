package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

public class TvFilterLayer extends TestInitization
{
	 
	WebDriver driver;

    public TvFilterLayer(WebDriver driver) 
    {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }
    
	@FindBy(how = How.ID, using = ObjectRepository.TvfilterLayer.televiosntitle)
	public WebElement televiosntitle;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.TvfilterLayer.tvId)
	public WebElement tvId;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.TvfilterLayer.now)
	public WebElement now;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.TvfilterLayer.nowOnTv)
	public WebElement nowOnTv;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.TvfilterLayer.footballTv)
	public WebElement footballTv;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.TvfilterLayer.footballCalendar)
	public WebElement footballCalendar;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.TvfilterLayer.radioStations)
	public WebElement radioStations;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.TvfilterLayer.search)
	public WebElement search;
	
	public void navigationToTvScreen() throws InterruptedException
	{
		
	String tvTitle=televiosntitle.getText();
	System.out.println("Televion ::"+tvTitle);
	reports.log(LogStatus.PASS, "Navigate to the TV Filter Screen");
	TestInitization.sendKeySequence("ENTER", 1000, TestInitization.getExcelKeyValue("TvFilterLayer","Television","name_nl"));
	driver.switchTo().frame(getCurrentFrameIndex());
	String tvGrid=tvId.getText();
	System.out.println("Tv grid ::::"+tvGrid);
	String expectedtvGrid = TestInitization.getExcelKeyValue("TvFilterLayer","TvGrid","name_nl");
	System.out.println("expectedtvGrid :::"+expectedtvGrid);
	if(tvGrid.equalsIgnoreCase(expectedtvGrid))
	{
		reports.log(LogStatus.PASS, "Actual tvGrid Title :"+tvGrid+" and Expected tvGrid Title :"+expectedtvGrid+" Test case successfully Passed");
	}
	else
	{
		FailTestCase("Actual tvGrid Title :"+tvGrid+" and Expected tvGrid Title :"+expectedtvGrid+" Test case Failed");
		
	}
	}
	
	public boolean tvFilterLayerVerify() throws InterruptedException
	{
		
		navigationToTvScreen();
		String nuHeading=now.getText();
		System.out.println("nuHeading :::"+nuHeading);
		String expectednuHeading=TestInitization.getExcelKeyValue("TvFilterLayer","Now","name_nl");
		System.out.println("expected nuHeading::"+expectednuHeading);
		if (nuHeading.equalsIgnoreCase(expectednuHeading))
		{
			reports.log(LogStatus.PASS, "Actual heading Title :"+nuHeading+" and Expected heading Title :"+expectednuHeading+" Test case successfully Passed");
		}
		else
		{
			FailTestCase("Actual heading Title : "+nuHeading+" and Expected heading Title : "+expectednuHeading+" Test case Failed");
		}
		
		reports.log(LogStatus.PASS, "Navigate to the TV Now Screen");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		String actualNowOnTvHeading=nowOnTv.getText();
		System.out.println("actualNowOnTvHeading::"+actualNowOnTvHeading);
		String expectedNowOnTv=TestInitization.getExcelKeyValue("TvFilterLayer","Nowontv","name_nl");
		System.out.println("expectedNowOnTv::"+expectedNowOnTv);
		if (actualNowOnTvHeading.equalsIgnoreCase(expectedNowOnTv))
		{
			reports.log(LogStatus.PASS, "Actual NowOnTv Heading Title : "+actualNowOnTvHeading+" and Expected NowOnTv Title : "+expectedNowOnTv+" Test case successfully Passed");
		}
		else
		{
			FailTestCase("Actual NowOnTv Heading Title : "+actualNowOnTvHeading+" and Expected NowOnTv Title : "+expectedNowOnTv+" Test case Failed");
		}
		
		reports.log(LogStatus.PASS, "Navigate to the Football Screen");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		String actualFootballHeading=footballTv.getText();
		System.out.println("actualFootballHeading ::"+actualFootballHeading);
		String expectedFootballHeading=TestInitization.getExcelKeyValue("TvFilterLayer","FootballTV","name_nl");
		System.out.println("expectedSecondHeadingHeading ::"+expectedFootballHeading);
		if (actualFootballHeading.equalsIgnoreCase(expectedFootballHeading))
		{
			reports.log(LogStatus.PASS, "Actual FootballHeading Title : "+actualFootballHeading+ " and Expected FootballHeading Title : "+expectedFootballHeading+" Test case successfully Passed");
		}
		else
		{
			FailTestCase("Actual FootballHeading Title : "+actualFootballHeading+" and Expected FootballHeading Title : "+expectedFootballHeading+" Test case Failed");
			
		}
		
		reports.log(LogStatus.PASS, "Navigate to the FootCalender Screen");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		String actualCalenderHeading=footballCalendar.getText();
		System.out.println("actualCalenderHeading ::"+actualCalenderHeading);
		String expectedCalenderHeading=TestInitization.getExcelKeyValue("TvFilterLayer","FootballCalendar","name_nl");
		if (actualCalenderHeading.equalsIgnoreCase(expectedCalenderHeading))
		{
			reports.log(LogStatus.PASS, "Actual CalenderHeading Title : "+actualCalenderHeading+" and Expected CalenderHeading Title : "+expectedCalenderHeading+" Test case successfully Passed");
		}
		else
		{
			FailTestCase("Actual CalenderHeading Title : "+actualCalenderHeading+" and Expected CalenderHeading Title : "+expectedCalenderHeading+" Test case Failed");
		}
		
		reports.log(LogStatus.PASS, "Navigate to the RadioStation Screen");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		String actualRadioStationsHeading=radioStations.getText();
		System.out.println("actualradioStationsHeading ::"+actualRadioStationsHeading);
		String expectedRadioStations=TestInitization.getExcelKeyValue("TvFilterLayer","RadioStations","name_nl");
		if (actualRadioStationsHeading.equalsIgnoreCase(expectedRadioStations))
		{
			reports.log(LogStatus.PASS, "Actual radio Stations Heading Title : "+actualRadioStationsHeading+" and Expected radio Stations Heading Title : " +expectedRadioStations+" Test case successfully Passed");
		}
		else
		{
			FailTestCase("Actual radio Stations Heading Title : "+actualRadioStationsHeading+" and Expected radio Stations Heading Title : "+expectedRadioStations+" Test case Failed");
		}
		
		reports.log(LogStatus.PASS, "Navigate to the Search Screen");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		String actualSearchHeading=search.getText();
		System.out.println("actualSearchHeading ::"+actualSearchHeading);
		String expectedSearchHeading=TestInitization.getExcelKeyValue("TvFilterLayer","Search","name_nl");
		if (actualSearchHeading.equalsIgnoreCase(expectedSearchHeading))
		{
			reports.log(LogStatus.PASS, "Actual Search Heading Title : "+actualSearchHeading+" and Expected Search Heading Title : "+expectedSearchHeading+" Test case successfully Passed");
		}
		else
		{
			FailTestCase( "Actual Search Heading Title : "+actualSearchHeading+" and Expected Search Heading Title : "+expectedSearchHeading+" Test case Failed");
		}
		
		
		for(int i=0;i<5;i++)
		{
			TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
			
		}
		
		return true;
		
	
	}
	
}
