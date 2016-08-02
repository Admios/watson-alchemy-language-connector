package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class SentimentAnalysisTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public SentimentAnalysisTestCase() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURL() {
		DocumentSentiment sentiment = getConnector().sentimentAnalysis(Constants.TEST_URL_BLOG,
				null, null, null, null);

		assertNotNull(sentiment);
		assertEquals(Constants.TEST_URL_BLOG, sentiment.getUrl());
		assertEquals(Constants.TEST_URL_BLOG_SENTIMENT, sentiment.getSentiment().getType().name());
	}

}
