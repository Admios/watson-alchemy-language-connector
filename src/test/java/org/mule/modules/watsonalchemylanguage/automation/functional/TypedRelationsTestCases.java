/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelation;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;

public class TypedRelationsTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public TypedRelationsTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURLCustomModel() {
		TypedRelations typedRelations = getConnector().typedRelations(TestDataBuilder.TEST_URL_BLOG, "en-news", null);

		assertNotNull(typedRelations);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, typedRelations.getUrl());
		testPrecenseOf(typedRelations.getTypedRelations(), TestDataBuilder.TEST_URL_BLOG_TYPE_RELATION);
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
