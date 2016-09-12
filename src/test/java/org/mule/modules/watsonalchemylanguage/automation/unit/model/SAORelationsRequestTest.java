/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.unit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.SAORelationsRequest;

public class SAORelationsRequestTest {

	private static final String SOURCE = "TEST";
	private static final Boolean SHOW_SOURCE_TEXT = true;
	private static final String CQUERY = "CQUERY";
	private static final String XPATH = "XPATH";
	private static final String SOURCE_TEXT = "SOURCE_TEXT";
	private static final Integer MAX_RETRIEVE = 10;
	private static final Boolean KEYWORDS = true;
	private static final Boolean ENTITIES = true;
	private static final Boolean REQUIRE_ENTITIES = true;
	private static final Boolean ANALYZE_SENTIMENT = true;
	private static final Boolean HIDE_LINKED_DATA = true;
	private static final Boolean COREFENCES = true;
	private static final Boolean DISAMBIGUATE = true;
	private static final Boolean KNOWLEDGE_GRAPH = true;

	@Test
	public void testGettersSetters() {
		SAORelationsRequest request = new SAORelationsRequest();

		request.setSource(SOURCE);
		request.setShowSourceText(SHOW_SOURCE_TEXT);
		request.setCquery(CQUERY);
		request.setXpath(XPATH);
		request.setSourceText(SOURCE_TEXT);
		request.setMaxRetrieve(MAX_RETRIEVE);
		request.setKeywords(KEYWORDS);
		request.setEntities(ENTITIES);
		request.setRequireEntities(REQUIRE_ENTITIES);
		request.setAnalyzeSentiment(ANALYZE_SENTIMENT);
		request.setHideLinkedData(HIDE_LINKED_DATA);
		request.setCoreference(COREFENCES);
		request.setDisambiguate(DISAMBIGUATE);
		request.setKnowledgeGraph(KNOWLEDGE_GRAPH);

		assertEquals(SOURCE, request.getSource());
		assertEquals(SHOW_SOURCE_TEXT, request.getShowSourceText());
		assertEquals(CQUERY, request.getCquery());
		assertEquals(XPATH, request.getXpath());
		assertEquals(SOURCE_TEXT, request.getSourceText());
		assertEquals(MAX_RETRIEVE, request.getMaxRetrieve());
		assertEquals(KEYWORDS, request.getKeywords());
		assertEquals(ENTITIES, request.getEntities());
		assertEquals(REQUIRE_ENTITIES, request.getRequireEntities());
		assertEquals(ANALYZE_SENTIMENT, request.getAnalyzeSentiment());
		assertEquals(HIDE_LINKED_DATA, request.getHideLinkedData());
		assertEquals(COREFENCES, request.getCoreference());
		assertEquals(DISAMBIGUATE, request.getDisambiguate());
		assertEquals(KNOWLEDGE_GRAPH, request.getKnowledgeGraph());
	}

}
