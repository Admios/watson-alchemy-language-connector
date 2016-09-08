package org.mule.modules.watsonalchemylanguage.automation.unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.MicroformatsRequest;

public class MicroformatsRequestTest {

	private static final String SOURCE = "TEST";
	private static final Boolean SHOW_SOURCE_TEXT = true;

	@Test
	public void testGettersSetters() {
		MicroformatsRequest request = new MicroformatsRequest();

		request.setSource(SOURCE);
		request.setShowSourceText(SHOW_SOURCE_TEXT);

		assertEquals(SOURCE, request.getSource());
		assertEquals(SHOW_SOURCE_TEXT, request.getShowSourceText());
	}

}
