package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

public class ZapList extends TestInitization{

	
	 WebDriver driver;

	public ZapList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = ObjectRepository.ZapListPage.screenTitle)
	public WebElement screenTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.ZapListPage.focousChannelNumber)
	public WebElement focousChannelNumber;

	
}
