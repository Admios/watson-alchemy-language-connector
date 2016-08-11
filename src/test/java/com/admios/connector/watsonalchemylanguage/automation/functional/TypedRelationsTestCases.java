package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelation;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;

public class TypedRelationsTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public TypedRelationsTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURLCustomModel() {
		TypedRelations typedRelations = getConnector().typedRelations(Constants.TEST_URL_BLOG, "en-news", null);

		assertNotNull(typedRelations);
		assertEquals(Constants.TEST_URL_BLOG, typedRelations.getUrl());
		testPrecenseOf(typedRelations.getTypedRelations(), Constants.TEST_URL_BLOG_TYPE_RELATION);
	}

	private void testPrecenseOf(List<TypedRelation> relations, String... expectedRelations) {
		String flatRelations = StringUtils.join(expectedRelations, ",");
		int cont = 0;
		for (TypedRelation relation : relations) {
			if (flatRelations.contains(relation.getType())) {
				cont++;
			}
		}
		assertTrue(String.format("The response doesn't contains all the expect entities: %s", flatRelations),
				cont >= expectedRelations.length);
	}

}
