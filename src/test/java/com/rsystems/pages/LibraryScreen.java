package com.rsystems.pages;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

import junit.framework.Assert;

public class LibraryScreen extends TestInitization {


	/**
	 * This function is used to get all the Library Menu Items List
	 * Created By Rahul Dhoundiyal
	 */
	
	@FindBy(how = How.XPATH, using = ObjectRepository.LibraryElements.libraryCanvas)
	public WebElement libraryCanvas;
	
	public static List<WebElement> libraryMenuItems()
	{
		return driver.findElements(By.xpath(ObjectRepository.LibraryElements.libraryMenuItemsXPath));
		
	}
	/**
	 * This function is used to get all the Library Sub Menu Items List for a particular Menu
	 * Created By Rahul Dhoundiyal
	 */
	public static List<WebElement> libraryMenuSubItems(int i)
	{
		return driver.findElements(By.cssSelector("#focus_row_"+i+" li[id^='item']"));
	}
	/** 
	 *  This function is used to move to Library Section 
	 *  Created By Rahul Dhoundiyal
	 */
	public static void moveToLibrary() throws InterruptedException
	{
		reports.log(LogStatus.PASS, "Navigate the filter layer screen");
		TestInitization.sendKeySequence("DOWN,LEFT,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "Library", "name_nl"));
	}
	
	/**
	 *  This function is used to get the text for all menu items
	 *  Created By Rahul Dhoundiyal
	 */
	public static List<String> getLibraryMenuItemsText() throws InterruptedException
	{	
		
		moveToLibrary();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> libraryMenuItemList = new ArrayList<String>();
		for(int i=0 ; i<LibraryScreen.libraryMenuItems().size() ; i++)
		{
			libraryMenuItemList.add(LibraryScreen.libraryMenuItems().get(i).getText());
		}
		return libraryMenuItemList;
	}
	/**
	 *  This function is used to get the font-size for all menu items
	 *  Created By Rahul Dhoundiyal
	 */
	public static List<String> getLibraryMenuItemFontSize() throws InterruptedException
	{	moveToLibrary();
		System.out.println("Inside getLibraryMenuItemFontSize method");
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> libraryMenuItemFontList = new ArrayList<String>(); 
		for(int i=0 ; i<LibraryScreen.libraryMenuItems().size() ; i++)
		{
			libraryMenuItemFontList.add(LibraryScreen.libraryMenuItems().get(i).getCssValue("font-size"));
		}
		return libraryMenuItemFontList;
	}
	/**
	 *  This function is used to verify the expected text or font-size of menu items with actual text or font-size
	 *  Created By Rahul Dhoundiyal
	 */
	public static boolean VerifyMenuItemsTextOrFonts(List<String> actualList,String keyName) throws InterruptedException
	{
		boolean validateTextOrFont = false;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> expectedList = new ArrayList<String>();
		for(int i=0; i<LibraryScreen.libraryMenuItems().size(); i++)
		{
			expectedList.add(TestInitization.getExcelKeyValue("library", LibraryScreen.libraryMenuItems().get(i).getText(),keyName));			
		}
		for (int i = 0;i<expectedList.size();i++)
		{	
			Assert.assertEquals(expectedList.get(i), actualList.get(i));
			reports.log(LogStatus.PASS,"Expected List" + expectedList.get(i) + "Actual List :"+LibraryScreen.libraryMenuItems().get(i).getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			if (expectedList.get(i).equalsIgnoreCase(actualList.get(i))){
				validateTextOrFont = true;
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}	
			else{
				validateTextOrFont = false;
			}
		}
		return validateTextOrFont;
	}
	/**
	 *  This function is used to get the text for all sub menu items
	 *  Created By Rahul Dhoundiyal
	 */ 
	public static List<String> getLibrarySubMenuListText() throws InterruptedException
	{	
		moveToLibrary();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> subMenuList = new ArrayList<String>();
		for(int i=0;i<LibraryScreen.libraryMenuItems().size();i++)
		{
			TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
			for (int j=0; j<LibraryScreen.libraryMenuSubItems(i).size(); j++){
				subMenuList.add(LibraryScreen.libraryMenuSubItems(i).get(j).getAttribute("innerText"));
				TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			}
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		return subMenuList;
	}
	/**
	 *  This function is used to get the font-size for all sub menu items
	 *  Created By Rahul Dhoundiyal
	 */
	public static List<String> getLibrarySubMenuFontSize() throws InterruptedException
	{	moveToLibrary();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> listOfSubMenuFontList = new ArrayList<String>();
		for(int i=0;i<LibraryScreen.libraryMenuItems().size();i++)
		{
			TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
			for(int j=0;j<LibraryScreen.libraryMenuSubItems(i).size();j++)
			{
				listOfSubMenuFontList.add(LibraryScreen.libraryMenuSubItems(i).get(j).getCssValue("font-size"));
				TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			}
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		return listOfSubMenuFontList;
	}
	/**
	 *  This function is used to verify the expected text or font-size of sub menu items with actual text or font-size
	 *  Created By Rahul Dhoundiyal
	 */
	public static boolean verifyLibrarySubMenuTextOrFonts(List<String> actualList,String keyName) throws InterruptedException{
		// Switch to Active Frame
		boolean validateTextOrFont = false;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> expectedList = new ArrayList<String>();
		TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
		for(int i=0;i<LibraryScreen.libraryMenuItems().size();i++)
		{
			for (int j=0;j<LibraryScreen.libraryMenuSubItems(i).size();j++)
			{	
				if (i==1)
				{
					System.out.println(TestInitization.getExcelKeyValue("library","Apps", keyName));
					expectedList.add(TestInitization.getExcelKeyValue("library","Apps", keyName));
				}
				else
				{
					expectedList.add(TestInitization.getExcelKeyValue("library", LibraryScreen.libraryMenuSubItems(i).get(j).getAttribute("innerText"), keyName));
				}
			}
		}
		
		for (int i=0;i<expectedList.size();i++)
		{	
			Assert.assertEquals(expectedList.get(i), actualList.get(i));
			if (expectedList.get(i).equalsIgnoreCase(actualList.get(i)))
			{
				reports.log(LogStatus.PASS,"Expected"+ keyName +"- "+expectedList.get(i) + " Actual"+keyName+"-"+actualList.get(i));
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				validateTextOrFont = true;
			}
		}
		return validateTextOrFont;
		
	}
	
}