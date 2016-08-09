package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;

public class TaxonomyTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector> {
	
	public TaxonomyTestCase() {
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void testWithURL() {
		Taxonomies taxonomies = getConnector().getTaxonomies(Constants.GITHUB_URL_BLOG, null, null, null, null);
		
		assertNotNull(taxonomies);
		assertEquals(Constants.TEST_URL_BLOG, taxonomies.getUrl());
		assertFalse(taxonomies.getTaxonomy().isEmpty());
	}
	
	
}
