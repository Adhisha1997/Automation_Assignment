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
	static final By ERROR_MESSAGE_LOCATOR = By.xpath("//li[normalize-space()='Authentication failed.']");
	

	public MyAccountPage do_Login_with(String username, String password) {
		sendKeys(EMAIL_TXT_LOCATOR, username);
		sendKeys(PASSWORD_TXT_LOCATOR, password);
		click(SIGNIN_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;

	}
	
	public LoginPage do_Login_Invalid_Credentials(String username, String password) {
		sendKeys(EMAIL_TXT_LOCATOR, username);
		sendKeys(PASSWORD_TXT_LOCATOR, password);
		click(SIGNIN_BUTTON_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;

	}
	
	public String get_Error_Meesage() {
		String errormessage = getVissibleText(ERROR_MESSAGE_LOCATOR);
		return errormessage;
		
	}
}
