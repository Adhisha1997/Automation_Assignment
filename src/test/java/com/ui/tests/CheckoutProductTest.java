package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.ui.pages.ProductDetailPage;
import com.ui.pages.SearchProductPage;

public class CheckoutProductTest {
	
	private String product_name="Printed summer dress";
	String product_size_value = "2";
	
	HomePage home;
	MyAccountPage myAccount;
	SearchProductPage searchProductPage;
	ProductDetailPage productDetail;
	
	@BeforeMethod
	public void setup() {
		 home=new HomePage("Chrome", false);
		 searchProductPage=home.go_To_LoginPage().do_Login_with("pocori3115@lealking.com","password").product_Search(product_name);
	}
	
	@Test
	public void checkoutProduct() {
		
		searchProductPage.selectTheProductAt(4).selectTheProduct("2").add_to_cart().proceed_to_checkout().checkout_proceed_to_next();
	}

}
