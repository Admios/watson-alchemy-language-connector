/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;
import org.mule.modules.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import org.mule.modules.watsonalchemylanguage.automation.functional.AuthorsTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.CombinedCallTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.DateExtractionTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.EmotionAnalysisTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.FeedDetectionTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.ConceptsTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.EntitiesTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.KeywordsTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.LanguageDetectionTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.MicroformatsTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.PublicationDateTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.RawTextExtractionTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.RelationsTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.SentimentAnalysisTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.TargetedSentimentTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.TaxonomiesTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.TextExtractionTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.TitleExtractionTestCases;
import org.mule.modules.watsonalchemylanguage.automation.functional.TypedRelationsTestCases;
import org.mule.modules.watsonalchemylanguage.automation.unit.CommonHandlerTest;

@RunWith(Suite.class)
@SuiteClasses({ CommonHandlerTest.class,
		EntitiesTestCases.class,
		ConceptsTestCases.class,
		TargetedSentimentTestCases.class,
		RelationsTestCases.class,
		DateExtractionTestCases.class,
		FeedDetectionTestCases.class,
		KeywordsTestCases.class,
		AuthorsTestCases.class,
		SentimentAnalysisTestCases.class,
		TypedRelationsTestCases.class,
		TitleExtractionTestCases.class,
		LanguageDetectionTestCases.class,
		MicroformatsTestCases.class,
		PublicationDateTestCases.class,
		CombinedCallTestCases.class,
		EmotionAnalysisTestCases.class,
		TaxonomiesTestCases.class,
		RawTextExtractionTestCases.class,
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