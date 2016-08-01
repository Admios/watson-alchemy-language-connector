package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;

public class KeywordsHandler extends URLCommonHandler<KeywordsHandler,Keywords> {

	public KeywordsHandler(AlchemyLanguage service, String text) {
		super(service, text);
	}

	public KeywordsHandler addMaxRetrieve(Integer maxRetrieve) {
		return addParam(AlchemyLanguage.MAX_RETRIEVE, maxRetrieve);
	}

	public KeywordsHandler addKnowledgeGraph(Integer knowledgeGraph) {
		return addParam(AlchemyLanguage.KNOWLEDGE_GRAPH, knowledgeGraph);
	}

	public KeywordsHandler addSentiment(Integer sentiment) {
		return addParam(AlchemyLanguage.SENTIMENT, sentiment);
	}

	@Override
	public Keywords execute() {
		return service.getKeywords(params).execute();
	}

}
