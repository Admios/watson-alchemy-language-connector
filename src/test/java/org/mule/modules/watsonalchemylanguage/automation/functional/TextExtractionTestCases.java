/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.TextExtractionRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;

public class TextExtractionTestCases extends AbstractTestCases {

	@Test
	public void testWithURL() {
		DocumentText documentText = getConnector().textExtraction(buildBasicRequest());
		CharSequence cs = "been out there for a while now and is definitely a popular";

		assertNotNull(documentText);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, documentText.getUrl());
		assertFalse(!documentText.getText().contains(cs));
	}

	private TextExtractionRequest buildBasicRequest() {
		return new TextExtractionRequest(TestDataBuilder.TEST_URL_BLOG);
	}
}
