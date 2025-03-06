package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		
		File csvFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
		FileReader fileReader = null; 
		CSVReader csvReader;
		String[] data;
		List<User> userList = null;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext(); 
			userList = new ArrayList<>();
			User userData;
			while((data = csvReader.readNext() )!= null) {
				userData = new User(data[0], data[1]);
				userList.add(userData);
			}
				
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		} 
		
		return userList.iterator();
	}
}
