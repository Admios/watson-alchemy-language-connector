/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ibm.watson.developer_cloud.alchemy.v1.model.Language;

public class LanguageDetectionTestCases extends AbstractTestCases {

	@Test
	public void testWithURL() {
		Language language = getConnector().languageDetection(TestDataBuilder.TEST_URL_BLOG, null, null, null, null);

		assertNotNull(language);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, language.getUrl());
		assertEquals(TestDataBuilder.TEST_URL_BLOG_LANGUAGE, language.getLanguage());
	}
}
