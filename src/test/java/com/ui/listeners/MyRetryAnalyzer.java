package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	// Read from properties file
	private static final int MAX_ATTEMPTS = Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_ATTEMPTS"));
	
	//Read from JSON file 
	//private static final int MAX_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_ATTEMPTS();
	
	private static int currentAttempt = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt <= MAX_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}
