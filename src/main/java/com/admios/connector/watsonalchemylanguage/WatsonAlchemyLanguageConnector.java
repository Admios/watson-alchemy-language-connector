package com.admios.connector.watsonalchemylanguage;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Optional;

import com.admios.connector.watsonalchemylanguage.config.ConnectorConfig;
import com.admios.connector.watsonalchemylanguage.handler.implementation.AuthorsHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.ConceptsHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.DateExtractionHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.EmotionalAnalysisHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.EntitiesHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.FeedDetectionHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.KeywordsHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.LanguageDetectionHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.MicroformatsHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.PublicationDateHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.SentimentAnalysisHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.TargetedSentimentHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.TaxonomyHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.TextExtractionHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.TitleExtractionHandler;
import com.admios.connector.watsonalchemylanguage.handler.implementation.TypedRelationsHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentAuthors;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentPublicationDate;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentTitle;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Feeds;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Language;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Microformats;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;

@Connector(name = "watson-alchemy-language", friendlyName = "Watson AlchemyLanguage Service")
public class WatsonAlchemyLanguageConnector {

	@Config
	ConnectorConfig config;

	/**
	 * Get author names from a webpage or HTML content.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#authors}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:getAuthors}
	 *
	 * @param source The HTML or url to process
	 * @return return A list of extracted {@link DocumentAuthors}
	 */
	@Processor
	public DocumentAuthors authors(String source) {
		return new AuthorsHandler(config.getService(), source).execute();
	}

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
	 * @return return {@link Entities}
	 */
	@Processor
	public Entities entities(String source, @Optional Integer maxRetrieve,
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
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:date-extraction}
	 *
	 * @param source The text, html or url to process.
	 * @param anchorDate The date to use as "today" when interpreting phrases in the text like "next tuesday." Format:
	 *            <code>yyyy-mm-dd hh:mm:ss</code>
	 * @param showSourceText Set this to 1 to include the source text in the response.
	 * @return return {@link Dates}
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
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:feed-detection}
	 *
	 * @param url The <code>URL</code> to process.
	 * @return return {@link Feeds}
	 */
	@Processor
	public Feeds feedDetection(String url) {
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
	 * @return return {@link Concepts}
	 */
	@Processor
	public Concepts concepts(String source, @Optional Integer maxRetrieve,
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
	
	/**
	 * Analyze sentiment for targeted phrases in a webpage, HTML, or plain text. 
	 * Supported languages: Arabic, English, French, German, Italian, Portuguese, Russian, Spanish.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#targeted_sentiment}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:targeted-sentiments}
	 *
	 * @param source The text, HTML or URL to process.
	 * @param target Target phrase. The service will return sentiment information for the phrase that is found
	 *            in the source text.
	 * @param showSourceText Set this to 1 to include the source text in the response.
	 * @param cquery A visual constraints query to apply to the web page. Required when <code>sourceText</code> is set
	 *            to cquery.
	 * @param xpath An XPath query to apply to the web page. Required when <code>sourceText</code> is set to one of the
	 *            XPath values.
	 * @param sourceText How to obtain the source text from the webpage.
	 * @return return {@link DocumentSentiment}
	 */
	@Processor
	public DocumentSentiment targetedSentiment(String source, String target, 
			@Optional Integer showSourceText, @Optional String cquery,
			@Optional String xpath, @Optional String sourceText) {
		return new TargetedSentimentHandler(config.getService(), source)
				.addCquery(cquery)
				.addShowSourceText(showSourceText)
				.addTarget(target)
				.addXpath(xpath)
				.addSourceText(sourceText)
				.execute();
	}

	/**
	 * Extract keywords from a webpages, HTML or plain text.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#keywords}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:keywords}
	 *
	 * @param source The text, HTML or URL to process.
	 * @param maxRetrieve Maximum number of entities to return (default = 50) detected entities by default).
	 * @param knowledgeGraph Set this to 1 to include knowledge graph information in the results.
	 * @param sentiment Set this to 1 to analyze the sentiment towards each detected entity.
	 * @param showSourceText Set this to 1 to include the source text in the response.
	 * @param cquery A visual constraints query to apply to the web page. Required when <code>sourceText</code> is set
	 *            to cquery.
	 * @param xpath An XPath query to apply to the web page. Required when <code>sourceText</code> is set to one of the
	 *            XPath values.
	 * @param sourceText How to obtain the source text from the webpage.
	 * @return return {@link Keywords}
	 */
	@Processor
	public Keywords keywords(String source, @Optional Integer maxRetrieve,
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

	/**
	 * Get Microformats from a text, webpage or content in an url.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#microformats}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:microformats}
	 *
	 * @param source The text, html or url to process.
	 * @param showSourceText Set this to 1 to include the source text in the response.
	 * @return return {@link Microformats}
	 */
	@Processor
	public Microformats microformats(String source, @Optional Integer showSourceText) {
		return new MicroformatsHandler(config.getService(), source).addShowSourceText(showSourceText).execute();
	}

	/**
	 * Get the publication date of a webpage or HTML document.
	 *
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#publication_date}
	 * 
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:publicationDate}
	 *
	 * @param source The HTML or url to process
	 * @return return {@link DocumentPublicationDate}
	 */
	@Processor
	public DocumentPublicationDate publicationDate(String source) {
		return new PublicationDateHandler(config.getService(), source).execute();
	}

	/**
	 * Analyze the overall sentiment of a webpage, HTML, or plain text.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#sentiment}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:sentimentAnalysis}
	 *
	 * @param source The text, HTML document or url to process
	 * @param showSourceText Set this to 1 to include the source text in the response
	 * @param cquery A visual constraints query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText How to obtain the source text from the webpage
	 * 
	 * @return return {@link DocumentSentiment}
	 */
	@Processor
	public DocumentSentiment sentimentAnalysis(String source, @Optional Integer showSourceText, @Optional String cquery,
			@Optional String xpath, @Optional String sourceText) {
		return new SentimentAnalysisHandler(config.getService(), source).addShowSourceText(showSourceText)
				.addCquery(cquery).addXpath(xpath).addSourceText(sourceText).execute();
	}

	/**
	 * Use custom models to identify typed relations between detected entities from a webpage, HTML, or plain text.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#typed_relations}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:typedRelations}
	 *
	 * @param source The text, HTML document or url to process
	 * @param model The unique alphanumeric identifier for your custom model
	 * @param showSourceText Set this to 1 to include the source text in the response
	 * 
	 * @return return {@link TypedRelations}
	 */
	@Processor
	public TypedRelations typedRelations(String source, @Optional String model, @Optional Integer showSourceText) {
		return new TypedRelationsHandler(config.getService(), source).addModel(model)
				.addShowSourceText(showSourceText).execute();
	}

	/**
	 * Detect the language of a webpage, HTML, or plain text.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#language}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:languageDetection}
	 *
	 * @param source The text, HTML or URL to process.
	 * @param showSourceText Set this to 1 to include the source text in the response.
	 * @param cquery A visual constraints query to apply to the web page. Required when <code>sourceText</code> is set
	 *            to cquery.
	 * @param xpath An XPath query to apply to the web page. Required when <code>sourceText</code> is set to one of the
	 *            XPath values.
	 * @param sourceText How to obtain the source text from the webpage.
	 * 
	 * @return return {@link Language}
	 */
	@Processor
	public Language languageDetection(String source, @Optional Integer showSourceText, @Optional String cquery,
			@Optional String xpath, @Optional String sourceText) {
		return new LanguageDetectionHandler(config.getService(), source)
				.addShowSourceText(showSourceText)
				.addCquery(cquery)
				.addXpath(xpath)
				.addSourceText(sourceText)
				.execute();
	}

	/**
	 * Extract the page title from a webpage or HTML.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#title_extraction}
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample watson-alchemy-language:titleExtraction}
	 *
	 * @param source The HTML or URL to process.
	 * @param showSourceText Set this to 1 to include the source text in the response.
	 * 
	 * @return return {@link DocumentTitle}
	 */
	@Processor
	public DocumentTitle titleExtraction(String source, @Optional Integer showSourceText) {
		return new TitleExtractionHandler(config.getService(), source)
				.addShowSourceText(showSourceText)
				.execute();
	}
	
	/**
	 * Extract the main body text from a webpage or HTML.
	 * 
	 * API Doc: {@see https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#text_cleaned}
	 *
	 *
	 * @param source The HTML or URL to process.
	 * @param cquery A visual constraint query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText Determines how to obtain the source text from the webpage
	 * @param extractLinks Set this to 1 to include hyperlinks in the extracted text
	 * @param useMetadata Set this to 0 to ignore description information in webpage metadata 
	 * 
	 * @return return {@link DocumentText}
	 */
	@Processor
	public DocumentText textExtraction(String source, @Optional String cquery,
			@Optional String xpath, @Optional String sourceText, 
			@Optional String extractLinks, @Optional String useMetaData) {
		return new TextExtractionHandler(config.getService(), source)
				.addCquery(cquery)
				.addSourceText(sourceText)
				.addXpath(xpath)
				.addExtractLinks(extractLinks)
				.addUseMetadata(useMetaData).execute();			
	}
	
	/**
	 * Categorize a webpage into a 5-level taxonomy
	 * 
	 * API Doc: {@see https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#taxonomy}
	 *
	 *
	 * @param source The HTML or URL to process.
	 * @param cquery A visual constraint query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText Determines how to obtain the source text from the webpage
	 * @param showSourceText Set this to 1 to include the source text in the response 
	 * 
	 * @return return {@link Taxonomies}
	 */
	@Processor
	public Taxonomies getTaxonomies(String source, @Optional Integer showSourceText,
			@Optional String cquery, @Optional String xpath, @Optional String sourceText) {
		return new TaxonomyHandler(config.getService(), source)
				.addShowSourceText(showSourceText)
				.addCquery(cquery)
				.addSourceText(sourceText)
				.addXpath(xpath)
				.addCquery(cquery).execute();
	}
	
	/**
	 * Detect emotions implied in the text of a webpage
	 * 
	 * API Doc: {@see https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#emotion_analysis}
	 *
	 *
	 * @param source The HTML or URL to process.
	 * @param cquery A visual constraint query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText Determines how to obtain the source text from the webpage
	 * @param showSourceText Set this to 1 to include the source text in the response 
	 * 
	 * @return return {@link DocumentEmotion}
	 */
	@Processor
	public DocumentEmotion EmotionAnalysis(String source, @Optional Integer showSourceText,
			@Optional String cquery, @Optional String xpath, @Optional String sourceText) {
		return new EmotionalAnalysisHandler(config.getService(), source)
				.addCquery(cquery)
				.addShowSourceText(showSourceText)
				.addSourceText(sourceText)
				.addXpath(xpath).execute();
	}

}