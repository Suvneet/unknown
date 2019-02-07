package com.rsystems.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class Hub extends TestInitization {
	
	WebDriver driver;
	
	public Hub(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubTVItem)
	public WebElement hubTelevisionTextLine;
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubLibraryItem)
	public WebElement hubLibraryTextLine;
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubStoreItem)
	public WebElement hubStoreTextLine;
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubSearchItem)
	public WebElement hubSearchTextLine;
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubSettingsItem)
	public WebElement hubSettingsTextLine;
		
	@FindBy(how=How.XPATH,using=ObjectRepository.HubScreen.headerElement)
	public WebElement headerText;
	

	@FindAll({@FindBy(xpath = ObjectRepository.HubScreen.libraryItemsElement)})
	public List<WebElement> libraryItmes;
	
	@FindAll({@FindBy(xpath = ObjectRepository.HubScreen.shopItemsElement)})
	public List<WebElement> shopItems;
	

	@FindBy(how=How.XPATH,using=ObjectRepository.HubScreen.hubSearchElement)
	public WebElement hubSearchTextElement;
	
	@FindBy(how=How.XPATH,using= ObjectRepository.HubScreen.hubSettingElement)
	public WebElement hubSettingTextElement;
	
	@FindBy(how=How.CLASS_NAME,using= ObjectRepository.HubScreen.hubFocusElement)
	public WebElement focusHubElement;
	
	@FindBy(how=How.ID,using = ObjectRepository.HubScreen.upCanvasLineElement)
	public WebElement upCanvasLine;

	@FindBy(how=How.ID,using = ObjectRepository.HubScreen.downCanvasLineElement)
	public WebElement downCanvasLine;

	public List<WebElement> hubMenuItems()
	{
		/*
		 * This function will check the different elements present on the screen including their translation, font-size, position etc.
		 * Created by Nitin Kaushik
		 */
		log.info("Inside hubMenuItems method ::: It will return the list of elements containing Menu Items");
		System.out.println("Inside hubMenuItems method");
		return driver.findElements(By.xpath("//li[contains(@id,'menuItem')]"));
		
		
	}
	
	
	
	public void launchAndVerifyMenuScreen() throws InterruptedException
	{
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 500);
		driver.switchTo().defaultContent();
		if (headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "home", "name_nl")))
		{
			driver.switchTo().frame(getCurrentFrameIndex());
			reports.log(LogStatus.PASS, "Menu is open successfully and focus is on " + focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Menu not opened successfully");
		}
	}
	/*
	 * This function will return the list of translation of Hub Menu Items
	 * Created by Nitin Kaushik
	 */
	
	public List<String> getHubMenuItemsText()
	{
		
		log.info("Inside hubMenuItemsTranslation method ::: This function will return the list of Hub Menu Items Text");
		System.out.println("Inside hubMenuItemsTranslation method ::: This function will return the list of Hub Menu Items Text");
		
		List<String> hubMenuItemList = new ArrayList<String>();
		
		
		for(int i=0; i<driver.findElements(By.xpath("//li[contains(@id,'menuItem')]")).size() ;i++)
		{
			
			
			if(i<3)
			{
				hubMenuItemList.add(driver.findElements(By.xpath("//li[contains(@id,'menuItem')]")).get(i).getText());
				System.out.println("Adding value in the array list at position + " + i + " " + driver.findElements(By.xpath("//li[contains(@id,'menuItem')]")).get(i).getText());	
				
				
			}
			else
			{
				String imageURL = driver.findElements(By.xpath("//li[contains(@id,'menuItem')]")).get(i).getCssValue("background-image");
				hubMenuItemList.add(imageURL.split("/")[imageURL.split("/").length-1].replace("\")", ""));
				System.out.println("Adding value in the array list at position + " + i + " " + imageURL.split("/")[imageURL.split("/").length-1].replace("\")", ""));
			}
			
			
			
		}
		
		
		
		
		return hubMenuItemList;
		
		
	}
	
	
	public List<String> getHubMenuItemsFonts()
	{
		
		log.info("Inside getHubMenuItemsFonts method ::: This function will return the list of Hub Menu Items Fonts");
		System.out.println("Inside getHubMenuItemsFonts method ::: This function will return the list of Hub Menu Items Fonts");
		

		List<String> hubMenuItemFonts = new ArrayList<String>();
		
		
		hubMenuItemFonts.add(hubLibraryTextLine.getAttribute("font-size"));
		hubMenuItemFonts.add(hubTelevisionTextLine.getAttribute("font-size"));
		hubMenuItemFonts.add(hubStoreTextLine.getAttribute("font-size"));
		hubMenuItemFonts.add(hubSearchTextLine.getAttribute("width"));
		hubMenuItemFonts.add(hubSettingsTextLine.getAttribute("width"));

		return hubMenuItemFonts;
		
		
	}
	
	
	public String returnElementTextOrImageAtGivenLocation(WebElement element, String elementExcelX, String elementExcelY)
	{
		int x = (int) Float.parseFloat(elementExcelX);
		int y = (int) Float.parseFloat(elementExcelY);
		
		System.out.println("Element returned from excel are x & y :: " + x + " ::::: " + y);		
		System.out.println("Element passed in the function is :::::::::::  " + element);
		
		System.out.println("Element returned x & y :: " + element.getLocation().getX() + " ::::: " + element.getLocation().getY());		
		
		if(element.getLocation().getX()==x && element.getLocation().getY()==y)
		{
			System.out.println("Elemnt's X and Y cordinates are correctly matched");
			log.info("Elemnt's X and Y cordinates are correctly matched");
			
			if(element.getText()!=null)
			{
				System.out.println("Elemnt's Text returned from X and Y cordinates : " + element.getText());
				log.info("Elemnt's Text returned from X and Y cordinates : " + element.getText());
				return element.getText();
				
			}
			else if(element.getCssValue("background-image")!=null)
			{
				System.out.println("Elemnt's Image returned from X and Y cordinates : " + element.getCssValue("background-image"));
				log.info("Elemnt's Image returned from X and Y cordinates : " + element.getCssValue("background-image"));
				return element.getCssValue("background-image");
					
			}
			else
			{
				System.out.println("Neither image nor text found at Elemnt's X and Y cordinates");
				log.info("Neither image nor text found at Elemnt's X and Y cordinates");
				return "Neither text nor image found at the given location";
			}
			
		}
		else
			return "Element not found at the given cordinates";
		
		
	}

	/**
	 * This test cases is used to verify navigation in Text Line in Hub Screen.
	 *  Created By Rahul 
	 */
	public void verifyHubTextLineNavigation() throws InterruptedException {
		verifyHubLeftSideNavigation();
		verifyHubRightSideNavigation();
		
	}

	/**
	 * This test cases is used to verify navigation in right side of Text Line in Hub Screen.
	 *  Created By Rahul 
	 */
	private void verifyHubRightSideNavigation() throws InterruptedException {
		
		String actualElement = null;
		for (int i = 1;i<hubMenuItems().size();i++)
		{	sendKeyMultipleTimes("RIGHT", 1, 1000);
			if (i<3)
			{
				actualElement = focusHubElement.getText();
			}
			else
			{	
				actualElement = focusHubElement.getCssValue("background-image");
				actualElement =	actualElement.split("/")[actualElement.split("/").length-1].replace(")", "");
			}
			if (actualElement.equalsIgnoreCase(ObjectRepository.HubMenuItemsNLFocused[i]))
			{
				reports.log(LogStatus.PASS, "SEND RIGHT Key : Expected Output - Focus should be on -"+ ObjectRepository.HubMenuItemsFocused[i] +". Actual Output - Focus is on " + actualElement.split("_")[0]);
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			else
			{
				FailTestCase("Test cases is failed as Expected Output - Focus should be on -"+ ObjectRepository.HubMenuItemsNLFocused[i] +". Actual Output - Focus is on " + actualElement);
			}	
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		if (actualElement.equalsIgnoreCase(ObjectRepository.HubMenuItemsNLFocused[ObjectRepository.HubMenuItemsNLFocused.length-1]))
		{
			reports.log(LogStatus.PASS, "SEND RIGHT Key Again: Expected Output - Focus should be on -:" + ObjectRepository.HubMenuItemsFocused[ObjectRepository.HubMenuItemsFocused.length-1] + ". Actual Output - Focus is on " + actualElement.split("_")[0] + "Nothing happened");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test case is failed as  Expected Output - Focus should be on -:" + ObjectRepository.HubMenuItemsNLFocused[ObjectRepository.HubMenuItemsNLFocused.length-1] + "Focus is on " + actualElement + "Nothing happened");
		}
		
	}
	/**
	 * This test cases is used to verify navigation in left side of Text Line in Hub Screen.
	 *  Created By Rahul 
	 */
	private void verifyHubLeftSideNavigation() throws InterruptedException {
		sendKeyMultipleTimes("LEFT", 1, 1000);
		if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND LEFT Key : Expected Output - Focus should be on Library. Actual Output- Focus is on " + focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test Cases is failed as Expected Output - Focus should be on Library. Actual Output- Focus is on " + focusHubElement.getText());
		}
		sendKeyMultipleTimes("LEFT", 1, 1000);
		if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND LEFT Key Again : Expected Output - Focus should be on Library. Actual Output- Focus is on " + focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test Cases is failed as Expected Output - Focus should be on Library. Actual Output- Focus is on " + focusHubElement.getText());
		}
		
	}
	
	/**
	 * This test cases is used to verify navigation in Asset Line in Hub Screen.
	 *  Created By Rahul 
	 */

	public void verifyHubAssetLineNavigation() throws InterruptedException {
		verifyHubAssetLineLeftSideNavigation();
		verifyHubAssetLineRightSideNavigation();
	}


	/**
	 * This test cases is used to verify navigation in right side of Asset Line in Hub Screen.
	 *  Created By Rahul 
	 */
	private void verifyHubAssetLineRightSideNavigation() throws InterruptedException {
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND RIGHT KEY :- Expected Output - Focus should be on televisie. Actual Output - Focus is on " + focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test case is failed as Expected Output - Focus should be on televisie. Actual Output - Focus is on " + focusHubElement.getText());
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Shop", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND RIGHT KEY :- Expected Output - Focus should be on Shop. Actual Output - Focus is on " + focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Expected Output - Focus should be on Shop. Actual Output - Focus is on " + focusHubElement.getText());
		}
		
		for (int i = 0 ;i<shopItems.size()-1;i++)
		{
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Shop", "name_nl")))
			{
				reports.log(LogStatus.PASS, "SEND RIGHT Key : Expected Output - Focus should be on Shop. Actual Output - Focus is on " + focusHubElement.getText());
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			else
			{
				FailTestCase(" Test Cases is failed as Expected Output - Focus should be on Shop. Actual Output - Focus is on " + focusHubElement.getText());
			}
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		if (hubSearchTextElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Search", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND RIGHT Key : Expected Output - Focus should be on Search Icon. Actual Output - Focus is on Search Icon");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test Case is failed as Expected Output - Focus should be on Search Icon. Actual Output - Focus is not on Search Icon");
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		if (hubSettingTextElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Setting", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND RIGHT Key : Expected Output - Focus should be on Settings Icon. Actual Output - Focus is on Settings Icon");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test Case is failed as Expected Output - Focus should be on Settings Icon. Actual Output - Focus is not on Settings Icon");
		}
	}

	/**
	 * This test cases is used to verify navigation in left side of Asset Line in Hub Screen.
	 *  Created By Rahul 
	 */
	private void verifyHubAssetLineLeftSideNavigation() throws InterruptedException {
		sendKeyMultipleTimes("LEFT", 1, 1000);
		if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND LEFT Key : Focus should be on Library Assets. Actual Output:- Focus is on " + focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Focus should be on Library Assets. Actual Output:- Focus is on " + focusHubElement.getText());
		}
		reports.log(LogStatus.PASS,"Press LEFT Key multiple times to move around Library Assets");
		System.out.println(libraryItmes.size());
		for (int i = 0 ;i<libraryItmes.size()-1;i++)
		{
			sendKeyMultipleTimes("LEFT", 1, 1000);
			if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
			{
				reports.log(LogStatus.PASS, "SEND LEFT Key : Focus should be on Library Assets. Actual Output:- Focus is on " + focusHubElement.getText());
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			else
			{
				FailTestCase("Test cases is failed as Expected Output - Focus should be on Library Assets. Actual Output:- Focus is on " + focusHubElement.getText());
			}
		}
		reports.log(LogStatus.PASS,"Press RIGHT Key multiple times to move areoud Library Assets");
		System.out.println(libraryItmes.size());
		for (int i = 0 ;i<libraryItmes.size()-1;i++)
		{
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
			{
				reports.log(LogStatus.PASS, "SEND RIGHT Key : Expected Output - Focus should be on Library Assets. Actual Output:- Focus is on " + focusHubElement.getText());
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			else
			{
				FailTestCase("Test cases is failed as Expected Output - Focus should be on Library Assets. Actual Output:- Focus is on " + focusHubElement.getText());
			}
		}
	}

	/**
	 * This test cases is used to verify existence of two lines in Hub Screen.
	 *  Created By Rahul 
	 */
	public void verifyLinesinHub() throws InterruptedException {
		reports.log(LogStatus.PASS, "Verify Two Lines getting displayed on Hub Page");
		driver.switchTo().defaultContent();
		if (upCanvasLine.isDisplayed())
		{
			reports.log(LogStatus.PASS, "Expected Output -: Up Line should Displyaed. Actual Output :- Up Line getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Expected Output -: Up Line should Displyaed. Actual Output :- Up Line getting displayed");
		}
		if(downCanvasLine.isDisplayed())
		{
			reports.log(LogStatus.PASS, "Expected Output -: Down Line should Displyaed. Actual Output :- Down Line getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Expected Output -: Down Line should Displyaed. Actual Output :- Down Line not getting displayed");
		}
	}

	/**
	 * This test cases is used to verify opacity of two lines in Hub Screen
	 * Created By Rahul
	 */
	public void verifyOpactiyOfLines() throws InterruptedException {
		reports.log(LogStatus.PASS, "Verify Opacity of Two Lines getting displayed on Hub Page");
		driver.switchTo().defaultContent();
		if (upCanvasLine.getCssValue("opacity").equals("0.8"))
		{
			reports.log(LogStatus.PASS, "Expected Opacity of Up Line - > 0.8 or 80%. Actual Opacity of Up Line is -> " + upCanvasLine.getCssValue("opacity"));
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Expected Opacity of Up Line - > 0.8 or 80%. Actual Opacity of Up Line is -> " + upCanvasLine.getCssValue("opacity"));
		}
		if (downCanvasLine.getCssValue("opacity").equals("0.8"))
		{
			reports.log(LogStatus.PASS, "Expected Opacity of Down Line - > 0.8 or 80%. Actual Opacity of Down Line is -> " + downCanvasLine.getCssValue("opacity"));
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Expected Opacity of Down Line - > 0.8 or 80%. Actual Opacity of Down Line is -> " + downCanvasLine.getCssValue("opacity"));
		}
	}

	/**
	 * This test cases is used to verify Asset Line in Hub Screen above Text line
	 * Created By Rahul
	 */
	public void verifyAssetLine() throws InterruptedException {
		int timetoMoveLeft = libraryItmes.size();
		sendKeyMultipleTimes("LEFT", timetoMoveLeft, 1000);
		reports.log(LogStatus.PASS,"Naviagte to Left Most Asset and Verfiy the Asset Line Order");
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Verify from Left First Library showcase assets should be displayed");
		for (int i = 0;i<timetoMoveLeft-1;i++){
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
			{
				reports.log(LogStatus.PASS, "SEND RIGHT Key :- Library Showcase assets getting displayed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			else
			{
				FailTestCase( "Test cases is failed as Expected Output - Focus should be on Library Assets.  Actual Output - Focus is on " + focusHubElement.getText());
			}
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTv", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND RIGHT Key :- TV Showcase assets getting displayed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase( "Expected Output - Focus should be on TV Assets.  Actual Output - Focus is on " + focusHubElement.getText());
		}
		for (int i = 0;i<shopItems.size();i++){
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			if (focusHubElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Shop", "name_nl")))
			{
				reports.log(LogStatus.PASS, "SEND RIGHT Key :- Shop assets getting displayed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			else
			{
				FailTestCase( "Test cases is failed as Expected Output - Focus should be on Shop Assets.  Actual Output - Focus is on " + focusHubElement.getText());
			}
		}
		sendKeyMultipleTimes("RIGHT", 1, 2000);
		if (hubSearchTextElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Search", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND RIGHT Key :- Expected Output - Focus should be on :- " + getExcelKeyValue("screenTitles", "Search", "name_nl") +" Actual Output - Focus is on " + hubSearchTextElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Expected Output - Focus should be on :- " + getExcelKeyValue("screenTitles", "Search", "name_nl") +" Actual Output - Focus is on " + hubSearchTextElement.getText());
		}
		sendKeyMultipleTimes("RIGHT", 1, 2000);
		if (hubSettingTextElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Setting", "name_nl")))
		{
			reports.log(LogStatus.PASS, "SEND RIGHT Key :- Expected Output - Focus should be on :- " + getExcelKeyValue("screenTitles", "Setting", "name_nl") +" Focus is on " + hubSettingTextElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Test cases is failed as Expected Output - Focus should be on :- " + getExcelKeyValue("screenTitles", "Setting", "name_nl") +" Focus is on " + hubSettingTextElement.getText());
		}		
	}	
}
