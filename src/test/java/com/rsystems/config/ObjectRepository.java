package com.rsystems.config;

public class ObjectRepository {

	public static final String excelFilePath = System.getProperty("user.dir")
			+ "/src/test/java/com/rsystems/config/testdata.xlsx";

	/*-----------------HUB Menu Item Locators------------------------*/

	public static final String HubTVItem = "//li[@id='menuItem_1']";
	public static final String HubLibraryItem = "//li[@id='menuItem_0']";
	public static final String HubStoreItem = "//li[@id='menuItem_2']";
	public static final String HubSearchItem = "//li[@id='menuItem_3']";
	public static final String HubSettingsItem = "//li[@id='menuItem_4']";
	public static final String[] HubMenuItemsNL = { "mijn bibliotheek", "televisie", "shop", "search_normal1.png",
			"setting_normal.png" };
	public static final String[] HubMenuItemsNLFocused = { "mijn bibliotheek", "televisie", "shop",
			"search_active_bold.png", "setting_active_bold.png" };
	public static final String[] HubMenuItemsFocused = { "mijn bibliotheek", "televisie", "shop", "Search", "Setting" };
	public static final String[] Test2 = { "mijn bibliotheek", "televisie", "shop", "search_active_bold.png",
			"setting_active_bold.png" };

	public static class EpgSettingScreen {
		public static final String epgType = "epgType";
		public static final String epgBackground = "epgBackground";
		public static final String epgFont = "epgFont";
		public static final String screenBackgroundColor = "//link[@href = './resources/components/epg_custom/css/parentgreen.css']";
		public static final String cancelButton = "item_4";
		public static final String confirmButton = "item_3";
	}

	public static class EpgScreen {
		public static final String focousElement = "//li[@class = 'program focusProgram']/div/p[@class='programTitle']";
		public static final String displayChannelTitle = "title";
		public static final String displayChannelDescription = "vodText";
		public static final String displayChannelprogressbar = "progress";
		public static final String displayChannelStartTime = "startDate";
		public static final String displayChannelEndTime = "endDate";
		public static final String displayChannelCallLetterIcon = "//li[@class='focusedChannel']/div[@class='ch_logo']/span/img";
		public static final String cutvIcon = "//span[@class='channel-cutv']";
		public static final String focousElementProrgamImg = "//li[@class='program focusProgram']/div/span[@class='programLogo']/img";
		public static final String diplayChannelDescImg = "//div[@class='poster']/img";
		public static final String focusElementProgramTiminig = "//li[@class = 'program focusProgram']/div/p[@class='programTiming']";
	}

	public static class LibraryElements {
		public static final String libraryMenuItemsXPath = "//li[contains(@class,'enable')]";
		public static final String libraryCanvas="//*[@id='dCanvasUpLine']";
	}

	public static class PIPElements {
		public static final String pipPositonIDElement = "pipPosition";
		public static final String currentPIPClassElement = "//*[@class='logo-wrapper toggle']	";
		public static final String pipHeadingElement = "pipHeading";
		public static final String confirmElement = "//*[@id='item_1']";
		public static final String cancelElement = "//*[@id='item_2']";
	}

	public static class RecordingElements {
		
		public static final String InfoEpisodeNameXPath = "program-title";
		public static final String ChannelNoClassName = "channel-no";
		public static final String ChannelInfoImageXPath = "/html/body/div/div[2]/div[1]/div/div/div[1]/span/img";
		public static final String EpisodeDurationXPath = "/html/body/div/div[2]/div[1]/div/div/div[3]/div[2]";
		public static final String ProgramDefinitionXPath = "/html/body/div/div[2]/div[1]/div/div/div[3]/div[1]/img";
		public static final String RecordingListCSSSelector = "#recordingContent div[id^='item']";
		public static final String ChannelNoInPlannedRecording = "recordingNumber";
		public static final String ChannelLogoInPlannedRecording = ".logo";
		public static final String ProgramNameInPlannedRecording = ".recordingDetails h2";
		public static final String ProgramDurationInPlannedRecording = ".recordingDetails .duration";
		public static final String ProgramDefinitionInPlannedRecording = ".hd_quality img";
		public static final String StartRecordingXPath = "//*[@id='item_1']";
		public static final String currentRecordingCountID = "countNumbers";
		public static final String totalRecordingsID = "totalItems";
		public static final String focusRecordingElementXPath = "//div[@class='recordingList fillGradient']";
		public static final String focusProgramCalssName = "focusProgram";
		public static final String activeMenuItemElement = "cActiveItem";
		public static final String ongoingRecordingIconElement = ".videoQuality .ongoing_recording img";
		public static final String plannedRecordingTitleElement = "sTitlebar";
		public static final String epgGuideElement = "epgGuide";
		public static final String futureRecordingIconElement = ".epggroupicon img[src='./resources/common/images/ico_Future_recording.png']";
		public static final String recordingIconElement = "//*[@id='recording']";
	}

