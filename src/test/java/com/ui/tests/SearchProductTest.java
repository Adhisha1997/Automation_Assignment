package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.LoginCredentials;
import com.utility.browserUtility;

@Listeners(com.ui.listner.TestListner.class)
public class SearchProductTest{

	
   
	HomePage homepage;
	MyAccountPage myaccountPage;
	String search_Text = "blouse";

	
	@BeforeMethod(description = "Able to Login with valid login")
	public void setUp() {
		homepage = new HomePage("chrome",false);
		myaccountPage= homepage.go_To_LoginPage().do_Login_with("pocori3115@lealking.com","password");
	}
	
	@Test(description = "Verify entering product name in search box redirects to correct entered product page",
						retryAnalyzer = com.ui.listner.RetryAnalyser.class)
	public void searchProduct() {
		
		
		 boolean actualResult=myaccountPage.product_Search(search_Text).getAllDressName(search_Text);
		Assert.assertTrue(actualResult);
	}
	}
