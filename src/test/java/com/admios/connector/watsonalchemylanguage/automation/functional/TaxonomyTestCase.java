package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.automation.global.Constants;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomy;

public class TaxonomyTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector> {
	
	public TaxonomyTestCase() {
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void testWithURL() {
		Taxonomies taxonomies = getConnector().taxonomies(Constants.TEST_URL_BLOG, null, null, null, null);
				
		assertNotNull(taxonomies);
		assertEquals(Constants.TEST_URL_BLOG, taxonomies.getUrl());
		assertFalse(!taxonomies.getTaxonomy().containsAll(buildTaxonomy()));
	}
	
	public List<Taxonomy> buildTaxonomy() {
		List<Taxonomy> auxContainer = new ArrayList<>();
		Taxonomy auxTaxonomy1 = new Taxonomy();
		Taxonomy auxTaxonomy2 = new Taxonomy();
		Taxonomy auxTaxonomy3 = new Taxonomy();
		auxTaxonomy1.setConfident(null);
		auxTaxonomy1.setLabel("/art and entertainment/visual art and design/design");
		auxTaxonomy1.setScore(0.544901);
		auxContainer.add(auxTaxonomy1);
		
		auxTaxonomy2.setConfident(false);
		auxTaxonomy2.setLabel("/technology and computing/software/graphics software/animation");
		auxTaxonomy2.setScore(0.313632);
		auxContainer.add(auxTaxonomy2);
		
		auxTaxonomy3.setConfident(false);
		auxTaxonomy3.setLabel("/law, govt and politics/government");
		auxTaxonomy3.setScore(0.305536);
		auxContainer.add(auxTaxonomy3);
		
		return auxContainer;
	}	
}
