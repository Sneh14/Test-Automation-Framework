package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcel(String fileName) {
		File excelFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
		XSSFWorkbook workbook=null;
		List<User> userList = new ArrayList<>();
		Row row;
		Cell emailCell;
		Cell passwordCell;
		User user;
		try {
			workbook = new XSSFWorkbook(excelFile);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		} 
		XSSFSheet sheet = workbook.getSheet("LoginTestData");
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next(); //Skip header
		while(rowIterator.hasNext()) {
			row = rowIterator.next();
			emailCell = row.getCell(0);
			passwordCell = row.getCell(1);
			user = new User(emailCell.toString(),passwordCell.toString());
			userList.add(user);
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}
}
