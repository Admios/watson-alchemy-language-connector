package com.admios.connector.watsonalchemylanguage;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Optional;

import com.admios.connector.watsonalchemylanguage.config.ConnectorConfig;
import com.admios.connector.watsonalchemylanguage.handler.implementation.DateExtractionHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.EntitiesHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.FeedDetectionHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.KeywordsHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates;
import com.admios.connector.watsonalchemylanguage.handler.implementation.ConceptsHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.EntitiesHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Feeds;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;

@Connector(name = "watson-alchemy-language", friendlyName = "Watson AlchemyLanguage Service")
public class WatsonAlchemyLanguageConnector {

	@Config
	ConnectorConfig config;

	/**
	 * Extract entities from a text or a webpage.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#entities}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:getEntities}
	 *
	 * @param source The text or url to process
	 * @param maxRetrieve Maximum number of entities to return (default = 50)
	 * @param coreference Set this to 0 to treat coreferences as separate entities (coreferences are resolved into
	 *            detected entities by default)
	 * @param disambiguate Set this to 0 to hide entity disambiguation information in the response
	 * @param knowledgeGraph Set this to 1 to include knowledge graph information in the results. This incurs an
	 *            additional transaction charge
	 * @param linkedData Set this to 0 to hide Linked Data content links in the response
	 * @param quotations Set this to 1 to include quotations that are linked to detected entities
	 * @param sentiment Set this to 1 to analyze the sentiment towards each detected entity. This incurs an additional
	 *            transaction charge
	 * @param showSourceText Set this to 1 to include the source text in the response
	 * @param structuredEntities Set this to 0 to ignore structured entities, such as Quantity, EmailAddress,
	 *            TwitterHandle, Hashtag, and IPAddress
	 * @param cquery A visual constraints query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText How to obtain the source text from the webpage
	 * 
	 * @return return Entities
	 */
	@Processor
	public Entities getEntities(String source, @Optional Integer maxRetrieve,
			@Optional Integer coreference, @Optional Integer disambiguate, @Optional Integer knowledgeGraph,
			@Optional Integer linkedData, @Optional Integer quotations, @Optional Integer sentiment,
			@Optional Integer showSourceText, @Optional Integer structuredEntities,
			@Optional String cquery, @Optional String xpath, @Optional String sourceText) {

		return new EntitiesHandler(config.getService(), source)
				.addMaxRetrieve(maxRetrieve).addCoreference(coreference).addDisambiguate(disambiguate)
				.addKnowledgeGraph(knowledgeGraph).addLinkedData(linkedData).addQuotations(quotations)
				.addSentiment(sentiment).addShowSourceText(showSourceText).addStructuredEntities(structuredEntities)
				.addCquery(cquery).addXpath(xpath).addSourceText(sourceText).execute();
	}
	
	
	/**
	 * Extract Dates from a text, webpage or content in an url.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#date_extraction}
	 *
	 *
	 * @param source The text, html or url to process.
	 */
	@Processor
	public Dates dateExtraction(String source, @Optional String anchorDate, @Optional Integer showSourceText) {
		return new DateExtractionHandler(config.getService(), source)
				.addAnchorDate(anchorDate)
				.addShowSourceText(showSourceText)
				.execute();
	}
	
	/**
	 * Get feeds from a url.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#feed_detection}
	 *
	 *
	 * @param url The url to process.
	 */
	@Processor
	public Feeds feedDetection(String url){
		return new FeedDetectionHandler(config.getService(), url)
				.execute();
	}

	/**
	 * Extract concepts from a webpage or plain text.
	 *
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#concepts}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:getConcepts}
	 *
	 * @param source The text or url to process
	 * @param maxRetrieve Maximum number of entities to return (default = 50) detected entities by default)
	 * @param knowledgeGraph Set this to 1 to include knowledge graph information in the results. This incurs an
	 *            additional transaction charge
	 * @param linkedData Set this to 0 to hide Linked Data content links in the response
	 * @param showSourceText Set this to 1 to include the source text in the response TwitterHandle, Hashtag, and
	 *            IPAddress
	 * @param cquery A visual constraints query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText How to obtain the source text from the webpage
	 * 
	 * @return return Concepts
	 */
	@Processor
	public Concepts getConcepts(String source, @Optional Integer maxRetrieve,
			@Optional Integer knowledgeGraph, @Optional Integer linkedData,
			@Optional Integer showSourceText, @Optional String cquery,
			@Optional String xpath, @Optional String sourceText) {

		return new ConceptsHandler(config.getService(), source).addMaxRetrieve(maxRetrieve)
				.addKnowledgeGraph(knowledgeGraph).addLinkedData(linkedData)
				.addShowSourceText(showSourceText).addCquery(cquery).addXpath(xpath)
				.addSourceText(sourceText).execute();
	}

	public ConnectorConfig getConfig() {
		return config;
	}

	public void setConfig(ConnectorConfig config) {
		this.config = config;
	}

	@Processor
	public Keywords getKeywords(String source, @Optional Integer maxRetrieve,
			@Optional Integer knowledgeGraph, @Optional Integer sentiment,
			@Optional Integer showSourceText, @Optional String cquery,
			@Optional String xpath, @Optional String sourceText) {
		return new KeywordsHandler(config.getService(), source)
				.addCquery(cquery)
				.addKnowledgeGraph(knowledgeGraph)
				.addMaxRetrieve(maxRetrieve)
				.addSentiment(sentiment)
				.addShowSourceText(showSourceText)
				.addXpath(xpath)
				.execute();
	}

}