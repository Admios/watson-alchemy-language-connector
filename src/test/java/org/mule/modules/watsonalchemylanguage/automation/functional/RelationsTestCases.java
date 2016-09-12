/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.SAORelationsRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.SAORelations;

public class RelationsTestCases extends AbstractTestCases {

	@Test
	public void relationTestUsingURL() {
		
		SAORelations relations = getConnector().relations(buildTestRequestForURL());
		String url = "http://www.admios.com/admios-blog/2016/7/20/build-fast-and-clean-uis-with-angular-material";
		assertNotNull(relations);
		assertEquals("english", relations.getLanguage());
		assertEquals(url, relations.getUrl());
		assertEquals(4, relations.getRelations().size());
		assertEquals("Angular.js", relations.getRelations().get(0).getSubject().getText());
	}

	@Test
	public void relationTestUsingText() {

		String text = "Angular.js has been out there for a while now and is definitely a popular option to take into"
				+ " consideration when selecting a front end technology.";
		SAORelations relations = getConnector().relations(buildTestRequestForText(10));

		assertNotNull(relations);
		assertEquals("english", relations.getLanguage());
		assertEquals(text + "\n", relations.getText());
		assertEquals(3, relations.getRelations().size());
		assertEquals("Angular.js", relations.getRelations().get(0).getSubject().getText());
		assertTrue(relations.getUrl().isEmpty());
	}

	@Test
	public void relationTestUsingTextAndDisambiguate() {
		String text = "Angular.js has been out there for a while now and is definitely a popular option to take into"
				+ " consideration when selecting a front end technology.";
		SAORelations relations = getConnector().relations(buildTestRequestForDisambiguateText(10, true));

		assertNotNull(relations);
		assertEquals("english", relations.getLanguage());
		assertEquals(text + "\n", relations.getText());
		assertEquals(3, relations.getRelations().size());
		assertEquals("Angular.js", relations.getRelations().get(0).getSubject().getText());
		assertTrue(relations.getUrl().isEmpty());
	}
	
	private SAORelationsRequest buildTestRequestForURL() {
		 return new SAORelationsRequest("http://www.admios.com/admios-blog/2016/7/20/build-fast-and-clean-uis-with-angular-material", 
				4, null, null);
	}
	
	private SAORelationsRequest buildTestRequestForText(Integer maxRetrieve) {
		 return new SAORelationsRequest("Angular.js has been out there for a while now and is definitely a popular option to take into"
					+ " consideration when selecting a front end technology.", 
				maxRetrieve, true, null);
	}
	
	private SAORelationsRequest buildTestRequestForDisambiguateText(Integer maxRetrieve, Boolean disambiguate) {
		return new SAORelationsRequest("Angular.js has been out there for a while now and is definitely a popular option to take into"
				+ " consideration when selecting a front end technology.", 
			maxRetrieve, true, true);
	}
}
