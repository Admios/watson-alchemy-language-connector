package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;

public class TextExtractionTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector> {
	public TextExtractionTestCase() {
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void testWithURL() {
		DocumentText documentText = getConnector().textExtraction(Constants.TEST_URL_BLOG, null, null, null, null, null);

		assertNotNull(documentText);
		assertEquals(Constants.TEST_URL_BLOG, documentText.getUrl());
		assertFalse(documentText.getText().isEmpty());
	}
}
