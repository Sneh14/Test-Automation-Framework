package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.github.dockerjava.api.model.Config;
import com.google.gson.Gson;
import com.ui.pojo.Environment;
import com.ui.pojo.config;

public class JSONUtility {

	public static Environment readJSON(Env env) {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir")+"//config//config.json");
		FileReader fileReadder = null;
		try {
			fileReadder = new FileReader(jsonFile);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		config config = gson.fromJson(fileReadder, config.class);
		Environment environment = config.getEnvironments().get("QA");
		return environment;
	}
}
