package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Feeds;

public class FeedDetectionTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector>{
	
	public FeedDetectionTestCase(){
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void getFeedsTest() {
		Feeds result = getConnector().feedDetection("http://news.ycombinator.com");
		
		assertNotNull(result);
		assertEquals(1, result.getFeeds().size());
		assertEquals("https://news.ycombinator.com/", result.getUrl());
		assertEquals("https://news.ycombinator.com/rss", result.getFeeds().get(0).getFeed());
	}
}
