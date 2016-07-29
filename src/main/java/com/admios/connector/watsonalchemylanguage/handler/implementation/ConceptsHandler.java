package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;

public class ConceptsHandler extends URLCommonHandler<ConceptsHandler, Concepts> {

	public ConceptsHandler(AlchemyLanguage service, String source) {
		super(service, source);
	}

	@Override
	public Concepts execute() {
		return service.getConcepts(params).execute();
	}

	public ConceptsHandler addMaxRetrieve(Integer maxRetrieve) {
		return (ConceptsHandler) addParam(AlchemyLanguage.MAX_RETRIEVE, maxRetrieve);
	}

	public ConceptsHandler addKnowledgeGraph(Integer knowledgeGraph) {
		return (ConceptsHandler) addParam(AlchemyLanguage.KNOWLEDGE_GRAPH, knowledgeGraph);
	}

	public ConceptsHandler addLinkedData(Integer linkedData) {
		return (ConceptsHandler) addParam(AlchemyLanguage.LINKED_DATA, linkedData);
	}

}
