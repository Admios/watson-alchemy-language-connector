/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import org.mule.modules.watsonalchemylanguage.handler.URLCommonHandler;

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
