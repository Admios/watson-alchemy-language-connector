package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Language;

public class LanguageDetectionTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public LanguageDetectionTestCase() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURL() {
		Language language = getConnector().languageDetection(Constants.TEST_URL_BLOG, null, null, null, null);

		assertNotNull(language);
		assertEquals(Constants.TEST_URL_BLOG, language.getUrl());
		assertEquals(Constants.TEST_URL_BLOG_LANGUAGE, language.getLanguage());
	}
}
