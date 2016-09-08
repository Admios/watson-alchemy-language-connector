package org.mule.modules.watsonalchemylanguage.automation.unit.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.CombinedCallRequest;

public class CombinedCallRequestTest {

	private static final String SOURCE = "TEST";
	private static final Boolean SHOW_SOURCE_TEXT = true;
	private static final String CQUERY = "CQUERY";
	private static final String XPATH = "XPATH";
	private static final String SOURCE_TEXT = "SOURCE_TEXT";
	private static final String EXTRACT = "EXTRACT";
	private static final Integer MAX_RETRIEVE = 10;
	private static final Boolean KEYWORDS = true;
	private static final Boolean ENTITIES = true;
	private static final Boolean REQUIRE_ENTITIES = true;
	private static final Integer COREFENCES = 10;
	private static final Integer DISAMBIGUATE = 1;
	private static final Integer KNOWLEDGE_GRAPH = 1;
	private static final Integer LINKED_DATA = 1;
	private static final Integer QUOTATIONS = 1;
	private static final Integer SENTIMENT = 1;
	private static final Integer STRUCTURED_ENTITIES = 1;
	private static final String ANCHOR_DATE = "ANCHOR_DATE";

	@Test
	public void testGettersSetters() {
		CombinedCallRequest request = new CombinedCallRequest();
		
		request.setSource(SOURCE);
		request.setShowSourceText(SHOW_SOURCE_TEXT);
		request.setCquery(CQUERY);
		request.setXpath(XPATH);
		request.setSourceText(SOURCE_TEXT);
		request.setExtract(EXTRACT);
		request.setMaxRetrieve(MAX_RETRIEVE);
		request.setKeywords(KEYWORDS);
		request.setEntities(ENTITIES);
		request.setRequireEntities(REQUIRE_ENTITIES);
		request.setCoreference(COREFENCES);
		request.setDisambiguate(DISAMBIGUATE);
		request.setKnowledgeGraph(KNOWLEDGE_GRAPH);
		request.setLinkedData(LINKED_DATA);
		request.setQuotations(QUOTATIONS);
		request.setSentiment(SENTIMENT);
		request.setStructuredEntities(STRUCTURED_ENTITIES);
		request.setAnchorDate(ANCHOR_DATE);

		assertEquals(SOURCE, request.getSource());
		assertEquals(SHOW_SOURCE_TEXT, request.getShowSourceText());
		assertEquals(CQUERY, request.getCquery());
		assertEquals(XPATH, request.getXpath());
		assertEquals(SOURCE_TEXT, request.getSourceText());
		assertEquals(EXTRACT, request.getExtract());
		assertEquals(MAX_RETRIEVE, request.getMaxRetrieve());
		assertEquals(KEYWORDS, request.getKeywords());
		assertEquals(ENTITIES, request.getEntities());
		assertEquals(REQUIRE_ENTITIES, request.getRequireEntities());
		assertEquals(COREFENCES, request.getCoreference());
		assertEquals(DISAMBIGUATE, request.getDisambiguate());
		assertEquals(KNOWLEDGE_GRAPH, request.getKnowledgeGraph());
		assertEquals(LINKED_DATA, request.getLinkedData());
		assertEquals(QUOTATIONS, request.getQuotations());
		assertEquals(SENTIMENT, request.getSentiment());
		assertEquals(STRUCTURED_ENTITIES, request.getStructuredEntities());
		assertEquals(ANCHOR_DATE, request.getAnchorDate());
	}

}
