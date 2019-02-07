package com.rsystems.utils;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;


public class DataProviders extends TestInitization {

	
	@DataProvider
	public Object[][] getExcelDataProvider()
	{
		
		String sheetName = "testdata";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][1];
		Hashtable<String, String> table = null;
		
		for(int rowNum=2; rowNum<=rows; rowNum++)
		{
			table = new Hashtable<String,String>();
			
			
			for(int colNum=0; colNum<cols; colNum++)
			{
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum-2][0]=table;
				
				
				
				
			}
			
			
		}
		
		
		return data;
		
		}
	
	
}
