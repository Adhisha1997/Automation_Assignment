package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.browserUtility;

public class ShoppingCartSummaryPage extends browserUtility{

	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By SUMMARY_PROCEED_TO_CHECKOUT_LOCATOR=By.xpath("//a[@class=\"button btn btn-default standard-checkout button-medium\"]/span[contains(text(),\"Proceed to checkout\")]");
    private static final By ADDRESS_PROCEED_TO_CHECKOUT_LOCATOR=By.xpath("//button[@name=\"processAddress\"]");
    private static final By SHIPPING_AGREE_TERMS_LOCATOR=By.id("uniform-cgv");
    private static final By SHIPPING_PROCEED_TO_CHECKOUT_LOCATOR=By.xpath("//button[@name=\"processCarrier\"]");
	
    public void checkout_proceed_to_next() {
    	click(SUMMARY_PROCEED_TO_CHECKOUT_LOCATOR);
    	click(ADDRESS_PROCEED_TO_CHECKOUT_LOCATOR);
    	radiobox_click(SHIPPING_AGREE_TERMS_LOCATOR);
    	click(SHIPPING_PROCEED_TO_CHECKOUT_LOCATOR);
    }

}
