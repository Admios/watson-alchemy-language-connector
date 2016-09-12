/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.ConceptsRequest;

public class ConceptsRequestTest {

	private static final String SOURCE = "TEST";
	private static final Boolean SHOW_SOURCE_TEXT = true;
	private static final String CQUERY = "CQUERY";
	private static final String XPATH = "XPATH";
	private static final String SOURCE_TEXT = "SOURCE_TEXT";
	private static final Integer MAX_RETRIEVE = 10;
	private static final Integer KNOWLEDGE_GRAPH = 1;
	private static final Integer LINKED_DATA = 1;

	@Test
	public void testGettersSetters() {
		ConceptsRequest request = new ConceptsRequest();

		request.setSource(SOURCE);
		request.setShowSourceText(SHOW_SOURCE_TEXT);
		request.setCquery(CQUERY);
		request.setXpath(XPATH);
		request.setSourceText(SOURCE_TEXT);
		request.setMaxRetrieve(MAX_RETRIEVE);
		request.setKnowledgeGraph(KNOWLEDGE_GRAPH);
		request.setLinkedData(LINKED_DATA);

		assertEquals(SOURCE, request.getSource());
		assertEquals(SHOW_SOURCE_TEXT, request.getShowSourceText());
		assertEquals(CQUERY, request.getCquery());
		assertEquals(XPATH, request.getXpath());
		assertEquals(SOURCE_TEXT, request.getSourceText());
		assertEquals(MAX_RETRIEVE, request.getMaxRetrieve());
		assertEquals(KNOWLEDGE_GRAPH, request.getKnowledgeGraph());
		assertEquals(LINKED_DATA, request.getLinkedData());
	}

}
