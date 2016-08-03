package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
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
