package com.admios.connector.watsonalchemylanguage.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.functional.GetEntitiesTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.GreetTestCases;

@RunWith(Suite.class)
@SuiteClasses({ GreetTestCases.class, GetEntitiesTestCase.class })

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