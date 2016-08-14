package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;  
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keyword;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;

public class KeywordsTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public KeywordsTestCases(){
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void getKeywordsUsingText(){
		boolean keywordFound = false;
		String paragraph = "The polymer is made by a company called Qenos from Australian gas extracted"
				+ " from the huge fields of the Cooper and Surat Basins in the arid lands out near the"
				+ " Queensland, New South Wales and South Australian borders.";
		
		Keywords results = getConnector().keywords(paragraph, null, null, null, false, null, null, null);
		
		assertNotNull(results);
		assertEquals("english", results.getLanguage());
		assertEquals(1, results.getTotalTransactions().intValue());
		assertEquals(10, results.getKeywords().size());
		for(Keyword k: results.getKeywords()){
			if(k.getText().equalsIgnoreCase("South Australian borders")){
		 		keywordFound = true;
		 		assertNotNull(k.getRelevance());
		 		break;
			}
		}
		assertTrue(keywordFound);
	}
	
}
