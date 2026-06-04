package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.browserUtility;

public class MyAccountPage extends browserUtility {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static final By TITTLE_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]");

	public String verify_user_in_MyaccountPage() {

		return getVissibleText(TITTLE_NAME_LOCATOR);

	}

}
