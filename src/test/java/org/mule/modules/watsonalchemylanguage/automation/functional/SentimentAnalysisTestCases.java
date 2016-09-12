/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.SentimentAnalysisRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class SentimentAnalysisTestCases extends AbstractTestCases {

	@Test
	public void testWithURL() {
		DocumentSentiment sentiment = getConnector().sentimentAnalysis(buildBasicRequest());

		assertNotNull(sentiment);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, sentiment.getUrl());
		assertEquals(TestDataBuilder.TEST_URL_BLOG_SENTIMENT, sentiment.getSentiment().getType().name());
	}

	private SentimentAnalysisRequest buildBasicRequest() {
		return new SentimentAnalysisRequest(TestDataBuilder.TEST_URL_BLOG);
	}
}
