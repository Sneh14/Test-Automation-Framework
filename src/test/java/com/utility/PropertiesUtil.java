package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env, String propertyName) {
		File propFile = new File(System.getProperty("user.dir")+"//config//"+env+".properties");
		FileReader fileReader;
		Properties prop = new Properties();
		try {
			fileReader = new FileReader(propFile);
			prop.load(fileReader);
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
		return  prop.getProperty(propertyName.toUpperCase());
		
	}
}
