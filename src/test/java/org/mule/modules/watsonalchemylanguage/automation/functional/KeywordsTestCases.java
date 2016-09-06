/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.KeywordsRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.Keyword;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;

public class KeywordsTestCases extends AbstractTestCases {

	@Test
	public void getKeywordsUsingText() {
		boolean keywordFound = false;

		Keywords results = getConnector().keywords(buildTestRequest());

		assertNotNull(results);
		assertEquals("english", results.getLanguage());
		assertEquals(1, results.getTotalTransactions().intValue());
		assertEquals(10, results.getKeywords().size());
		for (Keyword k : results.getKeywords()) {
			if (k.getText().equalsIgnoreCase("South Australian borders")) {
				keywordFound = true;
				assertNotNull(k.getRelevance());
				break;
			}
		}
		assertTrue(keywordFound);
	}
	
	private KeywordsRequest buildTestRequest() {
		KeywordsRequest kr = new KeywordsRequest();
		String paragraph = "The polymer is made by a company called Qenos from Australian gas extracted"
				+ " from the huge fields of the Cooper and Surat Basins in the arid lands out near the"
				+ " Queensland, New South Wales and South Australian borders.";
		kr.setSource(paragraph);
		kr.setShowSourceText(false);
		
		return kr;
	}

}
