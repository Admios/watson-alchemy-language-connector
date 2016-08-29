/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentAuthors;

public class AuthorsTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public AuthorsTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURL() {
		DocumentAuthors authors = getConnector().authors(TestDataBuilder.TEST_URL_BLOG);

		assertNotNull(authors);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, authors.getUrl());
		assertEquals(1, authors.getAuthors().getNames().size());
		assertEquals(TestDataBuilder.TEST_URL_BLOG_AUTHOR, authors.getAuthors().getNames().get(0));
	}

}
