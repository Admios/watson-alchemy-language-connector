package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
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
