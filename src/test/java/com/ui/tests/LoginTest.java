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
public class LoginTest {

	HomePage home;
	
	
	@BeforeMethod(description = "Launching the browser")
	public void setUp() {
		 home = new HomePage("chrome",false);
	}
	
	@Test(description = "Verify with valid credential to login into the application successfully",groups = {"regression","smoke","sanity"},
			dataProviderClass = com.ui.dataProvider.LoginDataProvider.class,dataProvider = "csvLogindataprovider", retryAnalyzer = com.ui.listner.RetryAnalyser.class)
	public  void loginTest(LoginCredentials logincred) {


		String username = home.go_To_LoginPage().do_Login_with(logincred.username(),logincred.password())
				.verify_user_in_MyaccountPage();
		assertEquals(username, "Athira Vengavila");
		
		
	}

}
