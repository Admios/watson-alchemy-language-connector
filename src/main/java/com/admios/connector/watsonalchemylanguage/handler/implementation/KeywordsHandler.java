package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;

public class KeywordsHandler extends CommonHandler<Keywords> {

	public KeywordsHandler(AlchemyLanguage service, String text) {
		super(service, StringUtils.getType(text), text);
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

	public KeywordsHandler addShowSourceText(Integer showSourceText) {
		return addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, showSourceText);
	}

	public KeywordsHandler addCquery(String cquery) {
		return addParam(AlchemyLanguage.CQUERY, cquery);
	}

	public KeywordsHandler addXpath(String xpath) {
		return addParam(AlchemyLanguage.XPATH, xpath);
	}

	public KeywordsHandler addSourceText(String sourceText) {
		return addParam(AlchemyLanguage.SOURCE_TEXT, sourceText);
	}

	@Override
	public Keywords execute() {
		return service.getKeywords(params).execute();
	}

}
