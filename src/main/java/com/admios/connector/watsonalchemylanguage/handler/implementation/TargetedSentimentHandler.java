package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class TargetedSentimentHandler extends URLCommonHandler<TargetedSentimentHandler, DocumentSentiment> {

	public TargetedSentimentHandler (AlchemyLanguage service, String source) {
		super(service, source);
	}
	
	public TargetedSentimentHandler addTarget(String target) {
		return addParam(AlchemyLanguage.TARGET, target);
	}

	@Override
	public DocumentSentiment execute() {
		return service.getSentiment(params).execute();
	}

}
