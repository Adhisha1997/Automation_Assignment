package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.LoginCredentials;

public class csvReaderUtility {
	
	public static Iterator<LoginCredentials> csvFileReader(String filenameCSV)  {
		
		File csvFile = new File(System.getProperty("user.dir")  + File.separator+"Test Data" + File.separator+filenameCSV+".csv");
		//FileReader filereader = null ;
		
		String[] line;
		List<LoginCredentials> userline = new ArrayList<LoginCredentials>(); ;
		try {
			FileReader filereader = new FileReader(csvFile);
			CSVReader csvreader = new CSVReader(filereader);
			csvreader.readNext();      //String[] line=csvreader.readNext(); this line is written in while loop dont get confused so written in comment
			while ((line=csvreader.readNext())!=null) {
				
				LoginCredentials logincred = new LoginCredentials(line[0], line[1]);
				userline.add(logincred);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		catch (CsvValidationException | IOException e) {
			
			e.printStackTrace();
		}
		
		return userline.iterator();
		
		
	}

}
