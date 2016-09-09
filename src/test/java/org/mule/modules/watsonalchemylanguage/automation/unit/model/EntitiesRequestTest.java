/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.EntitiesRequest;

public class EntitiesRequestTest {

	private static final String SOURCE = "TEST";
	private static final Boolean SHOW_SOURCE_TEXT = true;
	private static final String CQUERY = "CQUERY";
	private static final String XPATH = "XPATH";
	private static final String SOURCE_TEXT = "SOURCE_TEXT";
	private static final Integer MAX_RETRIEVE = 10;
	private static final Integer COREFENCES = 10;
	private static final Integer DISAMBIGUATE = 1;
	private static final Integer KNOWLEDGE_GRAPH = 1;
	private static final Integer LINKED_DATA = 1;
	private static final Integer QUOTATIONS = 1;
	private static final Integer SENTIMENT = 1;
	private static final Integer STRUCTURED_ENTITIES = 1;

	@Test
	public void testGettersSetters() {
		EntitiesRequest request = new EntitiesRequest();

		request.setSource(SOURCE);
		request.setShowSourceText(SHOW_SOURCE_TEXT);
		request.setCquery(CQUERY);
		request.setXpath(XPATH);
		request.setSourceText(SOURCE_TEXT);
		request.setMaxRetrieve(MAX_RETRIEVE);
		request.setCoreference(COREFENCES);
		request.setDisambiguate(DISAMBIGUATE);
		request.setKnowledgeGraph(KNOWLEDGE_GRAPH);
		request.setLinkedData(LINKED_DATA);
		request.setQuotations(QUOTATIONS);
		request.setSentiment(SENTIMENT);
		request.setStructuredEntities(STRUCTURED_ENTITIES);

		assertEquals(SOURCE, request.getSource());
		assertEquals(SHOW_SOURCE_TEXT, request.getShowSourceText());
		assertEquals(CQUERY, request.getCquery());
		assertEquals(XPATH, request.getXpath());
		assertEquals(SOURCE_TEXT, request.getSourceText());
		assertEquals(MAX_RETRIEVE, request.getMaxRetrieve());
		assertEquals(COREFENCES, request.getCoreference());
		assertEquals(DISAMBIGUATE, request.getDisambiguate());
		assertEquals(KNOWLEDGE_GRAPH, request.getKnowledgeGraph());
		assertEquals(LINKED_DATA, request.getLinkedData());
		assertEquals(QUOTATIONS, request.getQuotations());
		assertEquals(SENTIMENT, request.getSentiment());
		assertEquals(STRUCTURED_ENTITIES, request.getStructuredEntities());
	}

}
