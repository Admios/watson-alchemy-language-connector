package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class TargetedSentimentTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public TargetedSentimentTestCases(){
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void getTargetedSentimentUsingText(){
		
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
