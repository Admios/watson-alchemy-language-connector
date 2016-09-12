/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;

import org.junit.Test;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentPublicationDate;

public class PublicationDateTestCases extends AbstractTestCases {

	@Test
	public void testWithURL() {
		DocumentPublicationDate publicationDate = getConnector().publicationDate(TestDataBuilder.TEST_URL_BLOG);

		assertNotNull(publicationDate);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, publicationDate.getUrl());
		assertEquals(TestDataBuilder.TEST_URL_BLOG_PUBLICATION_DATE,
				new SimpleDateFormat("yyyyMMdd").format(publicationDate.getPublicationDate().getDate()));
	}

}
