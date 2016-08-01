package com.admios.connector.watsonalchemylanguage.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.functional.CommonHandlerTest;
import com.admios.connector.watsonalchemylanguage.automation.functional.GetAuthorsTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.DateExtractionHandlerTest;
import com.admios.connector.watsonalchemylanguage.automation.functional.FeedDetectionHandlerTest;
import com.admios.connector.watsonalchemylanguage.automation.functional.GetConceptsTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.GetEntitiesTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.KeywordsHandlerTest;

@RunWith(Suite.class)
@SuiteClasses({ CommonHandlerTest.class, GetEntitiesTestCase.class, GetConceptsTestCase.class,
		DateExtractionHandlerTest.class, FeedDetectionHandlerTest.class, KeywordsHandlerTest.class,
		GetAuthorsTestCase.class })
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