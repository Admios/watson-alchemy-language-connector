/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.TitleExtractionRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentTitle;

public class TitleExtractionTestCases extends AbstractTestCases {

	@Test
	public void testWithURL() {
		DocumentTitle title = getConnector().titleExtraction(buildBasicRequest());

		assertNotNull(title);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, title.getUrl());
		assertEquals(TestDataBuilder.TEST_URL_BLOG_TITLE, title.getTitle());
	}

	private TitleExtractionRequest buildBasicRequest() {
		return new TitleExtractionRequest(TestDataBuilder.TEST_URL_BLOG, null);
	}
}