package com.admios.connector.watsonalchemylanguage.handler.implementation;

import java.util.List;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class TargetedSentimentHandler extends URLCommonHandler<TargetedSentimentHandler, DocumentSentiment> {

	public TargetedSentimentHandler (AlchemyLanguage service, String source) {
		super(service, source);
	}
	
	public TargetedSentimentHandler addTargets(List<String> targets){
		return addParam(AlchemyLanguage.TARGETS, targets);
	}
	
	@Override
	public DocumentSentiment execute() {
		
		return service.getSentiment(params).execute();
	}

}
