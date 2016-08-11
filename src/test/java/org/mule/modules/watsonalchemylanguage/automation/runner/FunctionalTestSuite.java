package org.mule.modules.watsonalchemylanguage.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.watsonalchemylanguage.automation.CommonHandlerTest;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.functional.AuthorsTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.CombinedCallTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.DateExtractionTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.EmotionAnalysisTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.FeedDetectionTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.ConceptsTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.EntitiesTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.KeywordsTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.LanguageDetectionTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.MicroformatsTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.PublicationDateTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.RawTextExtractionTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.RelationsTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.SentimentAnalysisTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.TargetedSentimentTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.TaxonomyTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.TextExtractionTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.TitleExtractionTestCases;
import com.admios.connector.watsonalchemylanguage.automation.functional.TypedRelationsTestCases;

@RunWith(Suite.class)
@SuiteClasses({ CommonHandlerTest.class, EntitiesTestCases.class, ConceptsTestCases.class,
		TargetedSentimentTestCases.class, RelationsTestCases.class,
		DateExtractionTestCases.class, FeedDetectionTestCases.class, KeywordsTestCases.class,
		AuthorsTestCases.class, SentimentAnalysisTestCases.class, TypedRelationsTestCases.class,
		TitleExtractionTestCases.class, LanguageDetectionTestCases.class, MicroformatsTestCases.class,
		PublicationDateTestCases.class, CombinedCallTestCases.class,
		EmotionAnalysisTestCases.class, TaxonomyTestCases.class, RawTextExtractionTestCases.class,
		TextExtractionTestCases.class })
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