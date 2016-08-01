package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;

public class EntitiesHandler extends URLCommonHandler<EntitiesHandler, Entities> {

	public EntitiesHandler(AlchemyLanguage service, String source) {
		super(service, source);
	}

	@Override
	public Entities execute() {
		return service.getEntities(params).execute();
	}

	public EntitiesHandler addMaxRetrieve(Integer maxRetrieve) {
		return (EntitiesHandler) addParam(AlchemyLanguage.MAX_RETRIEVE, maxRetrieve);
	}

	public EntitiesHandler addCoreference(Integer coreference) {
		return (EntitiesHandler) addParam(AlchemyLanguage.COREFERENCE, coreference);
	}

	public EntitiesHandler addDisambiguate(Integer disambiguate) {
		return (EntitiesHandler) addParam(AlchemyLanguage.DISAMBIGUATE, disambiguate);
	}

	public EntitiesHandler addKnowledgeGraph(Integer knowledgeGraph) {
		return (EntitiesHandler) addParam(AlchemyLanguage.KNOWLEDGE_GRAPH, knowledgeGraph);
	}

	public EntitiesHandler addLinkedData(Integer linkedData) {
		return (EntitiesHandler) addParam(AlchemyLanguage.LINKED_DATA, linkedData);
	}

	public EntitiesHandler addQuotations(Integer quotations) {
		return (EntitiesHandler) addParam(AlchemyLanguage.QUOTATIONS, quotations);
	}

	public EntitiesHandler addSentiment(Integer sentiment) {
		return (EntitiesHandler) addParam(AlchemyLanguage.SENTIMENT, sentiment);
	}

	public EntitiesHandler addStructuredEntities(Integer structuredEntities) {
		return (EntitiesHandler) addParam(AlchemyLanguage.STRUCTURED_ENTITIES, structuredEntities);
	}
}
