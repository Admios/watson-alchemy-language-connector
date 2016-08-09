package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;

public class RawTextExtractionTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector>{

	public RawTextExtractionTestCase() {
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void testWithURL() {
		DocumentText documentText = getConnector().rawTextExtraction(Constants.TEST_URL_BLOG);

		assertNotNull(documentText);
		assertEquals(Constants.TEST_URL_BLOG, documentText.getUrl());
		assertFalse(documentText.getText().isEmpty());
	}
	
}
