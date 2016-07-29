package com.admios.connector.watsonalchemylanguage.automation.global;

import java.io.IOException;
import java.util.Properties;

public class Constants {
	
	public static final String URL;
	public static final String URL_ENTITY_1;
	public static final String URL_ENTITY_2;
	public static final String TEXT;
	public static final String TEXT_ENTITY_1;
	public static final String TEXT_ENTITY_2;
	
	static {
		Properties contants = new Properties();
		try {
			contants.load(Constants.class.getResourceAsStream("/constants.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		URL = contants.getProperty("url");
		URL_ENTITY_1 = contants.getProperty("url_entity1");
		URL_ENTITY_2 = contants.getProperty("url_entity2");
		TEXT = contants.getProperty("text");
		TEXT_ENTITY_1 = contants.getProperty("text_entity1");
		TEXT_ENTITY_2 = contants.getProperty("text_entity2");
	}
}
