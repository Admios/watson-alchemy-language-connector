/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import org.mule.modules.watsonalchemylanguage.handler.URLCommonHandler;
import org.mule.modules.watsonalchemylanguage.util.Utils;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;

public class CombinedCallHandler extends URLCommonHandler<CombinedCallHandler, CombinedResults> {

	public CombinedCallHandler(AlchemyLanguage service, String source) {
		super(service, source);
	}

	@Override
	public CombinedResults execute() {
		return service.getCombinedResults(params).execute();
	}

	public CombinedCallHandler addExtract(String extract) {
		return addParam(AlchemyLanguage.EXTRACT, extract);
	}

	public CombinedCallHandler addMaxRetrieve(Integer maxRetrieve) {
		return addParam(AlchemyLanguage.MAX_RETRIEVE, maxRetrieve);
	}

	public CombinedCallHandler addAnchorDate(String anchorDate) {
		return addParam(AlchemyLanguage.ANCHOR_DATE, anchorDate);
	}

	public CombinedCallHandler setKeywords(Boolean keywords) {
		return addParam(AlchemyLanguage.KEYWORDS, Utils.intValue(keywords));
	}

	public CombinedCallHandler setEntities(Boolean entities) {
		return addParam(AlchemyLanguage.ENTITIES, Utils.intValue(entities));
	}

	public CombinedCallHandler setRequireEntities(Boolean requireEntities) {
		return addParam(AlchemyLanguage.REQUIRED_ENTITIES, Utils.intValue(requireEntities));
	}

	public CombinedCallHandler addCoreference(Integer coreference) {
		return addParam(AlchemyLanguage.COREFERENCE, coreference);
	}

	public CombinedCallHandler addDisambiguate(Integer disambiguate) {
		return addParam(AlchemyLanguage.DISAMBIGUATE, disambiguate);
	}

	public CombinedCallHandler addKnowledgeGraph(Integer knowledgeGraph) {
		return addParam(AlchemyLanguage.KNOWLEDGE_GRAPH, knowledgeGraph);
	}

	public CombinedCallHandler addLinkedData(Integer linkedData) {
		return addParam(AlchemyLanguage.LINKED_DATA, linkedData);
	}

	public CombinedCallHandler addQuotations(Integer quotations) {
		return addParam(AlchemyLanguage.QUOTATIONS, quotations);
	}

	public CombinedCallHandler addSentiment(Integer sentiment) {
		return addParam(AlchemyLanguage.SENTIMENT, sentiment);
	}

	public CombinedCallHandler addStructuredEntities(Integer structuredEntities) {
		return addParam(AlchemyLanguage.STRUCTURED_ENTITIES, structuredEntities);
	}
}
