package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class TargetedSentimentTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public TargetedSentimentTestCase(){
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void getTargetedSentimentsUsingText(){
		
		String paragraph = "The polymer is made by a company called Qenos from Australian gas extracted"
				+ " from the huge fields of the Cooper and Surat Basins in the arid lands out near the"
				+ " Queensland, New South Wales and South Australian borders.";
		ArrayList<String> targets = new ArrayList<>();
		targets.add("Australian");
		DocumentSentiment results = getConnector().targetedSentiments(paragraph, targets, null, null, null, null);
		
		assertNotNull(results);
		assertEquals("english", results.getLanguage());
		assertEquals(1, results.getTotalTransactions().intValue());
	}
	
}
