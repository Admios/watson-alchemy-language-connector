package com.admios.connector.watsonalchemylanguage.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.functional.CommonHandlerTest;
import com.admios.connector.watsonalchemylanguage.automation.functional.AuthorsTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.DateExtractionHandlerTest;
import com.admios.connector.watsonalchemylanguage.automation.functional.FeedDetectionHandlerTest;
import com.admios.connector.watsonalchemylanguage.automation.functional.ConceptsTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.EntitiesTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.KeywordsHandlerTest;

@RunWith(Suite.class)
@SuiteClasses({ CommonHandlerTest.class, EntitiesTestCase.class, ConceptsTestCase.class,
		DateExtractionHandlerTest.class, FeedDetectionHandlerTest.class, KeywordsHandlerTest.class,
		AuthorsTestCase.class })
public class FunctionalTestSuite {

	@BeforeClass
	public static void initialiseSuite() {
		ConnectorTestContext.initialize(WatsonAlchemyLanguageConnector.class);
	}

	@AfterClass
	public static void shutdownSuite() {
		ConnectorTestContext.shutDown();
	}

}