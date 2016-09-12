/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ibm.watson.developer_cloud.alchemy.v1.model.Feeds;

public class FeedDetectionTestCases extends AbstractTestCases {

	@Test
	public void getFeedsTest() {
		Feeds result = getConnector().feedDetection("http://news.ycombinator.com");

		assertNotNull(result);
		assertEquals(1, result.getFeeds().size());
		assertEquals("https://news.ycombinator.com/", result.getUrl());
		assertEquals("https://news.ycombinator.com/rss", result.getFeeds().get(0).getFeed());
	}
}
