/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.TaxonomiesRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomy;

public class TaxonomiesTestCases extends AbstractTestCases {

	@Test
	public void testWithURL() {
		Taxonomies taxonomies = getConnector().taxonomies(buildBasicRequest());

		assertNotNull(taxonomies);
		assertEquals(TestDataBuilder.TEST_URL_BLOG, taxonomies.getUrl());
		testPrecenseOf(taxonomies.getTaxonomy(), TestDataBuilder.TEST_URL_BLOG_TAXONOMY_1,
				TestDataBuilder.TEST_URL_BLOG_TAXONOMY_2, TestDataBuilder.TEST_URL_BLOG_TAXONOMY_3);
	}

	private void testPrecenseOf(List<Taxonomy> taxonomies, String... taxonomiesExpected) {
		String flatTaxonomies = StringUtils.join(taxonomiesExpected, ",");
		int cont = 0;
		for (Taxonomy taxonomy : taxonomies) {
			if (flatTaxonomies.contains(taxonomy.getLabel())) {
				cont++;
			}
		}
		assertEquals(String.format("The response doesn't contains all the expect taxonomies: %s", flatTaxonomies),
				taxonomiesExpected.length, cont);
	}

	private TaxonomiesRequest buildBasicRequest() {
		return new TaxonomiesRequest(TestDataBuilder.TEST_URL_BLOG);
	}
}
