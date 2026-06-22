package com.ui.tests;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.LoginCredentials;
import com.utility.loggerUtility;

@Listeners({com.ui.listner.TestListner.class})
public class InvalidLoginTest {

	HomePage home;
	
	
	@BeforeMethod(description = "Launching the browser")
	public void setUp() {
		 home = new HomePage("chrome",true);
	}
	
	@Test(description = "Verify with invalid credential to login into the application error message shown and should return to login page",groups = {"regression","smoke","sanity"},
			dataProviderClass = com.ui.dataProvider.LoginDataProvider.class,dataProvider = "csvInvalidLoginDataProvider", retryAnalyzer = com.ui.listner.RetryAnalyser.class)
	public  void loginTest(LoginCredentials logincred) {


		String error_message = home.go_To_LoginPage().do_Login_Invalid_Credentials(logincred.username(), logincred.password()).get_Error_Meesage();
				
		assertEquals(error_message, "Authentication failed.");
		
		
	}

}
