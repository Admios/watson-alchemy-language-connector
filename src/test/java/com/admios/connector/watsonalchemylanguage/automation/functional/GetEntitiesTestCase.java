package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;

public class GetEntitiesTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public GetEntitiesTestCase() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithText() {
		assertNotNull(getConnector().getEntities(Constants.TEST_TEXT));
	}

	@Test
	public void testWithURL() {
		assertNotNull(getConnector().getEntities(Constants.TEST_URL));
	}
}
