/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import org.mule.modules.watsonalchemylanguage.handler.URLCommonHandler;

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
		return addParam(AlchemyLanguage.MAX_RETRIEVE, maxRetrieve);
	}

	public ConceptsHandler addKnowledgeGraph(Integer knowledgeGraph) {
		return addParam(AlchemyLanguage.KNOWLEDGE_GRAPH, knowledgeGraph);
	}

	public ConceptsHandler addLinkedData(Integer linkedData) {
		return addParam(AlchemyLanguage.LINKED_DATA, linkedData);
	}

}
