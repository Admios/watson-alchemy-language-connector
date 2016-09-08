package org.mule.modules.watsonalchemylanguage.automation.unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.TypedRelationsRequest;

public class TypedRelationsRequestTest {

	private static final String SOURCE = "TEST";
	private static final String MODEL = "MODEL";
	private static final Boolean SHOW_SOURCE_TEXT = true;

	@Test
	public void testGettersSetters() {
		TypedRelationsRequest request = new TypedRelationsRequest();

		request.setSource(SOURCE);
		request.setModel(MODEL);
		request.setShowSourceText(SHOW_SOURCE_TEXT);

		assertEquals(SOURCE, request.getModel());
		assertEquals(MODEL, request.getSource());
		assertEquals(SHOW_SOURCE_TEXT, request.getShowSourceText());
	}

}
