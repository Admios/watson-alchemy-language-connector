package org.mule.modules.watsonalchemylanguage.automation.unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.TargetedSentimentRequest;

public class TargetedSentimentRequestTest {

	private static final String SOURCE = "TEST";
	private static final String TARGET = "TARGET";
	private static final Boolean SHOW_SOURCE_TEXT = true;
	private static final String CQUERY = "CQUERY";
	private static final String XPATH = "XPATH";
	private static final String SOURCE_TEXT = "SOURCE_TEXT";

	@Test
	public void testGettersSetters() {
		TargetedSentimentRequest request = new TargetedSentimentRequest();

		request.setSource(SOURCE);
		request.setTarget(TARGET);
		request.setShowSourceText(SHOW_SOURCE_TEXT);
		request.setCquery(CQUERY);
		request.setXpath(XPATH);
		request.setSourceText(SOURCE_TEXT);

		assertEquals(SOURCE, request.getSource());
		assertEquals(TARGET, request.getTarget());
		assertEquals(SHOW_SOURCE_TEXT, request.getShowSourceText());
		assertEquals(CQUERY, request.getCquery());
		assertEquals(XPATH, request.getXpath());
		assertEquals(SOURCE_TEXT, request.getSourceText());
	}

}