	public static class VerifySystemInfoScreen {
		public static final String systemInfoXpath = "//div[@id='settingInfoHeading']";
		public static final String hardwareVersion = "hardware_version";
		public static final String softwareVersion = "software_version";
		public static final String hpgVersion = "hpg_version";
		public static final String serialNumber = "serial_number";
	}

	public static class FilmsScreen {
		public static final String highlighedMovieCategory = "//li[@class='focusedItem current']/span";
		public static final String currentSelectedMovieName = "selectedVodTitle";
		public static final String rentOption = "item_rent";
		
	}

	public static class LanguageChange {
		public static final String position = "pipPosition";
		public static final String menuItem = "leftLabel";
		public static final String confirm = "item_1";
		public static final String itemHeading = "item_1";
		public static final String heading = "settingHeading";
		public static final String languagedumenu = "item_0";

	}

	public static class DtvChannel {
		public static final String chnlNoIn_Infobar = "current_channel";
		public static final String programDurationIn_Infobar = "programTime";
		public static final String programTitle = "programTitle";
		public static final String hdIcon = "programHD";
		public static final String channelLogo = "current_channel_logo";
		public static final String pauseAndPlayImg = "//li[@id='play_pause']/div/img";
		public static final String backToLive = "//div[@id='containerDiv']/div[text()='Terug naar leven']";
		public static final String rewindBtn = "rewind";
		public static final String errorMsg = "error-message";
		
	}

	public static class ZapListPage {

		public static final String screenTitle = "//p[@id='headerTitle']";
		public static final String focousChannelNumber = "//div[@class='focusBox']/ul/li[2]/div[@class='channel_details']/div/span";

	}

	public static class HubScreen {
		public static final String headerElement = "//*[@id='headerTitle']";
		public static final String upCanvasLineElement = "dCanvasUpLine";
		public static final String downCanvasLineElement = "dCanvasDownLine";
		public static final String libraryItemsElement = "//li[contains(@id,'item_m0')]";
		public static final String shopItemsElement = "//li[contains(@id,'item_m2')]";
		public static final String hubSearchElement = "//*[@id='dItemImage_30']/span";
		public static final String hubSettingElement = "//*[@id='dItemImage_40']/span";
		public static final String hubFocusElement = "cActiveMenuItem";
	}

	public static class MiniEPGScreen {
		public static final String headerTimeElement = "headerDateTime";
		public static final String currentEpisodeElement = "current";
		public static final String activeZapBlockElement = "active";
	}

	public static class Vod {
		public static final String vodHeading = "vod-heading-main";
		public static final String filmTitle = "poster-right-heading";
		public static final String itemPrice="//*[@id='price-text']";
		public static final String rowId="row_1";
		public static final String menuText="//*[@id='main-hub-nav']";
		public static final String actie="//*[@id='item_3']";
		public static final String mubiPass="//*[@id='item_4']";
		public static final String rows="row-active";
		public static final String pinContainer="//*[@id='addPin']/div";
		public static final String count="selectedVodPg";
		public static final String container="focusedItemContainer";
		public static final String forwardkey="//*[@id='rewind']";
		public static final String movieName="//div[contains(@id,'item_')]/div[@class='poster-info']/h2";
		public static final String dateTime="//*[@id='item_0_0']/div[2]/div";
		public static final String duration="//*[@id='item_0_0']/div[2]/span";
		public static final String totalItems="//*[@id='totalItems']";
		public static final String lookOption="//*[@id='item_watch']";
	}

	public static class HotKeys {
		public static final String currentChannel = "channel-no";
		public static final String channelLogo = "channel-logo";
		public static final String headerTitle = "//*[@id='headerTitle']";
		public static final String headerTime = "headerDateTime";
	}

	public static class RcArrowKey {
		public static final String heading = "epgHeading";
		public static final String type = "leftLabel";
		public static final String epgInfo = "epgType";
		public static final String background = "epgBackground";
		public static final String Id = "row_1";

	}

	public static class TvfilterLayer {
		public static final String televiosntitle = "menuItem_1";
		public static final String tvId = "//*[@id='VH_0']/span";
		public static final String now = "//*[@id='item_0_1']/span";
		public static final String nowOnTv = "//*[@id='VH_1']/span";
		public static final String footballTv = "//*[@id='VH_2']/span";
		public static final String footballCalendar = "//*[@id='VH_3']/span";
		public static final String radioStations = "//*[@id='VH_4']/span";
		public static final String search = "//*[@id='VH_5']/span";
	}
	   public static class ActiveInfoBanner
	   {
		   public static final String channelInfo="current_channel";
		   public static final String imgId="icon-active-preview";
		   public static final String programID="programTitle";
		   public static final String duration="programTime";
		   
	   }
	   public static class StoreFilterLayer
		{
			public static final String dramaScreenDetails="//div[contains(@id,'vodDetail')]"; 
			public static final String shopScreen="//li[@id='VH_0']/span";
			public static final String screenID="suggesties";	
			public static final String dramaScreen="cTitleField";
		}	
	   
	
}
