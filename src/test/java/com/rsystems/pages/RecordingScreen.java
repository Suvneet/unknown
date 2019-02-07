package com.rsystems.pages;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class RecordingScreen extends TestInitization{
	
	WebDriver driver;
	public RecordingScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RecordingElements.InfoEpisodeNameXPath)
	public WebElement getInfoEpisodeName;
	
	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RecordingElements.ChannelNoClassName)
	public WebElement getChannelNo;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.RecordingElements.ChannelInfoImageXPath)
	public WebElement getChannelInfoImage;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.RecordingElements.EpisodeDurationXPath)
	public WebElement getEpisodeDuration;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.RecordingElements.ProgramDefinitionXPath)
	public WebElement getChannelDefiniton;
	
	@FindBy(how = How.ID,using = ObjectRepository.RecordingElements.totalRecordingsID)
	public WebElement totalRecordingID;
	
	@FindBy(how = How.XPATH,using = ObjectRepository.RecordingElements.focusRecordingElementXPath)
	public WebElement focusRecordingElement;

	@FindBy(how = How.ID,using = ObjectRepository.RecordingElements.currentRecordingCountID)
	public WebElement currentRecordingCountID;
	
	@FindBy(how = How.CLASS_NAME,using = ObjectRepository.RecordingElements.focusProgramCalssName)
	public WebElement focusProgram;
	
	@FindBy(how = How.CLASS_NAME,using = ObjectRepository.RecordingElements.activeMenuItemElement)
	public WebElement activeInfoMenuItem;
	
	@FindBy(how=How.ID,using = ObjectRepository.RecordingElements.plannedRecordingTitleElement)
	public WebElement plannedRecordingScreenTitle;
	
	@FindBy(how=How.ID,using = ObjectRepository.RecordingElements.epgGuideElement)
	public WebElement EpgGuide;
	
	@FindBy(how = How.XPATH,using = ObjectRepository.RecordingElements.recordingIconElement)
	public WebElement recordingIconElement;
	
	@FindBy(how=How.XPATH,using = ObjectRepository.HubScreen.headerElement)
	public WebElement headerElement;
	/**
	 * This function is used to get Episode Name.
	 * Created By Rahul Dhoundiyal
	 */
	public String getInfoEpisodeName()
	{
		return getInfoEpisodeName.getText();
	}
	/**
	 * This function is used to get Channel Number.
	 * Created By Rahul Dhoundiyal
	 */
	public String getChannelNo()
	{
		return getChannelNo.getText();
	}
	/**
	 * This function is used to get Channel Info Image.
	 * Created By Rahul Dhoundiyal
	 */
	public String getChannelInfoImage()
	{
		String[] channelInfoImageUrl = getChannelInfoImage.getAttribute("src").split("/"); 
		return channelInfoImageUrl[channelInfoImageUrl.length-1];
	}
	/**
	 * This function is used to get Episode Duration.
	 * Created By Rahul DHoundiyal
	 */
	public String getEpisodeDuration()
	{
		return getEpisodeDuration.getText();
	}
	/**
	 * This function is used to get Channel Definition.
	 * Created By Rahul Dhoundiyal
	 */
	public String getChannelDefiniton()
	{ 
		String channelDefString = null;
		try
		{
			channelDefString = getChannelDefiniton.getAttribute("src");
		}
		catch(NoSuchElementException ne)
		{
			channelDefString = null;
		}
		return channelDefString;
	}
	/**
	 * This class is used to set the details of program
	 * @author Rahul.Dhoundiyal
	 *
	 */
	public class EpisodeInfo {
		public String channelNo;
		public String programName;
		public String programDuration;
		public String programDefiniton;
		public EpisodeInfo(String channelNo, String programName, String programDuration,String programDefiniton) {
			this.channelNo = channelNo;
			this.programName = programName;
			this.programDuration = programDuration;
			this.programDefiniton = programDefiniton;
		}
	}
	/**
	 * This function is used to navigate to Planning Menu Under Library Screen
	 * Created By Rahul Dhoundiyal
	 */
	public void moveToPlannedRecordings() throws InterruptedException
	{	driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		reports.log(LogStatus.PASS, "Navigate to Hub Page");
		TestInitization.setApplicationHubPage(2);
		//Move to My Library
		reports.log(LogStatus.PASS, " Navigate to mijn bibliotheek Screen ");
		TestInitization.sendKeyMultipleTimes("LEFT",1,1000);
		TestInitization.sendKeyMultipleTimes("ENTER",1,3000);
		reports.log(LogStatus.PASS, " mijn bibliotheek Screen getting displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		//Move to Planning
		reports.log(LogStatus.PASS, " Navigate to mijn planning Screen ");
		TestInitization.sendKeyMultipleTimes("DOWN",1,1000);
		TestInitization.sendKeyMultipleTimes("DOWN",1,1000);
		TestInitization.sendKeyMultipleTimes("ENTER",1,3000);
		reports.log(LogStatus.PASS, " mijn planning Screen getting displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	}
	
	private void moveToOngoingandCompletedRecordingList() throws InterruptedException {
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		reports.log(LogStatus.PASS, "Navigate to Hub Page");
		TestInitization.setApplicationHubPage(1);
		//Move to My Library
		reports.log(LogStatus.PASS, " Navigate to mijn bibliotheek Screen ");
		TestInitization.sendKeyMultipleTimes("LEFT",1,1000);
		TestInitization.sendKeyMultipleTimes("ENTER",1,3000);
		reports.log(LogStatus.PASS, " mijn bibliotheek Screen getting displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		//Move to Planning
		reports.log(LogStatus.PASS, " Navigate to opnames Screen ");
		TestInitization.sendKeyMultipleTimes("ENTER",1,3000);
		reports.log(LogStatus.PASS, " Ongoing and Completed Recording lists Screen getting displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	} 
	
	/**
	 * This function is used to start recording on future channel.It will return the episode details like channel number,program name,Info Image,Channel Definition
	 * Created By Rahul Dhoundiyal
	 */
	public List<EpisodeInfo> scheduleRecordingForFutureChannel(String recordingType,int numberOfRecording) throws InterruptedException{
		boolean stopRecording = false;
		String epgepisodeName = null;
		int noOfRecordedChannel = 0;
		List<EpisodeInfo> programDetails = new ArrayList<EpisodeInfo>();
		//Move to Future Epsiode
		new DTVChannelScreen(driver).openLiveTV();

		Thread.sleep(1000);
		sendNumaricKeys(1);
		Thread.sleep(1000);
		sendKeyMultipleTimes("RIGHT", 2, 2000);
		reports.log(LogStatus.PASS, " Mini EPG Screen Displayed ");
		reports.attachScreenshot(captureCurrentScreenshot());
		while(!stopRecording){
			if (numberOfRecording != noOfRecordedChannel)
			{		driver.switchTo().defaultContent();
					if (!driver.findElement(By.xpath("//p[@id='headerTitle']")).getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl")))
					{
						sendKeyMultipleTimes("UP", 1, 1000);
						sendKeyMultipleTimes("ENTER", 1, 1000);
					}
					sendKeyMultipleTimes("RIGHT", 1, 3000);
					reports.log(LogStatus.PASS, "SEND RIGHT KEY - Navigate to Next Episode");
					reports.attachScreenshot(captureCurrentScreenshot());
					Thread.sleep(1000);
					driver.switchTo().frame(getCurrentFrameIndex());
					epgepisodeName = driver.findElement(By.className("current")).findElement(By.tagName("h2")).getAttribute("innerText");
					System.out.println(epgepisodeName);
					//Enter to open Episode Info
					sendKeyMultipleTimes("ENTER", 1, 3000);
					if(recordingType.equalsIgnoreCase("SINGLE")){
						Thread.sleep(1000);
						reports.log(LogStatus.PASS, " Episode Info Screen getting displayed ");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						if (activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")){
							programDetails.add(new EpisodeInfo(getChannelNo(), epgepisodeName, getEpisodeDuration(),getChannelDefiniton()));
							reports.log(LogStatus.PASS, " Click on opnemen to start recording on - "+ epgepisodeName);
							sendKeyMultipleTimes("ENTER", 1, 1000);
							driver.switchTo().defaultContent();
							wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='headerTitle']")));
							driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
							sendKeyMultipleTimes("ENTER", 1, 1000);
							sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
							reports.attachScreenshot(captureCurrentScreenshot());
							noOfRecordedChannel += 1;
						}
						else if(activeInfoMenuItem.getText().equalsIgnoreCase("herstarten"))
						{
							sendKeyMultipleTimes("DOWN", 1, 1000);
							Thread.sleep(1000);
							reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
							driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
							if (activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")){
								programDetails.add(new EpisodeInfo(getChannelNo(), epgepisodeName, getEpisodeDuration(),getChannelDefiniton()));
								reports.log(LogStatus.PASS, " Click on opnemen to start recording on - "+epgepisodeName);
								sendKeyMultipleTimes("ENTER", 1, 1000);
								driver.switchTo().defaultContent();
								wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='headerTitle']")));
								driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
								sendKeyMultipleTimes("ENTER", 1, 2000);
								sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
								reports.attachScreenshot(captureCurrentScreenshot());
								noOfRecordedChannel += 1;
							}
							else
							{
								reports.log(LogStatus.PASS, " Already recording is scheduled on  " + epgepisodeName + " epsiode. Unable to record this episode");
								reports.attachScreenshot(captureCurrentScreenshot());
								sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
								driver.switchTo().defaultContent();
								wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='headerTitle']")));
								driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
								reports.log(LogStatus.PASS," Going back and Navigate to another Channel");
							}
						}
						else 
						{	reports.log(LogStatus.PASS, " Already recording is scheduled on  " + getInfoEpisodeName() + " epsiode. Unable to record this episode");
							reports.attachScreenshot(captureCurrentScreenshot());
							sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
							driver.switchTo().defaultContent();
							wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='headerTitle']")));
							driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
							reports.log(LogStatus.PASS," Going back and Navigate to another Channel");
						}
					}
					else
					{
						sendKeyMultipleTimes("DOWN", 1, 1000);
						sendKeyMultipleTimes("ENTER", 1, 1000);
						driver.switchTo().defaultContent();
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='headerTitle']")));
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
					}
			}
			else
			{
				stopRecording = true;
				break;
			}
		}
		return programDetails;
	}

	public EpisodeInfo startRecordingFromEPGScreen(String recordingType) throws InterruptedException {
		String epgEpisodeName = null;
		boolean stopRecording = false;
		//Navigate to EPG Screen
		EpisodeInfo episodeDetails = null;
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgChannelScreen(true);
		while(!stopRecording){
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			System.out.println(focusProgram.findElements(By.cssSelector(".epggroupicon img[src='./resources/common/images/ico_Ongoing_recording.png']")).isEmpty());
			if (focusProgram.findElements(By.cssSelector(".epggroupicon img[src='./resources/common/images/ico_Ongoing_recording.png']")).isEmpty())
			{
				epgEpisodeName = epgScreen.focusElemntInEpg.getText();
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 2000);
				reports.log(LogStatus.PASS, "Info Screen of ongoing program getting displayed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				if (recordingType.equalsIgnoreCase("SINGLE"))
				{
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
					if (activeInfoMenuItem.getText().equalsIgnoreCase("opnemen"))
					{
						episodeDetails =  new EpisodeInfo(getChannelNo(), epgEpisodeName, getEpisodeDuration(),getChannelDefiniton());
						reports.log(LogStatus.PASS, "Click on opnemen to start recording");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 2000);
						reports.log(LogStatus.PASS, "Recording Starting On  : " + epgEpisodeName);
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						stopRecording = true;
					}
					else if (activeInfoMenuItem.getText().equalsIgnoreCase("herstarten"))
					{
						sendKeyMultipleTimes("DOWN", 1, 2000);
						if (activeInfoMenuItem.getText().equalsIgnoreCase("opnemen"))
						{
							episodeDetails =  new EpisodeInfo(getChannelNo(), epgEpisodeName, getEpisodeDuration(),getChannelDefiniton());
							TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
							reports.log(LogStatus.PASS, "Click on opnemen to start recording");
							reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
							driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
							stopRecording = true;
						}
						else
						{
							reports.log(LogStatus.PASS, "Already Recording is scheduled for current episode.Navigate to Future Epsiode");
							TestInitization.sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
							reports.attachScreenshot(captureCurrentScreenshot());
							TestInitization.sendKeyMultipleTimes("DOWN", 1, 2000);
						}
					}
					else
					{
						reports.log(LogStatus.PASS, "Already Recording is scheduled for current episode.Navigate to Future Epsiode");
						TestInitization.sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
						reports.attachScreenshot(captureCurrentScreenshot());
						TestInitization.sendKeyMultipleTimes("DOWN", 1, 2000);
					}
				}
				else
				{
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
					if (activeInfoMenuItem.getText().equalsIgnoreCase("serie opnemen"))
					{
						episodeDetails =  new EpisodeInfo(getChannelNo(), epgEpisodeName, getEpisodeDuration(),getChannelDefiniton());
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.log(LogStatus.PASS, "Click on serie opnemen to start recording");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						System.out.println(episodeDetails.toString() + episodeDetails.channelNo + episodeDetails.programDefiniton + episodeDetails.programDuration);
						stopRecording = true;
					}
					else
					{
						TestInitization.sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
						TestInitization.sendKeyMultipleTimes("DOWN", 1, 2000);
					}
					
				}
				
			}
			else
			{
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			
		}
		return episodeDetails;
	}

	/**
	 * This function is used to delete recording from scheduled recorded list under planning option of Library
	 * Created By Rahul Dhoundiyal
	 */
	public void deleteSchduledRecording(EpisodeInfo episodeDetails,String recordingType) throws InterruptedException{
		moveToPlannedRecordings();
		//Recording.moveToSingleAsset(recordedAssetName);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<WebElement> recordingContentElementList;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		reports.log(LogStatus.PASS, " Navigate to "+ episodeDetails.programName +" recording ");
		for(int i=0;i<recordingContentElementList.size();i++)
		{
			if((recordingContentElementList.get(i).getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
			{
				if (recordingContentElementList.get(i).findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDurationInPlannedRecording)).getText().split("-")[1].trim().equalsIgnoreCase(episodeDetails.programDuration))
				{
					reports.log(LogStatus.PASS, "Episode - "+ episodeDetails.programName + " found ");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					break;
				}
				else
				{	
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
				}
			}
			else
			{
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			
		}
		//Enter to Info Page
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		//Click on Delete
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS,"Expected Output - " +episodeDetails.programName +" Info Screen should be displayed with Delete Option " + " Actual Output - " +episodeDetails.programName+" Info Screen getting displayed with Delete Option ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS, episodeDetails.programName + " Recording Deleted Successfully");
	}
	/**
	 * This function is used to verify the recording is scheduled properly or not.
	 * Created By Rahul Dhoundiyal
	 * 
	 */
	public boolean verifyRecordingIsScheduledOrNot(EpisodeInfo episodeDetails,String recordingType) throws InterruptedException {
		boolean verifyRecording = false;
		//Move to planning
		moveToPlannedRecordings();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<WebElement> recordingContentElementList;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		reports.log(LogStatus.PASS, " Navigate to Scheduled Recording(geplande opnames) ");
		driver.switchTo().frame(getCurrentFrameIndex());
		for(int i=0;i<recordingContentElementList.size();i++)
		{
			if((recordingContentElementList.get(i).getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
			{
				
				if (recordingContentElementList.get(i).findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDurationInPlannedRecording)).getText().split("-")[1].trim().equalsIgnoreCase(episodeDetails.programDuration))
				{
					verifyRecording = true;
					break;
				}
				else
				{
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
				}
			}
			else
			{
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			
		}
		return verifyRecording;
	}

	/**
	 * This function is used to verify the recording is deleted properly or not.
	 * Created By Rahul Dhoundiyal
	 * 
	 */
	public boolean verifyRecordingisDeletedOrNot(EpisodeInfo episodeDetails, String recordingType) throws InterruptedException {
		boolean verifyRecording = true;
		//Move to planning
		moveToPlannedRecordings();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<WebElement> recordingContentElementList;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		for(int i=0;i<recordingContentElementList.size();i++)
		{
			if((recordingContentElementList.get(i).getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
			{
				if (recordingContentElementList.get(i).findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDurationInPlannedRecording)).getText().split("-")[1].trim().equalsIgnoreCase(episodeDetails.programDuration))
				{
					verifyRecording = false;
					break;
				}
				else
				{
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
				}
			}
			else
			{
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			
		}
		return verifyRecording;
	}
	
	/**
	 * This function is used to verify navigation under recordings under planned recording
	 * @return
	 * Created By Rahul Dhoundiyal
	 */
	public boolean verifyNavigationInPlannedRecording() throws InterruptedException {
		//Move to Planning under Library Section
		moveToPlannedRecordings();
		boolean verifyDownwardNavigation = false;
		boolean verifyUpwardNavigation = false;
		String countNumber = null;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String totalRecordings = totalRecordingID.getText();
		/*If there is no recording scheduled the first start multiple recording then test this scenario*/
		if (Integer.parseInt(totalRecordings) == 0)
		{
			scheduleRecordingForFutureChannel("SINGLE", 5);
			verifyNavigationInPlannedRecording();
		}
		/*Navigate down till last element of schdeule recording*/ 
		reports.log(LogStatus.PASS, " Navigate down till the last element of scheduled recordings ");
		for(int i=0;i<Integer.parseInt(totalRecordings);i++){
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		reports.log(LogStatus.PASS," Verify Focus is on last element and will not go down anymore ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		countNumber = currentRecordingCountID.getText();
		//Send Down Key to verify list is end and Down Key is not working
		reports.log(LogStatus.PASS," Send DOWN Key to verify if focus is removed from last element or not ");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		//Verify the count number should not change
		Assert.assertEquals(countNumber, currentRecordingCountID.getText());
		reports.log(LogStatus.PASS,"Focus is on last element will not go down anymore");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if(countNumber.equalsIgnoreCase(currentRecordingCountID.getText()))
		{
			verifyDownwardNavigation = true;
		}
		//Going Upward
		/*Navigate down till last element of schdeule recording*/ 
		reports.log(LogStatus.PASS, " Navigate up till the top element of scheduled recordings ");
		for(int i=0;i<Integer.parseInt(totalRecordings);i++){
			TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		}
		reports.log(LogStatus.PASS," Verify Focus is on top element and will not go up anymore ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		countNumber = currentRecordingCountID.getText();
		//Send Down Key to verify list is end and Down Key is not working
		reports.log(LogStatus.PASS," Send UP Key to verify if focus is removed from top element or not ");
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		//Verify the count number should not change
		Assert.assertEquals(countNumber, currentRecordingCountID.getText());
		reports.log(LogStatus.PASS,"Focus is on top element will not go up anymore");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if(countNumber.equalsIgnoreCase(currentRecordingCountID.getText()))
		{
			verifyUpwardNavigation = true;
		}
		return (verifyDownwardNavigation && verifyUpwardNavigation);		
	}
	
	public boolean verifyNavigationInRecordedList() throws InterruptedException {
		//Move to Planning under Library Section
		moveToRecordedItemList();
		boolean verifyDownwardNavigation = false;
		boolean verifyUpwardNavigation = false;
		String countNumber = null;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		
		String totalRecordings = totalRecordingID.getText();
		/*If there is no recording scheduled the first start multiple recording then test this scenario*/
		if (Integer.parseInt(totalRecordings) == 0)
		{
			reports.log(LogStatus.PASS, "No recorded items present");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		/*Navigate down till last element of schdeule recording*/ 
		reports.log(LogStatus.PASS, " Navigate down till the last element of scheduled recordings ");
		for(int i=0;i<Integer.parseInt(totalRecordings);i++){
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		reports.log(LogStatus.PASS," Verify Focus is on last element and will not go down anymore ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		countNumber = currentRecordingCountID.getText();
		//Send Down Key to verify list is end and Down Key is not working
		reports.log(LogStatus.PASS," Send DOWN Key to verify if focus is removed from last element or not ");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		//Verify the count number should not change
		Assert.assertEquals(countNumber, currentRecordingCountID.getText());
		reports.log(LogStatus.PASS,"Focus is on last element will not go down anymore");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if(countNumber.equalsIgnoreCase(currentRecordingCountID.getText()))
		{
			verifyDownwardNavigation = true;
		}
		//Going Upward
		/*Navigate down till last element of schdeule recording*/ 
		reports.log(LogStatus.PASS, " Navigate up till the top element of scheduled recordings ");
		for(int i=0;i<Integer.parseInt(totalRecordings);i++){
			TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		}
		reports.log(LogStatus.PASS," Verify Focus is on top element and will not go up anymore ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		countNumber = currentRecordingCountID.getText();
		//Send Down Key to verify list is end and Down Key is not working
		reports.log(LogStatus.PASS," Send UP Key to verify if focus is removed from top element or not ");
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		//Verify the count number should not change
		Assert.assertEquals(countNumber, currentRecordingCountID.getText());
		reports.log(LogStatus.PASS,"Focus is on top element will not go up anymore");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if(countNumber.equalsIgnoreCase(currentRecordingCountID.getText()))
		{
			verifyUpwardNavigation = true;
		}
		return (verifyDownwardNavigation && verifyUpwardNavigation);		
	}
	
	private void moveToRecordedItemList() throws InterruptedException {
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		reports.log(LogStatus.PASS, "Navigate to Hub Page");
		TestInitization.setApplicationHubPage(2);
		//Move to My Library
		reports.log(LogStatus.PASS, " Navigate to mijn bibliotheek Screen ");
		TestInitization.sendKeyMultipleTimes("LEFT",1,1000);
		TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
		reports.log(LogStatus.PASS, " mijn bibliotheek Screen getting displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		//Move to Planning
		reports.log(LogStatus.PASS, " Navigate to opnames Screen ");
		TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
		reports.log(LogStatus.PASS, " opnames Screen getting displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	}
	/**
	 * This function is used to delete all Single Recordings from Planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	public void deletePlannedSingleRecording() throws InterruptedException {
		boolean singleRecordingDelete = false;
		moveToPlannedRecordings();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		Integer totalRecordings = Integer.parseInt(totalRecordingID.getText());
		for(int i=0;i<totalRecordings;i++)
		{
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			if(focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase("SINGLE")){
				//Enter to Info Page
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				//Click on Delete
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS,"Expected - Should be in Info box to delete");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				singleRecordingDelete = true;
				break;
			}
			else{
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
		}	
		if (singleRecordingDelete)
		{
			driver.switchTo().frame(getCurrentFrameIndex());
			if (totalRecordings != Integer.parseInt(totalRecordingID.getText()))
			{
				reports.log(LogStatus.PASS,"Recording is deleted successfully and List getting updated accordingly. Total Recording Before Delete :-"+ totalRecordings + "Recordings after Delete :-" +totalRecordingID.getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			else
			{
				FailTestCase("Recording is not deleted. Total Recording Before Delete :-"+ totalRecordings + "Recordings after Delete :-" +totalRecordingID.getText());
			}
		}
		else
		{
			reports.log(LogStatus.PASS, "No Single Recordings present to delete");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		
	}
	/**
	 * This function is used to delete all Series Recordings from Planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	public void deletePlannedSeriesRecording() throws InterruptedException {
		boolean seriesRecordingDelete = false;
		moveToPlannedRecordings();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		Integer totalRecordings = Integer.parseInt(totalRecordingID.getText());
		for(int i=0;i<totalRecordings;i++)
		{
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			if(focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase("SERIES")){
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS,"Expected - Info box containing Series Recordings");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				List<WebElement> recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
				for(int j=0;j<recordingContentElementList.size();j++)
				{
					//Enter to Info Page
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					//Click on Delete
					driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.log(LogStatus.PASS,"Expected - Should be in Info box to delete");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 2000);
					
				}
				seriesRecordingDelete = true;
				break;
			}
			else{
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
		}
		if(seriesRecordingDelete)
		{
			driver.switchTo().frame(getCurrentFrameIndex());
			if (totalRecordings != Integer.parseInt(totalRecordingID.getText()))
			{
				reports.log(LogStatus.PASS,"Recording is deleted successfully and List getting updated accordingly. Total Recording Before Delete :-"+ totalRecordings + "Recordings after Delete :-" +totalRecordingID.getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			else
			{
				FailTestCase("Recording is not deleted. Total Recording Before Delete :-"+ totalRecordings + "Recordings after Delete :-" +totalRecordingID.getText());
			}
		}
		else
		{
			reports.log(LogStatus.PASS, "No Series Recordings present to delete");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		
	}
	/**
	 * This function is used to delete all Recordings from Planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	public void deleteAllRecordings() throws InterruptedException{
		moveToPlannedRecordings();
		List<WebElement> recordingContentElementList = null;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		Integer totalRecordings = 0;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		/*If there is no recordings under Scheduled Recording then first start recording for multiple episode and try again to deleteAll*/
		if (recordingContentElementList.size() == 0)
		{
			reports.log(LogStatus.PASS, "No Recordings present to delete");
			scheduleRecordingForFutureChannel("SINGLE", 3);
			deleteAllRecordings();
		}
		else
		{
			totalRecordings = Integer.parseInt(totalRecordingID.getText());
			for(int i=0;i<totalRecordings;i++)
			{
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				if(focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase("SINGLE"))
				{
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					//Click on Delete
					driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.log(LogStatus.PASS,"Expected - Should be in Info box to delete");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.log(LogStatus.PASS,"Recording Deleted Successfully");;
				}
				else{
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
					recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
					int noOfSeries = recordingContentElementList.size();
					for(int j=0;j<noOfSeries;j++)
					{
						reports.log(LogStatus.PASS,"Expected - Info box containing Series Recordings");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						//Enter to Info Page
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						//Click on Delete
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.log(LogStatus.PASS,"Expected - Should be in Info box to delete");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.log(LogStatus.PASS,"Recording Deleted Successfully");
					}
				}
				
			}
		}
	}
	/**
	 * This function is used to verify all recordings getting deleted from Planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	public boolean verifyAllRecordingsgDeleted() throws InterruptedException {
		moveToPlannedRecordings();
		List<WebElement> recordingContentElementList = null;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		String totalRecordings = totalRecordingID.getText();
		if((recordingContentElementList.size() == 0) && (Integer.parseInt(totalRecordings) == 0))
		{
			Assert.assertEquals(Integer.parseInt(totalRecordings), 0);
			Assert.assertEquals(recordingContentElementList.size(), 0);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This function is used to schedule recordings on future channel from EPG Screen.
	 * Created By Rahul Dhoundiyal
	 */

	public EpisodeInfo scheduleRecordingFromEPGScreen(String recordingType) throws InterruptedException {
		String epgEpisodeName = null;
		boolean stopRecording = false;
		//Navigate to EPG Screen
		EpisodeInfo episodeDetails = null;
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgChannelScreen(true);
		reports.log(LogStatus.PASS, "Navigate to Future Episodes");
		sendKeyMultipleTimes("RIGHT", 3, 1000);
		while(!stopRecording){
			
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			System.out.println(focusProgram.findElements(By.cssSelector(".epggroupicon img[src='./resources/common/images/ico_Future_recording.png']")).isEmpty());
			if (focusProgram.findElements(By.cssSelector(".epggroupicon img[src='./resources/common/images/ico_Future_recording.png']")).isEmpty())
			{
				epgEpisodeName = epgScreen.focusElemntInEpg.getText();
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS, "Open Info Screen of Future program");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				episodeDetails =  new EpisodeInfo(getChannelNo(), epgEpisodeName, getEpisodeDuration(),getChannelDefiniton());
				if (recordingType.equalsIgnoreCase("SINGLE"))
				{
					if (activeInfoMenuItem.getText().equalsIgnoreCase("opnemen"))
					{
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.log(LogStatus.PASS, "Click on opnemen to start recording");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						System.out.println(episodeDetails.toString() + episodeDetails.channelNo + episodeDetails.programDefiniton + episodeDetails.programDuration);
						stopRecording = true;
					}
					else
					{
						reports.log(LogStatus.PASS, "Already Recording is scheduled for current episode.Navigate to Future Epsiode");
						TestInitization.sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
						reports.attachScreenshot(captureCurrentScreenshot());
						TestInitization.sendKeyMultipleTimes("RIGHT", 1, 2000);
					}
				}
				else
				{
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
					if (activeInfoMenuItem.getText().equalsIgnoreCase("serie opnemen"))
					{
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.log(LogStatus.PASS, "Click on serie opnemen to start recording");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						System.out.println(episodeDetails.toString() + episodeDetails.channelNo + episodeDetails.programDefiniton + episodeDetails.programDuration);
						stopRecording = true;
					}
					else
					{
						TestInitization.sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
						TestInitization.sendKeyMultipleTimes("RIGHT", 1, 2000);
					}
					
				}
				
			}
			else
			{
				TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			}
			
		}
		return episodeDetails;
	}

	/**
	 * This function is used to verify on going recording scheduled or not.
	 * Created By Rahul Dhoundiyal
	 */
	public boolean verifyOnGoingRecording(EpisodeInfo episodeDetails,String recordingType) throws InterruptedException {
	boolean verifyRecording = false;
	moveToOngoingandCompletedRecordingList();
	driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
	int recordingSize = 15;
	for(int i = 0 ; i< recordingSize;i++)
	{
		
		if((focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
		{
			if (focusRecordingElement.findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
			&&
			focusRecordingElement.findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
			&&
			focusRecordingElement.findElements(By.cssSelector(".videoQuality .ongoing_recording img")).get(0).getAttribute("src").contains("ico_Ongoing_recording.png")
					)
			{
				verifyRecording = true;
				break;
			}
			else
			{
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
		}
		else
		{
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		}
	}
	return verifyRecording;	
	}
	/**
	 * This function is used to delete planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	public void stopAndVerifyOnGoingRecording() throws InterruptedException {
		boolean onGoingRecordingDeleted = false;
		moveToOngoingandCompletedRecordingList();
		driver.switchTo().frame(getCurrentFrameIndex());
		String recordingBeforeDelete = totalRecordingID.getText();
		System.out.println("Recording List Before Delete :" +recordingBeforeDelete);
		for (int i = 0; i< 15;i++)
		{	
			reports.attachScreenshot(captureCurrentScreenshot());
			System.out.println(focusRecordingElement.findElements(By.cssSelector(ObjectRepository.RecordingElements.ongoingRecordingIconElement)).size());
			if (focusRecordingElement.findElements(By.cssSelector(ObjectRepository.RecordingElements.ongoingRecordingIconElement)).size()>0){
					System.out.println(focusRecordingElement.getAttribute("assetvolume"));
					if (focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase("SINGLE"))
					{
						stopSingleRecording();
					}
					else
					{
						stopSeriesRecording();
					}
					onGoingRecordingDeleted = true;
					break;
			}
			else
			{
				reports.log(LogStatus.PASS, "Navigate to other recorded list item");
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			
		}
		
		if(onGoingRecordingDeleted)
		{
			driver.switchTo().frame(getCurrentFrameIndex());
			try
			{
				if (focusRecordingElement.findElement(By.className("ongoing_recording")).isDisplayed())
				{
					FailTestCase("Recording not Stopped");
				}
				else
				{
					reports.log(LogStatus.PASS, "On Going Recording getting stopped.");
					reports.attachScreenshot(captureCurrentScreenshot());
				}
			}
			catch(NoSuchElementException ex)
			{
				reports.log(LogStatus.PASS, "On Going Recording getting stopped.");
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		}
		else
		{
			reports.log(LogStatus.PASS, "No On Going Recordings Present");
			reports.attachScreenshot(captureCurrentScreenshot());
		}	
	}
	/**
	 * This function is used to delete ongoing and complete recordings
	 * Created By Rahul Dhoundiyal
	 */
	public void deleteAndVerifyRecordedItem() throws InterruptedException
	{
		boolean recordedItemDeleted = false;
		moveToOngoingandCompletedRecordingList();
		driver.switchTo().frame(getCurrentFrameIndex());
		String recordingBeforeDelete = totalRecordingID.getText();
		for (int i = 0; i< Integer.parseInt(recordingBeforeDelete);i++)
		{
			if (focusRecordingElement.findElements(By.cssSelector(ObjectRepository.RecordingElements.ongoingRecordingIconElement)).size()<=0){
					if (focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase("SINGLE"))
					{
						deleteSingleRecording();
					}
					else
					{
						deleteSeriesRecording();
					}
					recordedItemDeleted = true;
					break;
			}
			else
			{
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			
		}
		if(recordedItemDeleted)
		{
			driver.switchTo().frame(getCurrentFrameIndex());
			if (recordingBeforeDelete.equalsIgnoreCase(totalRecordingID.getText()))
			{
				FailTestCase("Recording not Delete. Recording List not getting updated Recordings Before Delete :- " + recordingBeforeDelete + " Recordings After Delete :- " +totalRecordingID.getText());
			}
			else
			{
				reports.log(LogStatus.PASS, "Recorded Item getiing deleted Recordings Before Delete :- " + recordingBeforeDelete + " Recordings After Delete :- " +totalRecordingID.getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			
		}
		else
		{
			reports.log(LogStatus.PASS, "No Recorded Items are Present");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}
	private void stopSeriesRecording() throws InterruptedException {
		sendKeyMultipleTimes("ENTER", 1, 2000);
		reports.log(LogStatus.PASS, "Info Box of recorded item should be displayed ");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 2000);
		sendKeyMultipleTimes("DOWN", 1, 2000);
		sendKeyMultipleTimes("DOWN", 1, 2000);
		reports.log(LogStatus.PASS, "Click on alle afleveringen wissen");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 2000);
		reports.log(LogStatus.PASS, "Click bevestigen");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		reports.log(LogStatus.PASS,"All Series Recording Deleted Successfully");
	
	}
	/**
	 * This function is used to delete single recording.
	 * Created By Rahul Dhoundiyal
	 */
	private void stopSingleRecording() throws InterruptedException
	{	
		sendKeyMultipleTimes("ENTER", 1, 2000);
		reports.log(LogStatus.PASS, "Info Box of recorded item should be displayed ");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("DOWN", 1, 2000);
		reports.log(LogStatus.PASS, "Click opname stoppen");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 2000);
		reports.log(LogStatus.PASS, "Click bevestigen");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 3000);
		reports.log(LogStatus.PASS,"Recording Stopped Successfully");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("PAGE_DOWN", 1, 3000);
		
		
	}
	private void deleteSingleRecording() throws InterruptedException
	{	
		sendKeyMultipleTimes("ENTER", 1, 2000);
		reports.log(LogStatus.PASS, "Info Box of recorded item should be displayed ");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("DOWN", 1, 2000);
		reports.log(LogStatus.PASS, "Click aflevering wissen");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 2000);
		reports.log(LogStatus.PASS, "Click bevestigen");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 3000);
		reports.log(LogStatus.PASS,"Recording Deleted Successfully");
	}
	/**
	 * This function is used to delete series recording.
	 * Created By Rahul Dhoundiyal
	 */
	private void deleteSeriesRecording() throws InterruptedException
	{
		
		sendKeyMultipleTimes("ENTER", 1, 2000);
		reports.log(LogStatus.PASS, "Info Box of recorded item should be displayed ");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 2000);
		sendKeyMultipleTimes("DOWN", 1, 2000);
		sendKeyMultipleTimes("DOWN", 1, 2000);
		reports.log(LogStatus.PASS, "Click on alle afleveringen wissen");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 2000);
		reports.log(LogStatus.PASS, "Click bevestigen");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		reports.log(LogStatus.PASS,"All Series Recording Deleted Successfully");
	}
	
	/**
	 * This function is used to delete series recording one by one
	 * Created By Rahul Dhoundiyal
	 */
	public void deleteSeriesRecordingOneByOne() throws InterruptedException{
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<WebElement> recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		int noOfSeries = recordingContentElementList.size();
		for(int j=0;j<noOfSeries;j++)
		{
			reports.log(LogStatus.PASS,"Expected - Info box containing Series Recordings");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			//Enter to Info Page
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
			//Click on Delete
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			sendKeyMultipleTimes("DOWN", 1, 1000);
			sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.log(LogStatus.PASS,"Expected - Should be in Info box to delete");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 3000);
			reports.log(LogStatus.PASS,"Recording Deleted Successfully");
		}
	}
	/**
	 * This function is used to schedule and verify recording on future episode.
	 * Created By Rahul Dhoundiyal
	 */
	public void verifyAndScheduleRecordingForFutureEpisode() throws InterruptedException {
		reports.log(LogStatus.PASS, "Schedule Recording for future episode");
		List<EpisodeInfo> listOfAddedRecordings = scheduleRecordingForFutureChannel("SINGLE",1);
		System.out.println(listOfAddedRecordings);
		for (EpisodeInfo epsiodeInfo : listOfAddedRecordings) {
			boolean verifyMultipleSingleRecordings = verifyRecordingIsScheduledOrNot(epsiodeInfo,"SINGLE");		
			if (verifyMultipleSingleRecordings)
			{
				reports.log(LogStatus.PASS, "Expected Output - Recording should be scheduled for " +epsiodeInfo.programName+ " Actual - Recording getting scheduled for " + epsiodeInfo.programName);
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			else
			{
				FailTestCase("Expected Output - Recording should be scheduled for " +epsiodeInfo.programName+ " Actual - Recording not getting scheduled for " + epsiodeInfo.programName);
			}
		}
	}
	/**
	 * This function is used to start and verify recording on current episode.
	 * Created By Rahul Dhoundiyal
	 */
	public void verifyAndStartRecordingForCurrentEpisode() throws InterruptedException {
		reports.log(LogStatus.PASS, "Start Recording for current episode");
		EpisodeInfo episodeDetails = startRecordingFromEPGScreen("SINGLE");
		System.out.println(episodeDetails.toString());
		boolean verifyOnGoingRecording = verifyOnGoingRecording(episodeDetails,"SINGLE");
		if (verifyOnGoingRecording)
		{	
			reports.log(LogStatus.PASS, "Expected Output - Recording should be Started for " +episodeDetails.programName+ " Actual - Recording getting started for " + episodeDetails.programName);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Expected Output - Recording should be started for " +episodeDetails.programName+ " Actual - Recording not getting started for " + episodeDetails.programName);
		}
	}
	/**
	 * This function is used to navigate to Menu screen.
	 * Created By Rahul Dhoundiyal
	 */
	public void verifyNavigationToMenuScreen() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to Menu");
		new Hub(driver).launchAndVerifyMenuScreen();
	}
	/**
	 * This function is used to navigate to Shop screen.
	 * Created By Rahul Dhoundiyal
	 */
	public void verifyNavigationToShopScreen() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to Shop Screen ");
		setApplicationHubPage(1);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().defaultContent();
		if(headerElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Shop", "name_nl")))
		{
			reports.log(LogStatus.PASS, "Navigation to Shop is Smooth. Navigated to Guide successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else{
			FailTestCase("Navigation to Shop is not smooth.Not navigated to Shop");
		}		
	}

	/**
	 * This function is used to navigate to settings screen.
	 * Created By Rahul Dhoundiyal
	 */
	public void verifyNavigationToSettingScreen() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to Settings Screen");
		setApplicationHubPage(1);
		TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000,
		TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));
		driver.switchTo().defaultContent();
		if(headerElement.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Setting", "name_nl")))
		{
			reports.log(LogStatus.PASS, "Navigation to Settings is Smooth. Navigated to Guide successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else{
			FailTestCase("Navigation to Settings is not smooth.Not navigated to Settings");
		}		
	}
	
	/**
	 * This function is used to navigate to tv guide screen.
	 * Created By Rahul Dhoundiyal
	 */
	public void verifyNavigationToTVGuideScreen() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to TV-Guide EPG Screen");
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgChannelScreen(true);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(EpgGuide, "TV_Guide");	
	}
	/**
	 * This function is used to start recordings on current episode from DTV Screen
	 * Created By Rahul Dhoundiyal
	 */
	public List<EpisodeInfo> startRecordingFromDTV(String recordingType,int numberOfRecording) throws InterruptedException, IOException {
		boolean checknext = false;
		String episodeName = null;
		int noOfRecordedChannel = 0;
		List<EpisodeInfo> programDetails = new ArrayList<EpisodeInfo>();
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		while(numberOfRecording != noOfRecordedChannel){
			driver.switchTo().defaultContent();
			if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl")))
			{
				dtvChannelScreen.openLiveTV();
			}
			if(numberOfRecording > 1 && checknext){
				reports.log(LogStatus.PASS, "Navigate to another channel to start recording");
				sendKeyMultipleTimes("PAGE_UP", 1, 2000);
				sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			if(recordingType.equalsIgnoreCase("SINGLE")){
				//Enter to open Episode Info
				TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
				driver.switchTo().frame(getCurrentFrameIndex());
				episodeName = dtvChannelScreen.programTitle.getText();
				System.out.println(episodeName);
				sendKeyMultipleTimes("ENTER", 1, 3000);
				reports.log(LogStatus.PASS, " Episode Info Screen getting displayed ");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				sendKeyMultipleTimes("DOWN", 1, 1000);
				if (activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")){
					programDetails.add(new EpisodeInfo(getChannelNo(), episodeName, getEpisodeDuration(),getChannelDefiniton()));
					reports.log(LogStatus.PASS, " Click on opnemen to start recording on - "+ getInfoEpisodeName());
					sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.attachScreenshot(captureCurrentScreenshot());
					checknext = true;
					noOfRecordedChannel += 1;
				}
				else if (activeInfoMenuItem.getText().equalsIgnoreCase("herstarten"))
				{
					sendKeyMultipleTimes("DOWN", 1, 2000);
					if (activeInfoMenuItem.getText().equalsIgnoreCase("opnemen"))
					{
						programDetails.add(new EpisodeInfo(getChannelNo(), episodeName, getEpisodeDuration(),getChannelDefiniton()));
						reports.log(LogStatus.PASS, " Click on opnemen to start recording on - "+getInfoEpisodeName());
						sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.attachScreenshot(captureCurrentScreenshot());
						checknext = true;
						noOfRecordedChannel += 1;
					}
					else
					{
						reports.log(LogStatus.PASS, " Already recording is scheduled on  " + getInfoEpisodeName() + " epsiode. Unable to record this episode");
						reports.attachScreenshot(captureCurrentScreenshot());
						sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
						//sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 1000);
						sendKeyMultipleTimes("PAGE_UP", 1, 1000);
						reports.log(LogStatus.PASS," Going back and Navigate to another Channel");
						sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
						reports.attachScreenshot(captureCurrentScreenshot());
					}
				}
				else 
				{	reports.log(LogStatus.PASS, " Already recording is scheduled on  " + getInfoEpisodeName() + " epsiode. Unable to record this episode");
				reports.attachScreenshot(captureCurrentScreenshot());
				sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
				//sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 1000);
				sendKeyMultipleTimes("PAGE_UP", 1, 1000);
				reports.log(LogStatus.PASS," Going back and Navigate to another Channel");
				sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
				reports.attachScreenshot(captureCurrentScreenshot());
				}
			}
			else
			{
				programDetails.add(new EpisodeInfo(getChannelNo(), episodeName, getEpisodeDuration(),getChannelDefiniton()));
				sendKeyMultipleTimes("DOWN", 1, 1000);
				sendKeyMultipleTimes("ENTER", 1, 1000);
				driver.switchTo().defaultContent();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='headerTitle']")));
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				checknext = true;
				noOfRecordedChannel += 1;
			}	
		}
		return programDetails;
	}
	
	public void verifyAndStartRecordingFromDTV() throws InterruptedException, IOException {
		reports.log(LogStatus.PASS, "Start Recording From DTV");
		List<EpisodeInfo> listOfAddedRecordings = startRecordingFromDTV("SINGLE",1);
		System.out.println(listOfAddedRecordings);
		for (EpisodeInfo epsiodeInfo : listOfAddedRecordings) {
			boolean verifyMultipleSingleRecordings = verifyOnGoingRecording(epsiodeInfo,"SINGLE");		
			if (verifyMultipleSingleRecordings)
			{
				reports.log(LogStatus.PASS, "Expected Output - Recording should be scheduled for " +epsiodeInfo.programName+ " Actual - Recording getting scheduled for " + epsiodeInfo.programName);
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			else
			{
				FailTestCase("Expected Output - Recording should be scheduled for " +epsiodeInfo.programName+ " Actual - Recording not getting scheduled for " + epsiodeInfo.programName);
			}
		}	
	}
	
	public void verifyActionMenuRecordinStop() throws InterruptedException, IOException {
		reports.log(LogStatus.PASS, "Pre-requisite Start Recording on Going Channel To Test.");
		List<EpisodeInfo> listOfAddedRecordings = startRecordingFromDTV("SINGLE",1);
		new DTVChannelScreen(driver).openLiveTV();
		Thread.sleep(1000);
		reports.log(LogStatus.PASS, "Navigate to Channel with ongoing recording : "+ listOfAddedRecordings.get(0).channelNo);
		sendNumaricKeys(Integer.parseInt(listOfAddedRecordings.get(0).channelNo));
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
		Thread.sleep(1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS, "Info Box getting displayed with Episode Info - Click on opname stoppen");
		sendKeyMultipleTimes("DOWN", 1, 1000);
		/*driver.switchTo().frame(getCurrentFrameIndex());
		if(activeInfoMenuItem.getText().equalsIgnoreCase("herstarten"))
		{
			sendKeyMultipleTimes("DOWN", 1, 1000);
		}*/
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if(driver.findElement(By.className("vodText")).getText().contains("stopzetten?")){
			reports.log(LogStatus.PASS, "Message getting displayed to stop recording " + driver.findElement(By.className("vodText")).getText() );
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS, "Click on Cancel");
		sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if(!driver.findElement(By.className("vodText")).getText().contains("stopzetten?")){
			isDisplayed(driver.findElement(By.xpath(ObjectRepository.RecordingElements.recordingIconElement)),"Recording Icon");
			reports.log(LogStatus.PASS, "Stop recording Message not getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS, "Info Box getting displayed with Episode Info - Click on opname stoppen");
		sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if(driver.findElement(By.className("vodText")).getText().contains("stopzetten?")){
			reports.log(LogStatus.PASS, "Message getting displayed to stop recording " + driver.findElement(By.className("vodText")).getText() );
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS, "Click on Confirm to stop recording");
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if(!driver.findElement(By.className("vodText")).getText().contains("stopzetten?")){
			try{
				if (recordingIconElement.isDisplayed())
				{
					FailTestCase("Recording Icon should not be displayed");
				}
				else
				{
					reports.log(LogStatus.PASS, "Recording Icon not displayed.Rcording Stopped Sucessfully");
					reports.attachScreenshot(captureCurrentScreenshot());
				}
			}
			catch(NoSuchElementException ex){
				reports.log(LogStatus.PASS, "Recording Icon not displayed.Rcording Stopped Sucessfully");
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			
			reports.log(LogStatus.PASS, "Stop Recording Message not getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}
	public void verifyAndPlanOverlappingRecordings(int numberOfRecording) throws InterruptedException, ParseException {
		List<EpisodeInfo> episodeDetails = scheduleOverlappingRecording(numberOfRecording);
		for (EpisodeInfo epsiodeInfo : episodeDetails){
			boolean verifyMultipleSingleRecordings = verifyRecordingIsScheduledOrNot(epsiodeInfo,"SINGLE");		
			if (verifyMultipleSingleRecordings)
			{
				reports.log(LogStatus.PASS, "Expected Output - Recording should be scheduled for " +epsiodeInfo.programName+ " Actual - Recording getting scheduled for " + epsiodeInfo.programName);
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			else
			{
				FailTestCase("Expected Output - Recording should be scheduled for " +epsiodeInfo.programName+ " Actual - Recording not getting scheduled for " + epsiodeInfo.programName);
			}
		}
	}
	private List<EpisodeInfo> scheduleOverlappingRecording(int numberOfRecording) throws ParseException, InterruptedException {
		int maxCount = 15;
		int recordedChannel = 0;
		String prevEpisodeDuration = null;
		String epgEpisodeName = null;
		DateFormat sdf=new SimpleDateFormat("hh:mm");
		Date prevStartTime = sdf.parse("00:00");
		Date prevEndTime = sdf.parse("00:00");
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgChannelScreen(true);
		sendNumaricKeys(1);
		Thread.sleep(1000);
		List<EpisodeInfo> episodeDetails = new ArrayList<EpisodeInfo>();
		boolean checkOverLap = false;
		//move to future episode
		sendKeyMultipleTimes("RIGHT", 3, 1000);
		while(numberOfRecording != recordedChannel )
		{
			if(maxCount == 0)
			{
				reports.log(LogStatus.PASS, "No Overlapping Epsiode Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				break;
			}
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			System.out.println(focusProgram.findElements(By.cssSelector(ObjectRepository.RecordingElements.futureRecordingIconElement)).isEmpty());
			if (focusProgram.findElements(By.cssSelector(ObjectRepository.RecordingElements.futureRecordingIconElement)).isEmpty())
			{
				if(checkOverLap)
				{
					driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
					if(!isOverlapping(prevStartTime, prevEndTime, sdf.parse(epgScreen.focusElementProgramTime.getText().split(" ")[0].trim()),sdf.parse(epgScreen.focusElementProgramTime.getText().split(" ")[2].trim())))
					{
						if (prevEndTime.before(sdf.parse(epgScreen.focusElementProgramTime.getText().split(" ")[2].trim())) || prevEndTime.before(sdf.parse(epgScreen.focusElementProgramTime.getText().split(" ")[0].trim())))
						{
							reports.log(LogStatus.PASS, "Overlapping Episode Not Found Prev Episode Timing - "+ prevEpisodeDuration + "Current Episode Timing :-" +epgScreen.focusElementProgramTime.getText() );
							sendKeyMultipleTimes("RIGHT", 1, 1000);
							maxCount -=1;
							continue;
						}
						else
						{
							reports.log(LogStatus.PASS, "Overlapping Episode Not Found Prev Episode Timing - "+ prevEpisodeDuration + "Current Episode Timing :-" +epgScreen.focusElementProgramTime.getText() );
							sendKeyMultipleTimes("DOWN", 1, 1000);
							maxCount -=1;
							continue;
						}
						
					}
					else
					{
						reports.log(LogStatus.PASS, "Overlapping Episode Found Prev Episode Timing - "+ prevEpisodeDuration + "Current Episode Timing :-" +epgScreen.focusElementProgramTime.getText() );	
					}
				}
				prevStartTime = sdf.parse(epgScreen.focusElementProgramTime.getText().split(" ")[0].trim());
				prevEndTime = sdf.parse(epgScreen.focusElementProgramTime.getText().split(" ")[0].trim());
				epgEpisodeName = epgScreen.focusElemntInEpg.getText();
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				
				reports.log(LogStatus.PASS, "Open Info Screen of Future program");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				String recordingType = "SINGLE";
				if (recordingType.equalsIgnoreCase("SINGLE"))
				{
					if (activeInfoMenuItem.getText().equalsIgnoreCase("opnemen"))
					{
						episodeDetails.add(new EpisodeInfo(getChannelNo(), epgEpisodeName, getEpisodeDuration(),getChannelDefiniton()));
						prevEpisodeDuration = getEpisodeDuration();
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.log(LogStatus.PASS, "Click on opnemen to start recording - Episode TIme - " +prevEpisodeDuration);
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						recordedChannel += 1;
						checkOverLap = true;
					}
					else if (activeInfoMenuItem.getText().equalsIgnoreCase("herstarten"))
					{
						sendKeyMultipleTimes("DOWN", 1, 2000);
						if (activeInfoMenuItem.getText().equalsIgnoreCase("opnemen"))
						{
							episodeDetails.add(new EpisodeInfo(getChannelNo(), epgEpisodeName , getEpisodeDuration(),getChannelDefiniton()));
							prevEpisodeDuration = getEpisodeDuration();
							TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
							reports.log(LogStatus.PASS, "Click on opnemen to start recording - Episode TIme - "+prevEpisodeDuration);
							reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
							driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
							recordedChannel += 1;
							checkOverLap = true;
						}
						else
						{
							reports.log(LogStatus.PASS, "Already Recording is scheduled for current episode.Navigate to Future Epsiode");
							TestInitization.sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
							reports.attachScreenshot(captureCurrentScreenshot());
							TestInitization.sendKeyMultipleTimes("RIGHT", 1, 2000);
						}
					}
					else
					{
						reports.log(LogStatus.PASS, "Already Recording is scheduled for current episode.Navigate to Future Epsiode");
						TestInitization.sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
						reports.attachScreenshot(captureCurrentScreenshot());
						TestInitization.sendKeyMultipleTimes("RIGHT", 1, 2000);
					}
				}
				else
				{
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
					if (activeInfoMenuItem.getText().equalsIgnoreCase("serie opnemen"))
					{
						episodeDetails.add(new EpisodeInfo(getChannelNo(), getInfoEpisodeName(), getEpisodeDuration(),getChannelDefiniton()));
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.log(LogStatus.PASS, "Click on serie opnemen to start recording");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						recordedChannel += 1;
					}
					else
					{
						TestInitization.sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
						TestInitization.sendKeyMultipleTimes("RIGHT", 1, 2000);
					}
					
				}
				
			}
			else
			{
				TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
				continue;
			}
			sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		return episodeDetails;
		
	}
	public boolean isOverlapping(Date startDate1, Date endDate1, Date startDate2, Date endDate2)
		      throws NullPointerException {
		 if ((startDate1.before(startDate2) && endDate1.after(startDate2))
			        || (startDate1.before(endDate2) && endDate1.after(endDate2))
			        || (startDate1.before(startDate2) && endDate1.after(endDate2))
			        || (startDate1.equals(startDate2) && endDate1.equals(endDate2))
			        || (startDate2.before(startDate1) && endDate1.equals(endDate2))
			        || (startDate2.before(startDate1) && endDate1.before(endDate2))
			        || (startDate2.before(startDate1) && endDate1.after(endDate2))) {
			      return true;
			    }
			    return false;
	}
}