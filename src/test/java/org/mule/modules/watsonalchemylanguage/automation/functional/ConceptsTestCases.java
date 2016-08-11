package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import org.mule.modules.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concept;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;

public class ConceptsTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public ConceptsTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithText() {
		testGetConcepts(Constants.TEST_TEXT, Constants.TEST_TEXT_CONCEPT_1, Constants.TEST_TEXT_CONCEPT_2);
	}

	@Test
	public void testWithURL() {
		testGetConcepts(Constants.TEST_URL, Constants.TEST_URL_CONCEPT_1, Constants.TEST_URL_CONCEPT_2);
	}

	private void testGetConcepts(String source, String... expectedConcepts) {
		Concepts concepts = getConnector().concepts(source,
				null, null, null, null, null, null, null);
		assertNotNull(concepts);
		testPrecenseOf(concepts.getConcepts(), expectedConcepts);
		if (source.equals(Constants.TEST_URL)) {
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

}
