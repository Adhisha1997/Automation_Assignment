package com.ui.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	static final int MAXIMUM_RETRY = 2;
	int current_count =1;
	
	@Override
	public boolean retry(ITestResult result) {
	
		if(current_count<=MAXIMUM_RETRY) {
			current_count++;
			return true;
		}
		
		return false;
	}

}
