/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.TypedRelationsRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelation;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;

public class TypedRelationsTestCases extends AbstractTestCases {

	@Test
	public void testWithURLCustomModel() {
		TypedRelations typedRelations = getConnector().typedRelations(buildBasicRequest());

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

	private TypedRelationsRequest buildBasicRequest() {
		return new TypedRelationsRequest(TestDataBuilder.TEST_URL_BLOG, "en-news", null);
	}

}
