package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class SentimentAnalysisTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public SentimentAnalysisTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURL() {
		DocumentSentiment sentiment = getConnector().sentimentAnalysis(TestDataBuilder.TEST_URL_BLOG,
				null, null, null, null);

		assertNotNull(sentiment);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, sentiment.getUrl());
		assertEquals(TestDataBuilder.TEST_URL_BLOG_SENTIMENT, sentiment.getSentiment().getType().name());
	}

}
