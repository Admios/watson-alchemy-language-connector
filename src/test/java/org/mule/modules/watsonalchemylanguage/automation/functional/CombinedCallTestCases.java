package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import org.mule.modules.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;

public class CombinedCallTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public CombinedCallTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void testWithURL() {
		CombinedResults results = getConnector().combinedCall(Constants.TEST_URL_BLOG, "title,pub-date", 10,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

		assertNotNull(results);
		assertNotNull(results.getTitle());
		assertEquals(Constants.TEST_URL_BLOG_TITLE, results.getTitle());

		assertNotNull(results.getPublicationDate());
		assertEquals(Constants.TEST_URL_BLOG_PUBLICATION_DATE,
				new SimpleDateFormat("yyyyMMdd").format(results.getPublicationDate().getDate()));
	}

}
