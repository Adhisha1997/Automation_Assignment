package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakerAddressUtility;

public class AddressTest {

	HomePage home;
	MyAccountPage myaccount;
	AddressPage address;
	AddressPOJO addressPOJO;
	FakerAddressUtility fakerUtility = new FakerAddressUtility();
	
	@BeforeMethod
	public void setup() {
		 home = new HomePage("chrome", false);
		 myaccount=home.go_To_LoginPage().do_Login_with("pocori3115@lealking.com","password");
		addressPOJO= fakerUtility.Fakeaddress();
	}
	
	@Test
	public void add_new_address() {
	myaccount.go_to_address_page().saveAddress(addressPOJO);
		
	}
}
