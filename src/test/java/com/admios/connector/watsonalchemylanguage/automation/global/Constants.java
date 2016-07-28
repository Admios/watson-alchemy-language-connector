package com.admios.connector.watsonalchemylanguage.automation.global;

import java.io.IOException;
import java.util.Properties;

public class Constants {
	
	public static final String TEST_URL;
	public static final String TEST_TEXT;
	
	static {
		Properties contants = new Properties();
		try {
			contants.load(Constants.class.getResourceAsStream("/constants.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		TEST_URL = contants.getProperty("test_url");
		TEST_TEXT = contants.getProperty("test_text");
	}
}
