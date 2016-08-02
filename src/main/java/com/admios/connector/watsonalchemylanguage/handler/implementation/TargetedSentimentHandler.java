package com.admios.connector.watsonalchemylanguage.handler.implementation;

import java.util.List;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class TargetedSentimentHandler extends URLCommonHandler<TargetedSentimentHandler, DocumentSentiment> {

	public TargetedSentimentHandler (AlchemyLanguage service, String source) {
		super(service, source);
	}
	
	/**
	 * Set targets, override previous array.
	 * @param targets
	 * @return
	 */
	public TargetedSentimentHandler addTargets(List<String> targets){
		return addParam(AlchemyLanguage.TARGETS, targets.toArray(new String[0]));
	}
	
	@Override
	public DocumentSentiment execute() {
		
		return service.getSentiment(params).execute();
	}

}
