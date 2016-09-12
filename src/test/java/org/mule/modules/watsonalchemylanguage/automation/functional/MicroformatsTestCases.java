/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.MicroformatsRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.Microformats;

public class MicroformatsTestCases extends AbstractTestCases {

	@Test
	public void getMicroformatsUsingURL() {

		Microformats results = getConnector().microformats(buildBasicRequest());

		assertNotNull(results);
		assertEquals("http://microformats.org/wiki/hcard", results.getUrl());
		assertFalse(results.getMicroformats().isEmpty());

	}

	private MicroformatsRequest buildBasicRequest() {
		return new MicroformatsRequest("http://microformats.org/wiki/hcard", false);
	}

}