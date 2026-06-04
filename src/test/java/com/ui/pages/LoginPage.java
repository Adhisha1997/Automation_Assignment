package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.browserUtility;

public class LoginPage extends browserUtility {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	static final By EMAIL_TXT_LOCATOR = By.xpath("//input[@id=\"email\"]");
	static final By PASSWORD_TXT_LOCATOR = By.xpath("//input[@id=\"passwd\"]");
	static final By SIGNIN_BUTTON_LOCATOR = By.xpath("//button[@id=\"SubmitLogin\"]");

	public MyAccountPage do_Login_with(String username, String password) {
		sendKeys(EMAIL_TXT_LOCATOR, username);
		sendKeys(PASSWORD_TXT_LOCATOR, password);
		click(SIGNIN_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;

	}
}
