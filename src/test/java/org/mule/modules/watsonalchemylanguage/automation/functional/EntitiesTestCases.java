/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entity;

public class EntitiesTestCases extends AbstractTestCases {

	@Test
	public void testWithText() {
		testGetEntities(TestDataBuilder.TEST_TEXT, TestDataBuilder.TEST_TEXT_ENTITY_1, TestDataBuilder.TEST_TEXT_ENTITY_2);
	}

	@Test
	public void testWithURL() {
		testGetEntities(TestDataBuilder.TEST_URL, TestDataBuilder.TEST_URL_ENTITY_1, TestDataBuilder.TEST_URL_ENTITY_2);
	}

	@Test
	public void testWithMaxRetrieve() {
		int maxRetrieve = 3;
		Entities entities = getConnector().entities(TestDataBuilder.TEST_URL, maxRetrieve, null, null, null,
				null, null, null, null, null, null, null, null);
		assertEquals(String.format("The connector should retrieve only %s entities", maxRetrieve),
				entities.getEntities().size(), maxRetrieve);
	}

	private void testGetEntities(String source, String... expectedEntities) {
		Entities entities = getConnector().entities(source, null, null, null, null,
				null, null, null, null, null, null, null, null);
		assertNotNull(entities);
		testPrecenseOf(entities.getEntities(), expectedEntities);
		if (source.equals(TestDataBuilder.TEST_URL)) {
			assertNotNull(entities.getUrl());
		} else {
			assert (entities.getUrl().isEmpty());
		}
	}

	private void testPrecenseOf(List<Entity> entities, String... entitiesToTest) {
		String flatEntities = StringUtils.join(entitiesToTest, ",");
		int cont = 0;
		for (Entity entity : entities) {
			if (flatEntities.contains(entity.getText())) {
				cont++;
			}
		}
		assertEquals(String.format("The response doesn't contains all the expect entities: %s", flatEntities),
				entitiesToTest.length, cont);
	}
}
