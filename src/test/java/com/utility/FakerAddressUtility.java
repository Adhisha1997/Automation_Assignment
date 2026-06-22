package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakerAddressUtility {

	
	public AddressPOJO Fakeaddress() {
		Faker faker = new Faker(Locale.US);
		AddressPOJO addressPOJO = new AddressPOJO(faker.company().industry(), 
				faker.address().buildingNumber(), 
				faker.address().fullAddress(), 
				faker.address().city(), 
				"5",
				faker.address().zipCode(), 
				faker.phoneNumber().cellPhone(), 
				faker.phoneNumber().cellPhone(), 
				faker.name().username());
		return addressPOJO;
	}
}
