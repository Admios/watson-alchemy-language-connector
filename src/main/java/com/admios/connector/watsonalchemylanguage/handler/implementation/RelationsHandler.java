package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.SAORelations;

public class RelationsHandler extends URLCommonHandler<RelationsHandler, SAORelations> {

	public RelationsHandler(AlchemyLanguage service, String source){
		super(service, source);
	}
	
	public RelationsHandler addMaxRetrieve(Integer maxRetrieve) {
		return addParam(AlchemyLanguage.MAX_RETRIEVE, maxRetrieve);
	}

	public RelationsHandler turnOnKnowledgeGraph(Boolean bool) {
		return addParam(AlchemyLanguage.KNOWLEDGE_GRAPH, bool? 1: 0);
	}

	public RelationsHandler turnOnSentiment(Boolean bool) {
		return addParam(AlchemyLanguage.SENTIMENT, bool? 1: 0);
	}
	
	public RelationsHandler turnOnKeywords(Boolean bool) {
		return addParam(AlchemyLanguage.KEYWORDS, bool? 1: 0);
	}
	
	public RelationsHandler turnOnEntities(Boolean bool) {
		return addParam(AlchemyLanguage.ENTITIES, bool? 1: 0);
	}
	
	public RelationsHandler turnOnRequireEntities(Boolean bool) {
		return addParam(AlchemyLanguage.REQUIRED_ENTITIES, bool? 1: 0);
	}
	
	public RelationsHandler turnOnCoreferences(Boolean bool) {
		return addParam(AlchemyLanguage.COREFERENCE, bool? 1: 0);
	}
	
	public RelationsHandler turnOnDisambiguate(Boolean bool) {
		return addParam(AlchemyLanguage.DISAMBIGUATE, bool? 1: 0);
	}
	
	public RelationsHandler showLinkedData(Boolean bool) {
		return addParam(AlchemyLanguage.LINKED_DATA, bool? 1: 0);
	}
	
	public RelationsHandler excludeEntityFromSentimentAnalysis(Boolean bool) {
		return addParam(AlchemyLanguage.SENTIMENT_EXCLUDE_ENTITIES, bool? 1: 0);
	}
	
	public RelationsHandler addShowSourceText(Boolean bool) {
		return addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, bool? 1: 0);
	}
	
	@Override
	public SAORelations execute() {
		return service.getRelations(params).execute();
	}

}
