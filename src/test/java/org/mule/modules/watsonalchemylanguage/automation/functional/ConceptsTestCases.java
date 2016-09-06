/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.ConceptsRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.Concept;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;

public class ConceptsTestCases extends AbstractTestCases {

	@Test
	public void testWithText() {
		testGetConcepts(TestDataBuilder.TEST_TEXT, TestDataBuilder.TEST_TEXT_CONCEPT_1, TestDataBuilder.TEST_TEXT_CONCEPT_2);
	}

	@Test
	public void testWithURL() {
		testGetConcepts(TestDataBuilder.TEST_URL, TestDataBuilder.TEST_URL_CONCEPT_1, TestDataBuilder.TEST_URL_CONCEPT_2);
	}

	private void testGetConcepts(String source, String... expectedConcepts) {
		Concepts concepts = getConnector().concepts(buildTestRequest(source));
		assertNotNull(concepts);
		testPrecenseOf(concepts.getConcepts(), expectedConcepts);
		if (source.equals(TestDataBuilder.TEST_URL)) {
			assertNotNull(concepts.getUrl());
		} else {
			assert (concepts.getUrl().isEmpty());
		}
	}

	private void testPrecenseOf(List<Concept> concepts, String... expectedConcepts) {
		String flatConcepts = StringUtils.join(expectedConcepts, ",");
		int cont = 0;
		for (Concept concept : concepts) {
			if (flatConcepts.contains(concept.getText())) {
				cont++;
			}
		}
		assertEquals(String.format("The response doesn't contains all the expect concepts: %s", flatConcepts),
				expectedConcepts.length, cont);
	}
	
	
	private ConceptsRequest buildTestRequest(String source) {
		ConceptsRequest cr = new ConceptsRequest();
		cr.setSource(source);
		return cr;
	}

}
