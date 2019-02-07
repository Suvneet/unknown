package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.rsystems.config.ObjectRepository;

public class RentMovie {

	WebDriver driver;

	public RentMovie(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ObjectRepository.FilmsScreen.highlighedMovieCategory)
	public WebElement highlighedMovieCategory;
	
	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.currentSelectedMovieName)
	public WebElement currentSelectedMovieName;
	
	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.rentOption)
	public WebElement rentOption;

}
