package com.rsystems.test;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.RecordingScreen;
import com.rsystems.pages.RecordingScreen.EpisodeInfo;
import com.rsystems.utils.TestInitization;
public class RecordingTestCase extends TestInitization {

	List<EpisodeInfo> episodeDetails = null;
	/**
	 * This test cases is used to verify navigation under planned recordings in Library Section
	 * Created By Rahul Dhoundiyal
	 */
	
	@Test
	public void tc_BCDTVCP1430_nPVR_Planner_Navigation() throws InterruptedException
	{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		boolean verifyNavigation = recordingScreen.verifyNavigationInPlannedRecording();
		if(verifyNavigation){
			reports.log(LogStatus.PASS, " Naivgation is properly for scheduled recordings ");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase(" Navigation is not properly for scheduled recordings ");
		}
	}
	/**
	 * This test cases is used to verify navigation under on going and completed recordings in Library Section
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_BCDTVCP1429_nPVR_Library_Navigation() throws InterruptedException
	{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		boolean verifyNavigation = recordingScreen.verifyNavigationInRecordedList();
		if(verifyNavigation){
			reports.log(LogStatus.PASS, " Naivgation is properly for scheduled recordings ");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase(" Navigation is not properly for on going and completed recordings ");
		}
	}
	/**
	 * This test cases is used to verify navigation to different screens when recording is scheduled and start for episodes
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_BCDTVCP1419_navigation_with_recordings() throws InterruptedException{
		//Plan recording for 2 channels
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		// Schedule Recording for Future Channel
		recordingScreen.verifyAndScheduleRecordingForFutureEpisode();
		//Start Recording for Current Episode
		recordingScreen.verifyAndStartRecordingForCurrentEpisode();
		//Verify Navigation To Menu Screen
		recordingScreen.verifyNavigationToMenuScreen();
		//Verify Navigation To Shop Screen
		recordingScreen.verifyNavigationToShopScreen();
		//Verify Navigation To Setting Screen
		recordingScreen.verifyNavigationToSettingScreen();
		//Verify Navigation To TV Guide Screen
		recordingScreen.verifyNavigationToTVGuideScreen();	
	}

	/**
	 * This test cases is used to delete single and series recording from planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_BCDTVCP1451_Planned_nPVR_Delete() throws InterruptedException
	{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		recordingScreen.deletePlannedSingleRecording();
		recordingScreen.deletePlannedSeriesRecording();
	}
	
	/**
	 * This test cases is used to schedule recording from EPG Screen
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_BCDTVCP1423_nPVR_Schedule_EPG() throws InterruptedException
	{
		
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		EpisodeInfo episodeDetails = recordingScreen.scheduleRecordingFromEPGScreen("SINGLE");
		boolean verifyOnGoingRecording = recordingScreen.verifyRecordingIsScheduledOrNot(episodeDetails,"SINGLE");
		if (verifyOnGoingRecording)
		{	
			reports.log(LogStatus.PASS, "Expected Output - Recording should be scheduled for " +episodeDetails.programName+ " Actual - Recoring getting started for " + episodeDetails.programName);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Expected Output - Recording should be scheduled for " +episodeDetails.programName+ " Actual - Recoring not getting started for " + episodeDetails.programName);
		}
	}
	/***
	 * This test cases is used to start recording from different possible situation like from EPG Screen ,From Live TV
	 * Created By Rahul Dhoundiyal
	 * @throws IOException 
	 */
	@Test
	public void tc_BCDTVCP1406_Perform_Instant_nPVR_Recording() throws InterruptedException, IOException
	{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		// Start Recording from EPG Screen
		recordingScreen.verifyAndStartRecordingForCurrentEpisode();
		// Start Recording while watching TV
		recordingScreen.verifyAndStartRecordingFromDTV();
	}
	/***
	 * This test cases is used to schedule recording for bunch of episodes
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_BCDTVCP1407_nPVR_Planned_To_Record() throws InterruptedException
	{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		reports.log(LogStatus.PASS,"Start Recording for "+ getExcelKeyValue("Recording", "No_Of_Recording", "name_nl") +" future episodes");
		List<EpisodeInfo> listOfAddedRecordings = recordingScreen.scheduleRecordingForFutureChannel("SINGLE",Integer.parseInt(getExcelKeyValue("Recording", "No_Of_Recording", "name_nl")));
		for (EpisodeInfo epsiodeInfo : listOfAddedRecordings) {
			boolean verifyMultipleSingleRecordings = recordingScreen.verifyRecordingIsScheduledOrNot(epsiodeInfo,"SINGLE");		
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
	/***
	 * This test cases is used to stop and delete on going and completed recording.
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_BCDTVCP1448_Recorded_nPVR_Delete() throws InterruptedException{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		recordingScreen.stopAndVerifyOnGoingRecording();
		recordingScreen.deleteAndVerifyRecordedItem();
	}
	
	/**
	 * This test cases is used to stop recording from Action menu Item
	 * @throws IOException 
	 */
	
	@Test
	public void tc_BCDTVCP1414_Stop_nPVR_Recording_Action_Menu() throws InterruptedException, IOException{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		recordingScreen.verifyActionMenuRecordinStop();
	}
	/**
	 * This test cases is used to schedule recordings on overlapping programs
	 * @throws IOException 
	 */
	
	@Test
	public void tc_BCDTVCP1409_No_Conflict_Between_nPVR_Planned_Recordings() throws InterruptedException, ParseException{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		recordingScreen.verifyAndPlanOverlappingRecordings(2);
	}
}