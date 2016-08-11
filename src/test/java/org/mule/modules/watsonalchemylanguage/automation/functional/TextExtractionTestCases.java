package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;

public class TextExtractionTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {
	public TextExtractionTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void testWithURL() {
		DocumentText documentText = getConnector().textExtraction(Constants.TEST_URL_BLOG, null, null, null, null, null);
		CharSequence cs = "been out there for a while now and is definitely a popular";
		
		assertNotNull(documentText);
		assertEquals(Constants.TEST_URL_BLOG, documentText.getUrl());
		assertFalse(!documentText.getText().contains(cs));
	}
}
