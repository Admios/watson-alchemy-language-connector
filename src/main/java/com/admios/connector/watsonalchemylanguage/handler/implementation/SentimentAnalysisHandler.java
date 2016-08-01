package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class SentimentAnalysisHandler extends URLCommonHandler<SentimentAnalysisHandler, DocumentSentiment> {

	public SentimentAnalysisHandler(AlchemyLanguage service, String source) {
		super(service, source);
	}

	@Override
	public DocumentSentiment execute() {
		return service.getSentiment(params).execute();
	}

}
