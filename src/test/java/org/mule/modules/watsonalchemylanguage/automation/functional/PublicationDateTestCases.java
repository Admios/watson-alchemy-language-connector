package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentPublicationDate;

public class PublicationDateTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public PublicationDateTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURL() {
		DocumentPublicationDate publicationDate = getConnector().publicationDate(TestDataBuilder.TEST_URL_BLOG);

		assertNotNull(publicationDate);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, publicationDate.getUrl());
		assertEquals(TestDataBuilder.TEST_URL_BLOG_PUBLICATION_DATE,
				new SimpleDateFormat("yyyyMMdd").format(publicationDate.getPublicationDate().getDate()));
	}

}
