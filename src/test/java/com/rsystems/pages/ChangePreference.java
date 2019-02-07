package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.ProximusContext;
import com.rsystems.utils.TestInitization;

public class ChangePreference extends TestInitization
{
    
	WebDriver driver;
    public ChangePreference(WebDriver driver) 
    {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }
    
    @FindBy(how = How.ID, using = ObjectRepository.LanguageChange.position)
	public WebElement position;
    
    @FindBy(how = How.CLASS_NAME, using = ObjectRepository.LanguageChange.menuItem)
  	public WebElement menuItem;
    
    @FindBy(how = How.ID, using = ObjectRepository.LanguageChange.confirm)
  	public WebElement confirm;
    
    @FindBy(how = How.ID, using = ObjectRepository.LanguageChange.heading)
  	public WebElement heading;
    
    @FindBy(how = How.ID, using = ObjectRepository.LanguageChange.languagedumenu)
  	public WebElement languagedumenu;
    
    @FindBy(how = How.ID, using = ObjectRepository.LanguageChange.itemHeading)
  	public WebElement itemHeading;
    
    
	public void navigateToMyPreference() throws InterruptedException
	{
		    SystemInfoScreen systeminfo = new SystemInfoScreen(driver);
		    systeminfo.navigateToSytemScreen();
			reports.log(LogStatus.PASS, "Navigate to the Preference Screen");
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	}
	public void languageChange(String language) throws InterruptedException
    {
		reports.log(LogStatus.PASS, "Navigate to the Language Change Screen - Change language to " + language);	
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String currentStatusLanguage=position.getText();
	    System.out.println(currentStatusLanguage +" " +language);
		if(!currentStatusLanguage.equalsIgnoreCase(language))
		{
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 2000); 
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 2000);
			System.out.println("title "+confirm.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 3000);
			reports.log(LogStatus.PASS, "Language changed to "+ language);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			ProximusContext.setLanguage(language);
		}
		else
		{
		 System.out.println("No changes required. Already " + language + " is set");
		 reports.log(LogStatus.FAIL, "Either the language you have entered is not in the list or its a default setting language");
		 reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
    }
	
	
	
	public boolean changeAndVerifyLanguage(String language) throws InterruptedException
	{
		languageChange(language);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String actualScreenTitleFrench = heading.getText();
		String actualLanguagedumenu=languagedumenu.getText();
		
		String languageTheShop=itemHeading.getText();
		System.out.println("actualScreenTitleFrench "+actualScreenTitleFrench);
		System.out.println("actualLanguagedumenu "+actualLanguagedumenu);
		System.out.println("languageTheShop "+languageTheShop);
		String actualScreenTitleNL = heading.getText();
		
		System.out.println("actualScreenTitleNL "+actualScreenTitleNL);
	
	
		String languagedumenuNL=languagedumenu.getText();
		System.out.println("languagedumenuFL "+languagedumenuNL);
	    String languageTheSop=itemHeading.getText();
	    System.out.println("languageTheSop "+languageTheSop);
	    
		if (language.equalsIgnoreCase(TestInitization.getExcelKeyValue("parameters", "language_FR", "name_nl")))
		{
			String expectedScreenTitleFrench = TestInitization.getExcelKeyValue("parameters", "preferenceFrench", "name_nl");
			String expectedactualLanguagedumenu = TestInitization.getExcelKeyValue("parameters", "languageMenuFR", "name_nl");
			String expectedlanguageTheShop = TestInitization.getExcelKeyValue("parameters", "language_the_shop_FR", "name_nl");
			
			System.out.println("expectedScreenTitleFrench "+expectedScreenTitleFrench);
			System.out.println("expectedactualLanguagedumenu "+expectedactualLanguagedumenu);
			System.out.println("expectedlanguageTheShop "+expectedlanguageTheShop);
			
			if (actualScreenTitleFrench.equalsIgnoreCase(expectedScreenTitleFrench)&& actualLanguagedumenu.equalsIgnoreCase(expectedactualLanguagedumenu)&&languageTheShop.equalsIgnoreCase(expectedlanguageTheShop)) 
			{
			reports.log(LogStatus.PASS, "Actual Screen Title French : "+ actualScreenTitleFrench + " and Expected Screen Title French : " + expectedScreenTitleFrench +" Test case successfully Passed");
			reports.log(LogStatus.PASS, "Language Menu : "+ actualLanguagedumenu + " and Expected Language Menu : " + expectedactualLanguagedumenu +" Test case successfully Passed");
			reports.log(LogStatus.PASS, "Language shop Title : "+ languageTheShop + " and Expected Language shop Title : " + expectedlanguageTheShop +" Test case successfully Passed");
			return true;
			}
			else 
			{
			reports.log(LogStatus.FAIL, "Actual Screen Title French : "+ actualScreenTitleFrench + " and Expected Screen Title French : " + expectedScreenTitleFrench +" Test case Failed");
			reports.log(LogStatus.FAIL, "Language Menu : "+ actualLanguagedumenu + " and Expected Language Menu : " + expectedactualLanguagedumenu +" Test case Failed");
			reports.log(LogStatus.FAIL, "Language shop Title : "+ languageTheShop + " and Expected Language shop Title : " + expectedlanguageTheShop +" Test case Failed");
			return false;
			}	
		}
		else if(language.equals(TestInitization.getExcelKeyValue("parameters", "language_NL", "name_nl")))
		{
			String expectedScreenTitleNL = TestInitization.getExcelKeyValue("parameters", "preferenceNL", "name_nl");
			String expectedlanguagedumenuNL = TestInitization.getExcelKeyValue("parameters", "languageMenuNL", "name_nl");
			String expectedlanguageTheSop = TestInitization.getExcelKeyValue("parameters", "language_the_shop_NL", "name_nl");
			
			System.out.println("expectedScreenTitleNL "+expectedScreenTitleNL);
			System.out.println("expectedlanguagedumenuNL "+expectedlanguagedumenuNL);
			System.out.println("expectedlanguageTheSop "+expectedlanguageTheSop);
			
			if (actualScreenTitleNL.equalsIgnoreCase(expectedScreenTitleNL)&& languagedumenuNL.equalsIgnoreCase(expectedlanguagedumenuNL)&&languageTheSop.equals(expectedlanguageTheSop)) 
			{
			reports.log(LogStatus.PASS, "Actual Screen Title NL : "+ actualScreenTitleNL + " and Expected Screen Title NL : " + expectedScreenTitleNL +" Test case successfully Passed");
			reports.log(LogStatus.PASS, "Actual language Title NL : "+ languagedumenuNL + " and Expected language Title NL : " + expectedlanguagedumenuNL +" Test case successfully Passed");
			reports.log(LogStatus.PASS, "Language Shop Title : "+ languageTheSop + " and Expected Language Shop Title : " + expectedlanguageTheSop +" Test case successfully Passed");
			return true;
			}
			else 
			{
			reports.log(LogStatus.FAIL, "Actual Screen Title NL : "+ actualScreenTitleNL + " and Expected Screen Title NL : " + expectedScreenTitleNL +" Test case Failed");
			reports.log(LogStatus.FAIL, "Actual language Title NL : "+ languagedumenuNL + " and Expected language Title NL : " + expectedlanguagedumenuNL +" Test case Failed");
			reports.log(LogStatus.FAIL, "Language Shop Title : "+ languageTheSop + " and Expected Language Shop Title : " + expectedlanguageTheSop +" Test case Failed");
			return false;
			}			
		}
		return true;	
	}
}
