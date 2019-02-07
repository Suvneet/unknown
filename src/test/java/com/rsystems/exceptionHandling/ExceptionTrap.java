package com.rsystems.exceptionHandling;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.utils.TestInitization;

public class ExceptionTrap extends TestInitization {

	private ArrayList<Exception> registeredException = new ArrayList<>();
	private ITestResult testResult = null;

	public ExceptionTrap(ITestResult result) {
		this.testResult = result;
		// Add run time exception here
		registeredException.add(new NoSuchElementException(ExceptionMesages.NoSuchElementException.toString()));
		registeredException
				.add(new StaleElementReferenceException(ExceptionMesages.StaleElementReferenceException.toString()));
		registeredException.add(new NullPointerException(ExceptionMesages.NullPointerException.toString()));
		registeredException.add(new NoSuchWindowException(ExceptionMesages.NoSuchWindowException.toString()));
	}

	public void setExtendReportStatus() throws InterruptedException {

		boolean matchedRegisteredException = false;
		if (testResult.getStatus() == ITestResult.SKIP) {
			log.debug("Logger.debug " +  testResult.getMethod().getMethodName() + " : "+ getExceptionStackTrace());
			reports.log(LogStatus.ERROR, testResult.getThrowable().getLocalizedMessage().split("\n")[0]);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			return;
		}

		for (Exception exception : registeredException) {
			if (exception.getClass().getName().equalsIgnoreCase(testResult.getThrowable().getClass().getName())) {
				log.debug("Logger.debug " +testResult.getMethod().getMethodName() + " : "+  getExceptionStackTrace());
				reports.log(LogStatus.FAIL, exception.getMessage().split("\n")[0]);
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				matchedRegisteredException = true;
			}
		}
		if(!matchedRegisteredException){
			log.debug("Logger.debug " +  getExceptionStackTrace());
			reports.log(LogStatus.FAIL, testResult.getMethod().getMethodName() + " : "+ testResult.getThrowable().getMessage());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}
	
	
	private String getExceptionStackTrace(){
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    Throwable cause = testResult.getThrowable();
	    if (null != cause) {
	        cause.printStackTrace(pw);
	       return sw.getBuffer().toString();
	    }
		return null;
	}
}
