/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import org.mule.modules.watsonalchemylanguage.handler.CommonHandler;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Feeds;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;

public class FeedDetectionHandler extends CommonHandler<Feeds> {
	
	public FeedDetectionHandler (AlchemyLanguage service, String text) {
		super(service, AlchemyLanguage.URL, text);
	}
	
	@Override
	public Feeds execute() throws BadRequestException {
		return service.getFeeds(params).execute();
	}
}
