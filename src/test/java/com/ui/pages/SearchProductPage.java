package com.ui.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.browserUtility;
import com.utility.loggerUtility;

public class SearchProductPage extends browserUtility {

	public SearchProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	Logger logger=loggerUtility.getLogger(this.getClass());
	
	 static final By PRODUCT_PAGE_SEARCH_TITTLE_LOCATOR = By.xpath("//span[@class=\"lighter\"]");
	 static final By LIST_OF_ALL_SEARCH_PRODUCTS_NAME_LOCATOR= By.xpath("//h5[@itemprop=\"name\"]/a");
	 
	 public String get_Product_Page_Tittle() {
		return getVissibleText(PRODUCT_PAGE_SEARCH_TITTLE_LOCATOR);
	 }
	 
	 public boolean getAllDressName(String wordEntered) {
		
		List<String>  searchedProduct= getListOfVissibleText(LIST_OF_ALL_SEARCH_PRODUCTS_NAME_LOCATOR);
		logger.info("Total products found : " + searchedProduct.size());
		
		if(searchedProduct.isEmpty()) {
			logger.info("No product found ");
			return false;
		}
		
		for (String productName : searchedProduct) {
			System.out.println(productName);
			if(!containAtLeastOneWord(productName, wordEntered)) {
				logger.info("Failed product"+ productName);
				return false;
			}
		}
		return true;
	 }
	 
	 public ProductDetailPage selectTheProductAt(int index) {
		 clickElement(getListOfElements(LIST_OF_ALL_SEARCH_PRODUCTS_NAME_LOCATOR).get(index));
		 ProductDetailPage productDetail = new ProductDetailPage(getDriver());
		 return productDetail;
	 }
}
