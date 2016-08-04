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
import com.admios.connector.watsonalchemylanguage.automation.functional.CombinedCallTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.DateExtractionTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.FeedDetectionTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.ConceptsTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.EntitiesTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.KeywordsTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.LanguageDetectionTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.MicroformatsTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.PublicationDateTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.RelationsTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.SentimentAnalysisTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.TargetedSentimentTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.TitleExtractionTestCase;
import com.admios.connector.watsonalchemylanguage.automation.functional.TypedRelationsTestCase;

@RunWith(Suite.class)
@SuiteClasses({ CommonHandlerTest.class, EntitiesTestCase.class, ConceptsTestCase.class,
		TargetedSentimentTestCase.class, RelationsTestCase.class,
		DateExtractionTestCase.class, FeedDetectionTestCase.class, KeywordsTestCase.class,
		AuthorsTestCase.class, SentimentAnalysisTestCase.class, TypedRelationsTestCase.class,
		TitleExtractionTestCase.class, LanguageDetectionTestCase.class, MicroformatsTestCase.class,
		PublicationDateTestCase.class, CombinedCallTestCase.class })
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