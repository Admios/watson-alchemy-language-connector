package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entity;

public class EntitiesTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public EntitiesTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithText() {
		testGetEntities(Constants.TEST_TEXT, Constants.TEST_TEXT_ENTITY_1, Constants.TEST_TEXT_ENTITY_2);
	}

	@Test
	public void testWithURL() {
		testGetEntities(Constants.TEST_URL, Constants.TEST_URL_ENTITY_1, Constants.TEST_URL_ENTITY_2);
	}

	@Test
	public void testWithMaxRetrieve() {
		int maxRetrieve = 3;
		Entities entities = getConnector().entities(Constants.TEST_URL, maxRetrieve, null, null, null,
				null, null, null, null, null, null, null, null);
		assertEquals(String.format("The connector should retrieve only %s entities", maxRetrieve),
				entities.getEntities().size(), maxRetrieve);
	}

	private void testGetEntities(String source, String... expectedEntities) {
		Entities entities = getConnector().entities(source, null, null, null, null,
				null, null, null, null, null, null, null, null);
		assertNotNull(entities);
		testPrecenseOf(entities.getEntities(), expectedEntities);
		if (source.equals(Constants.TEST_URL)) {
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
