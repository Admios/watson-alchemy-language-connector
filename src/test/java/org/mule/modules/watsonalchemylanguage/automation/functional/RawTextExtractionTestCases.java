package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;

public class RawTextExtractionTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector>{

	public RawTextExtractionTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void testWithURL() {
		DocumentText documentText = getConnector().rawTextExtraction(TestDataBuilder.TEST_URL_BLOG);
		CharSequence cs = "been out there for a while now and is definitely a popular";
		
		assertNotNull(documentText);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, documentText.getUrl());
		assertFalse(!documentText.getText().contains(cs));
	}
	
}
