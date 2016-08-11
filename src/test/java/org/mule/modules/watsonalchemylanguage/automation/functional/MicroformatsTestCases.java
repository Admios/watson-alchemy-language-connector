package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Microformats;

public class MicroformatsTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public MicroformatsTestCases () {
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void getMicroformatsUsingURL() {
		
		Microformats results = getConnector().microformats("http://microformats.org/wiki/hcard", null);
		
		assertNotNull(results);
		assertEquals("http://microformats.org/wiki/hcard", results.getUrl());
		assertFalse(results.getMicroformats().isEmpty());
		
	}

}