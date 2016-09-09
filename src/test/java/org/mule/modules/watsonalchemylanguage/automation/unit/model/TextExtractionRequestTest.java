/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.TextExtractionRequest;

public class TextExtractionRequestTest {

	private static final String SOURCE = "TEST";
	private static final String CQUERY = "CQUERY";
	private static final String XPATH = "XPATH";
	private static final String SOURCE_TEXT = "SOURCE_TEXT";
	private static final String EXTRACT_LINKS = "EXTRACT_LINKS";
	private static final String USE_META_DATA = "USE_META_DATA";

	@Test
	public void testGettersSetters() {
		TextExtractionRequest request = new TextExtractionRequest();

		request.setSource(SOURCE);
		request.setCquery(CQUERY);
		request.setXpath(XPATH);
		request.setSourceText(SOURCE_TEXT);
		request.setExtractLinks(EXTRACT_LINKS);
		request.setUseMetaData(USE_META_DATA);

		assertEquals(SOURCE, request.getSource());
		assertEquals(CQUERY, request.getCquery());
		assertEquals(XPATH, request.getXpath());
		assertEquals(SOURCE_TEXT, request.getSourceText());
		assertEquals(EXTRACT_LINKS, request.getExtractLinks());
		assertEquals(USE_META_DATA, request.getUseMetaData());
	}

}
