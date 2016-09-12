/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.LanguageDetectionRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.Language;

public class LanguageDetectionTestCases extends AbstractTestCases {

	@Test
	public void testWithURL() {
		Language language = getConnector().languageDetection(buildBasicRequest());

		assertNotNull(language);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, language.getUrl());
		assertEquals(TestDataBuilder.TEST_URL_BLOG_LANGUAGE, language.getLanguage());
	}

	private LanguageDetectionRequest buildBasicRequest() {
		return new LanguageDetectionRequest(TestDataBuilder.TEST_URL_BLOG);
	}
}
