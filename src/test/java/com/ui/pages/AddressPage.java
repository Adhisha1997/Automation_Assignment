package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.browserUtility;

public class AddressPage extends browserUtility{

	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	static final By COMPANY_TEXT_FIELD_LOCATOR = By.id("company");
	static final By ADDRESS_TEXT_FIELD_LOCATOR = By.id("address1");
	static final By ADDRESS_LINE2_TEXT_FIELD_LOCATOR = By.id("address2");
	static final By CITY_TEXT_FIELD_LOCATOR = By.id("city");
	static final By STATE_DROPDOWN_LOCATOR = By.xpath("//select[@name=\"id_state\"]");
	static final By ZIPCODE_TEXT_FIELD_LOCATOR = By.id("postcode");
    static final By SAVE_BUTTON =By.id("submitAddress");
	static final By HOMEPHONE_TEXT_FIELD_LOCATOR = By.id("phone");
	static final By MOBILEPHONE_TEXT_FIELD_LOCATOR = By.id("phone_mobile");
	static final By TITTLE_TEXT_FIELD_LOCATOR = By.id("alias");
	
	public void saveAddress(AddressPOJO addressPOJO) {
		
		sendKeys(COMPANY_TEXT_FIELD_LOCATOR, addressPOJO.company());
		sendKeys(ADDRESS_TEXT_FIELD_LOCATOR, addressPOJO.address());
		sendKeys(ADDRESS_LINE2_TEXT_FIELD_LOCATOR, addressPOJO.addressLine2());
		sendKeys(CITY_TEXT_FIELD_LOCATOR, addressPOJO.city());
		selectdropdown(STATE_DROPDOWN_LOCATOR, addressPOJO.state());
		sendKeys(ZIPCODE_TEXT_FIELD_LOCATOR, addressPOJO.zip());
		sendKeys(HOMEPHONE_TEXT_FIELD_LOCATOR, addressPOJO.homePhone());
		sendKeys(MOBILEPHONE_TEXT_FIELD_LOCATOR, addressPOJO.MobilePhone());
		sendKeys(TITTLE_TEXT_FIELD_LOCATOR, addressPOJO.tittle());
		click(SAVE_BUTTON);
		
	}
}
