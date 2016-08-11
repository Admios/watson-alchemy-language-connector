package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;

public class EmotionAnalysisTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {
	
	public EmotionAnalysisTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void testWithURL() {
		DocumentEmotion documentEmotion = getConnector().emotionAnalysis(Constants.TEST_URL_BLOG, null, null, null, null);

		assertNotNull(documentEmotion);
		assertEquals(Constants.TEST_URL_BLOG, documentEmotion.getUrl());
		assertFalse(documentEmotion.getEmotion().getJoy() == 0);
	}
}
