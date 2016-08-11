package org.mule.modules.watsonalchemylanguage.automation.functional;

import java.io.IOException;
import java.util.Properties;

public class TestDataBuilder {

	public static final String TEST_URL;
	public static final String TEST_URL_BLOG;
	public static final String TEST_URL_BLOG_TITLE;
	public static final String TEST_URL_BLOG_AUTHOR;
	public static final String TEST_URL_BLOG_LANGUAGE;
	public static final String TEST_URL_BLOG_SENTIMENT;
	public static final String TEST_URL_BLOG_TAXONOMY_1;
	public static final String TEST_URL_BLOG_TAXONOMY_2;
	public static final String TEST_URL_BLOG_TAXONOMY_3;
	public static final String TEST_URL_BLOG_PUBLICATION_DATE;
	public static final String TEST_URL_BLOG_TYPE_RELATION;
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
			contants.load(TestDataBuilder.class.getResourceAsStream("/constants.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		TEST_URL = contants.getProperty("url");
		TEST_URL_BLOG = contants.getProperty("url_blog");
		TEST_URL_BLOG_TITLE = contants.getProperty("url_blog_title");
		TEST_URL_BLOG_AUTHOR = contants.getProperty("url_blog_author");
		TEST_URL_BLOG_LANGUAGE = contants.getProperty("url_blog_language");
		TEST_URL_BLOG_SENTIMENT = contants.getProperty("url_blog_sentiment");
		TEST_URL_BLOG_TAXONOMY_1 = contants.getProperty("url_blog_taxonomy1");
		TEST_URL_BLOG_TAXONOMY_2 = contants.getProperty("url_blog_taxonomy2");
		TEST_URL_BLOG_TAXONOMY_3 = contants.getProperty("url_blog_taxonomy3");
		TEST_URL_BLOG_PUBLICATION_DATE = contants.getProperty("url_blog_publication_date");
		TEST_URL_BLOG_TYPE_RELATION = contants.getProperty("url_blog_type_relation");
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
