/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.watsonalchemylanguage.automation.unit.CommonHandlerTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.UtilsTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.CombinedCallRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.ConceptsRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.DateExtractionRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.EmotionAnalysisRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.EntitiesRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.KeywordsRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.LanguageDetectionRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.MicroformatsRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.SAORelationsRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.SentimentAnalysisRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.TargetedSentimentRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.TaxonomiesRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.TextExtractionRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.TitleExtractionRequestTest;
import org.mule.modules.watsonalchemylanguage.automation.unit.model.TypedRelationsRequestTest;

@RunWith(Suite.class)
@SuiteClasses({
		CommonHandlerTest.class,
		UtilsTest.class,
		CombinedCallRequestTest.class,
		ConceptsRequestTest.class,
		DateExtractionRequestTest.class,
		EmotionAnalysisRequestTest.class,
		EntitiesRequestTest.class,
		KeywordsRequestTest.class,
		LanguageDetectionRequestTest.class,
		MicroformatsRequestTest.class,
		SAORelationsRequestTest.class,
		SentimentAnalysisRequestTest.class,
		TargetedSentimentRequestTest.class,
		TaxonomiesRequestTest.class,
		TextExtractionRequestTest.class,
		TitleExtractionRequestTest.class,
		TypedRelationsRequestTest.class
})
public class UnitTestSuite {

}
