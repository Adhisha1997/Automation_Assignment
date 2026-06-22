package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.browserUtility;

public class ProductDetailPage extends browserUtility {

	public ProductDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	


	private static final By SIZE_DROPDOWN_LOCATOR= By.xpath("//select[@id=\"group_1\"]");
	private static final By ADD_TO_CART_LOCATOR = By.xpath("//span[contains(text(),\"Add to cart\")]");
	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//a[@class=\"btn btn-default button button-medium\"]/span[contains(text(),'Proceed to checkout')]");
	
	
	public ProductDetailPage selectTheProduct(String value) {
		
		selectdropdown(SIZE_DROPDOWN_LOCATOR, value);
		
		return new ProductDetailPage(getDriver());
		
	}
	
	public ProductDetailPage add_to_cart() {
		
		click(ADD_TO_CART_LOCATOR);
		return new ProductDetailPage(getDriver());
		
	}
	
	public ShoppingCartSummaryPage proceed_to_checkout() {
		
		click(PROCEED_TO_CHECKOUT_LOCATOR);
		ShoppingCartSummaryPage shoppingCartSummary = new ShoppingCartSummaryPage(getDriver());
		return shoppingCartSummary;
	}
	
}
