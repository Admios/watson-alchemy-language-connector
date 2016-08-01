package com.admios.connector.watsonalchemylanguage.automation.global;

import java.io.IOException;
import java.util.Properties;

public class Constants {

	public static final String TEST_URL;
	public static final String TEST_URL_ENTITY_1;
	public static final String TEST_URL_ENTITY_2;
	public static final String TEST_URL_CONCEPT_1;
	public static final String TEST_URL_CONCEPT_2;
	public static final String TEST_TEXT;
	public static final String TEST_TEXT_ENTITY_1;
	public static final String TEST_TEXT_ENTITY_2;
	public static final String TEST_TEXT_CONCEPT_1;
	public static final String TEST_TEXT_CONCEPT_2;

	static {
		Properties contants = new Properties();
		try {
			contants.load(Constants.class.getResourceAsStream("/constants.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		TEST_URL = contants.getProperty("url");
		TEST_URL_ENTITY_1 = contants.getProperty("url_entity1");
		TEST_URL_ENTITY_2 = contants.getProperty("url_entity2");
		TEST_URL_CONCEPT_1 = contants.getProperty("url_concept1");
		TEST_URL_CONCEPT_2 = contants.getProperty("url_concept2");
		TEST_TEXT = contants.getProperty("text");
		TEST_TEXT_ENTITY_1 = contants.getProperty("text_entity1");
		TEST_TEXT_ENTITY_2 = contants.getProperty("text_entity2");
		TEST_TEXT_CONCEPT_1 = contants.getProperty("text_concept1");
		TEST_TEXT_CONCEPT_2 = contants.getProperty("text_concept2");
	}
}
