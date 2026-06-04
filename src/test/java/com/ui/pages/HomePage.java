package com.ui.pages;

import org.openqa.selenium.By;

import com.constant.ENV;
import com.utility.browserUtility;

public class HomePage extends browserUtility {

	public HomePage(String browserName, boolean isHeadless) {
		super(browserName,isHeadless);
		goToWebsite(properties(ENV.QA));
		manageWindow();
	}
	
	static final By SIGIN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");

	public LoginPage go_To_LoginPage() {
		click(SIGIN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	
} 
