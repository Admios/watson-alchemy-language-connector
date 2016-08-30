/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class TargetedSentimentTestCases extends AbstractTestCases {

	@Test
	public void getTargetedSentimentUsingText() {

		String paragraph = "The polymer is very good but node is very bad";
		DocumentSentiment results = getConnector().targetedSentiment(paragraph, "polymer", true, null, null, null);

		assertNotNull(results);
		assertEquals("english", results.getLanguage());
		assertEquals(1, results.getTotalTransactions().intValue());
		assertNotNull(results.getSentiment().getScore());
		assertEquals("POSITIVE", results.getSentiment().getType().toString());

		results = getConnector().targetedSentiment(paragraph, "node", true, null, null, null);
		assertNotNull(results);
		assertEquals("english", results.getLanguage());
		assertEquals(1, results.getTotalTransactions().intValue());
		assertNotNull(results.getSentiment().getScore());
		assertEquals("NEGATIVE", results.getSentiment().getType().toString());
	}

}
