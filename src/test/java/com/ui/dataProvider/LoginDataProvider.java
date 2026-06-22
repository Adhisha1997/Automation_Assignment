package com.ui.dataProvider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.ui.pojo.LoginCredentials;
import com.utility.csvReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "csvLogindataprovider")
	
	public Iterator<LoginCredentials> logindata()  {
		
		return csvReaderUtility.csvFileReader("LoginData");
		
		
	}
	
	@DataProvider(name = "csvInvalidLoginDataProvider")
		public Iterator<LoginCredentials> Invalidlogindata()  {
			
			return csvReaderUtility.csvFileReader("InvalidData");
			
			
		}
		
	
}
