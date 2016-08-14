package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;

public class EmotionalAnalysisHandler extends URLCommonHandler<EmotionalAnalysisHandler, DocumentEmotion>{

	public EmotionalAnalysisHandler(AlchemyLanguage service, String source) {
		super(service, source);
	}

	@Override
	public DocumentEmotion execute() {
		return service.getEmotion(params).execute();
	}

}
