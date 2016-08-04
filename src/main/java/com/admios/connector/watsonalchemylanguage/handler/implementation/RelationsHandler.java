package com.admios.connector.watsonalchemylanguage.handler.implementation;

import static com.admios.connector.watsonalchemylanguage.util.Utils.intValue;
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

	public RelationsHandler setKnowledgeGraph(Boolean knowledgeGraph) {
		return addParam(AlchemyLanguage.KNOWLEDGE_GRAPH, intValue(knowledgeGraph));
	}

	public RelationsHandler setSentiment(Boolean sentiment) {
		return addParam(AlchemyLanguage.SENTIMENT, intValue(sentiment));
	}
	
	public RelationsHandler excludeEntityFromSentimentAnalysis(Boolean excludeSentiments) {
		return addParam(AlchemyLanguage.SENTIMENT_EXCLUDE_ENTITIES, intValue(excludeSentiments));
	}
	
	public RelationsHandler setKeywords(Boolean keywords) {
		return addParam(AlchemyLanguage.KEYWORDS, intValue(keywords));
	}
	
	public RelationsHandler setEntities(Boolean entities) {
		return addParam(AlchemyLanguage.ENTITIES, intValue(entities));
	}
	
	public RelationsHandler setRequireEntities(Boolean requireEntities) {
		return addParam(AlchemyLanguage.REQUIRED_ENTITIES, intValue(requireEntities));
	}
	
	public RelationsHandler setCoreferences(Boolean coreference) {
		return addParam(AlchemyLanguage.COREFERENCE, intValue(!coreference));
	}
	
	public RelationsHandler setDisambiguate(Boolean disambiguate) {
		return addParam(AlchemyLanguage.DISAMBIGUATE, intValue(!disambiguate));
	}
	
	public RelationsHandler hideLinkedData(Boolean linkedData) {
		return addParam(AlchemyLanguage.LINKED_DATA, intValue(!linkedData));
	}
	
	@Override
	public SAORelations execute() {
		return service.getRelations(params).execute();
	}

}
