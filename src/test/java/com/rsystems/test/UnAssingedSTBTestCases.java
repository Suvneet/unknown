package com.rsystems.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.rsystems.utils.TestInitization;

public class UnAssingedSTBTestCases extends TestInitization {

	/**
	 * 
	 * 
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 * @throws FileNotFoundException
	 * @throws IOException
	 *             First unassigned STB than execute below test case.This test
	 *             case assign language to STB
	 */
	@Test
	public void tc_BCCOMML0210_LANG007_Assignment()
			throws NumberFormatException, InterruptedException, FileNotFoundException, IOException {
		assignLanguageToStB(TestInitization.getExcelKeyValue("AccountInformation", "Language", "Value"),
				(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", "Value")),
				(TestInitization.getExcelKeyValue("AccountInformation", "PinCode", "Value")));
	}


}
