package com.rsystems.utils;

public class ProximusContext {

	static String currentLanguage = "NL";
	
	public static void setLanguage( String language){
		
		currentLanguage = language;
	}
	
	public static String getCurrentLanguage(){
		
		return currentLanguage;
	}
}
