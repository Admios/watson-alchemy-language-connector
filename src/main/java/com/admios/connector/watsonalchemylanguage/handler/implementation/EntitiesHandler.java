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
		return addParam(AlchemyLanguage.MAX_RETRIEVE, maxRetrieve);
	}

	public EntitiesHandler addCoreference(Integer coreference) {
		return addParam(AlchemyLanguage.COREFERENCE, coreference);
	}

	public EntitiesHandler addDisambiguate(Integer disambiguate) {
		return addParam(AlchemyLanguage.DISAMBIGUATE, disambiguate);
	}

	public EntitiesHandler addKnowledgeGraph(Integer knowledgeGraph) {
		return addParam(AlchemyLanguage.KNOWLEDGE_GRAPH, knowledgeGraph);
	}

	public EntitiesHandler addLinkedData(Integer linkedData) {
		return addParam(AlchemyLanguage.LINKED_DATA, linkedData);
	}

	public EntitiesHandler addQuotations(Integer quotations) {
		return addParam(AlchemyLanguage.QUOTATIONS, quotations);
	}

	public EntitiesHandler addSentiment(Integer sentiment) {
		return addParam(AlchemyLanguage.SENTIMENT, sentiment);
	}

	public EntitiesHandler addStructuredEntities(Integer structuredEntities) {
		return addParam(AlchemyLanguage.STRUCTURED_ENTITIES, structuredEntities);
	}
}
