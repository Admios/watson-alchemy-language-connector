package com.admios.connector.watsonalchemylanguage.handler.implementation;

import static com.admios.connector.watsonalchemylanguage.util.Utils.trueToIntValue;
import static com.admios.connector.watsonalchemylanguage.util.Utils.falseToIntValue;
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
		return addParam(AlchemyLanguage.KNOWLEDGE_GRAPH, trueToIntValue(knowledgeGraph));
	}

	public RelationsHandler setSentiment(Boolean sentiment) {
		return addParam(AlchemyLanguage.SENTIMENT, trueToIntValue(sentiment));
	}
	
	public RelationsHandler excludeEntityFromSentimentAnalysis(Boolean excludeSentiments) {
		return addParam(AlchemyLanguage.SENTIMENT_EXCLUDE_ENTITIES, trueToIntValue(excludeSentiments));
	}
	
	public RelationsHandler setKeywords(Boolean keywords) {
		return addParam(AlchemyLanguage.KEYWORDS, trueToIntValue(keywords));
	}
	
	public RelationsHandler setEntities(Boolean entities) {
		return addParam(AlchemyLanguage.ENTITIES, trueToIntValue(entities));
	}
	
	public RelationsHandler setRequireEntities(Boolean requireEntities) {
		return addParam(AlchemyLanguage.REQUIRED_ENTITIES, trueToIntValue(requireEntities));
	}
	
	public RelationsHandler setCoreferences(Boolean coreference) {
		return addParam(AlchemyLanguage.COREFERENCE, falseToIntValue(coreference));
	}
	
	public RelationsHandler setDisambiguate(Boolean disambiguate) {
		return addParam(AlchemyLanguage.DISAMBIGUATE, falseToIntValue(disambiguate));
	}
	
	public RelationsHandler hideLinkedData(Boolean linkedData) {
		return addParam(AlchemyLanguage.LINKED_DATA, falseToIntValue(linkedData));
	}
	
	@Override
	public SAORelations execute() {
		return service.getRelations(params).execute();
	}

}
