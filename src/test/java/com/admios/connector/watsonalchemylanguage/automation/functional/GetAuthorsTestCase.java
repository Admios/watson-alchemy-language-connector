package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentAuthors;

public class GetAuthorsTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public GetAuthorsTestCase() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURL() {
		DocumentAuthors authors = getConnector().getAuthors(Constants.TEST_URL_BLOG);

		assertNotNull(authors);
		assertEquals(Constants.TEST_URL_BLOG, authors.getUrl());
		assertEquals(1, authors.getAuthors().getNames().size());
		assertEquals(Constants.TEST_URL_BLOG_AUTHOR, authors.getAuthors().getNames().get(0));
	}

}
