package org.mule.modules.watsonalchemylanguage.automation.unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.DateExtractionRequest;

public class DateExtractionRequestTest {

	private static final String SOURCE = "TEST";
	private static final Boolean SHOW_SOURCE_TEXT = true;
	private static final String ANCHOR_DATE = "ANCHOR_DATE";

	@Test
	public void testGettersSetters() {
		DateExtractionRequest request = new DateExtractionRequest();

		request.setSource(SOURCE);
		request.setShowSourceText(SHOW_SOURCE_TEXT);
		request.setAnchorDate(ANCHOR_DATE);

		assertEquals(SOURCE, request.getSource());
		assertEquals(SHOW_SOURCE_TEXT, request.getShowSourceText());
		assertEquals(ANCHOR_DATE, request.getAnchorDate());
	}
}
