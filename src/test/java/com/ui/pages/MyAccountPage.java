package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.browserUtility;
import com.utility.loggerUtility;

public class MyAccountPage extends browserUtility {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static final By TITTLE_NAME_LOCATOR = By.xpath("//a[@title=\"View my customer account\"]");
	static final By SEARCH_BOX_LOCATOR= By.xpath("//input[@id=\"search_query_top\"]");
	static final By ADD_MY_FIRST_ADDRESS= By.xpath("//a[@title=\"Add my first address\"]");

	public String verify_user_in_MyaccountPage() {

		return getVissibleText(TITTLE_NAME_LOCATOR);

	}

	
	public SearchProductPage product_Search(String productName) {
		
		sendKeys(SEARCH_BOX_LOCATOR, productName);
		sendSpecialKeys(SEARCH_BOX_LOCATOR, Keys.ENTER);
		SearchProductPage searchProductPage = new SearchProductPage(getDriver());
		return searchProductPage;
	}
	
	public AddressPage go_to_address_page() {
		click(ADD_MY_FIRST_ADDRESS);
		AddressPage address = new AddressPage(getDriver());
		return address;
	}
}
