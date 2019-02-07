package com.rsystems.utils;

public enum Unicode {

	
	TV_GUIDE										 			("\uE04A"),
	VK_DOWN											  			("\uE015"),
	VK_STOP_RECORDING								 			("\uE040"),
	VK_ADD_RECORDING								  			("\uE041"),
	VK_PLAY											  			("\uE042"),
	VK_RADIO										  			("\uE046"),
	VK_DELETE_RECORDING								  			("\uE049"),
	VK_TVGUIDE										 			("\uE04A"),
	VK_ENTER										  			("\uE04B"),
	VK_PAGE_DOWN_OR_BACK									  	("\uE04C"),
	VK_PAGE_UP_OR_CHANNEL_PLUS									("\uE053"),
	VK_CHANNEL_MINUS								  			("\uE054"),
	VK_TV											  			("\uE055"),
	VK_MENU											  			("\uE056"),
	VK_ONDEMAND										  			("\uE057"),
	VK_PAUSE										  			("\uE058"),
	VK_FORWARD										  			("\uE059"),
	VK_BACKWARD										 			("\uE05A"),
	VK_PVR											  			("\uE05D"),
	VK_INFO											  			("\uE05E");
	
	private final String unicode;

	private Unicode(String unicode) {
		this.unicode = unicode;
	}

	 @Override
	    public String toString() {
	        return unicode;
	    }
}
