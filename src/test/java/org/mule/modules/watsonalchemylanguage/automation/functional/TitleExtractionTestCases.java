package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentTitle;

public class TitleExtractionTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public TitleExtractionTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURL() {
		DocumentTitle title = getConnector().titleExtraction(TestDataBuilder.TEST_URL_BLOG, null);

		assertNotNull(title);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, title.getUrl());
		assertEquals(TestDataBuilder.TEST_URL_BLOG_TITLE, title.getTitle());
	}
}