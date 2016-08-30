/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage;

import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.ReconnectOn;
import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.licensing.RequiresEnterpriseLicense;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.watsonalchemylanguage.config.Config;
import org.mule.modules.watsonalchemylanguage.handler.implementation.AuthorsHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.CombinedCallHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.ConceptsHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.DateExtractionHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.EmotionalAnalysisHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.EntitiesHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.FeedDetectionHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.KeywordsHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.LanguageDetectionHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.MicroformatsHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.PublicationDateHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.RelationsHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.SentimentAnalysisHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.TargetedSentimentHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.TaxonomyHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.TextExtractionHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.TitleExtractionHandler;
import org.mule.modules.watsonalchemylanguage.handler.implementation.TypedRelationsHandler;

import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;
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
import com.ibm.watson.developer_cloud.alchemy.v1.model.SAORelations;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;
import com.ibm.watson.developer_cloud.service.exception.ServiceUnavailableException;

/**
 * The IBM Watson™ AlchemyLanguage service is a collection of text analysis functions that derive semantic information
 * from your content. You can input text, HTML, or a public URL and leverage sophisticated natural language processing
 * techniques to get a quick high-level understanding of your content and obtain detailed insights such as sentiment for
 * detected entities and keywords.
 * 
 * @author Admios
 */
@RequiresEnterpriseLicense(allowEval = true)
@ReconnectOn(exceptions = { ServiceUnavailableException.class })
@Connector(name = "watson-alchemy-language", friendlyName = "Watson AlchemyLanguage Service", minMuleVersion = "3.6.0")
public class WatsonAlchemyLanguageConnector {

	@org.mule.api.annotations.Config
	Config config;

	/**
	 * Get author names from a webpage or HTML content.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#authors}
	 *
	 * @param source The HTML or url to process
	 * @return return A list of extracted {@link DocumentAuthors}
	 */
	@Processor
	public DocumentAuthors authors(@Default("#[payload]") String source) {
		return new AuthorsHandler(config.getService(), source).execute();
	}

	/**
	 * Extract entities from a text or a webpage.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#entities}
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
	 * @param showSourceText Check this to include the source text in the response
	 * @param structuredEntities Set this to 0 to ignore structured entities, such as Quantity, EmailAddress,
	 *            TwitterHandle, Hashtag, and IPAddress
	 * @param cquery A visual constraints query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText How to obtain the source text from the webpage
	 * 
	 * @return return {@link Entities}
	 */
	@Processor
	public Entities entities(@Default("#[payload]") String source, @Optional Integer maxRetrieve,
			@Optional Integer coreference, @Optional Integer disambiguate, @Optional Integer knowledgeGraph,
			@Optional Integer linkedData, @Optional Integer quotations, @Optional Integer sentiment,
			@Optional Boolean showSourceText, @Optional Integer structuredEntities,
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
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#date-extraction}
	 *
	 * @param source The text, html or url to process.
	 * @param anchorDate The date to use as "today" when interpreting phrases in the text like "next tuesday." Format:
	 *            <code>yyyy-mm-dd hh:mm:ss</code>
	 * @param showSourceText Check this to include the source text in the response.
	 * @return return {@link Dates}
	 */
	@Processor
	public Dates dateExtraction(@Default("#[payload]") String source, @Optional String anchorDate,
			@Optional Boolean showSourceText) {
		return new DateExtractionHandler(config.getService(), source)
				.addAnchorDate(anchorDate)
				.addShowSourceText(showSourceText)
				.execute();
	}

	/**
	 * Get feeds from a url.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#feed-detection}
	 *
	 * @param url The <code>URL</code> to process.
	 * @return return {@link Feeds}
	 */
	@Processor
	public Feeds feedDetection(@Default("#[payload]") String url) {
		return new FeedDetectionHandler(config.getService(), url)
				.execute();
	}

	/**
	 * Extract concepts from a webpage or plain text.
	 *
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#concepts}
	 *
	 * @param source The text or url to process
	 * @param maxRetrieve Maximum number of entities to return (default = 50) detected entities by default)
	 * @param knowledgeGraph Set this to 1 to include knowledge graph information in the results. This incurs an
	 *            additional transaction charge
	 * @param linkedData Set this to 0 to hide Linked Data content links in the response
	 * @param showSourceText Check this to include the source text in the response TwitterHandle, Hashtag, and IPAddress
	 * @param cquery A visual constraints query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText How to obtain the source text from the webpage
	 * 
	 * @return return {@link Concepts}
	 */
	@Processor
	public Concepts concepts(@Default("#[payload]") String source, @Optional Integer maxRetrieve,
			@Optional Integer knowledgeGraph, @Optional Integer linkedData,
			@Optional Boolean showSourceText, @Optional String cquery,
			@Optional String xpath, @Optional String sourceText) {

		return new ConceptsHandler(config.getService(), source).addMaxRetrieve(maxRetrieve)
				.addKnowledgeGraph(knowledgeGraph).addLinkedData(linkedData)
				.addShowSourceText(showSourceText).addCquery(cquery).addXpath(xpath)
				.addSourceText(sourceText).execute();
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	/**
	 * Analyze sentiment for targeted phrases in a webpage, HTML, or plain text. Supported languages: Arabic, English,
	 * French, German, Italian, Portuguese, Russian, Spanish.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#targeted-sentiment}
	 *
	 * @param source The text, HTML or URL to process.
	 * @param target Target phrase. The service will return sentiment information for the phrase that is found in the
	 *            source text.
	 * @param target Target phrase. The service will return sentiment information for the phrase that is found in the
	 *            source text.
	 * @param showSourceText Check this to include the source text in the response.
	 * @param cquery A visual constraints query to apply to the web page. Required when <code>sourceText</code> is set
	 *            to cquery.
	 * @param xpath An XPath query to apply to the web page. Required when <code>sourceText</code> is set to one of the
	 *            XPath values.
	 * @param sourceText How to obtain the source text from the webpage.
	 * @return return {@link DocumentSentiment}
	 */
	@Processor
	public DocumentSentiment targetedSentiment(@Default("#[payload]") String source, String target,
			@Optional Boolean showSourceText, @Optional String cquery, @Optional String xpath,
			@Optional String sourceText) {
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
	 * @param source The text, HTML or URL to process.
	 * @param maxRetrieve Maximum number of entities to return (default = 50) detected entities by default).
	 * @param knowledgeGraph Set this to 1 to include knowledge graph information in the results.
	 * @param sentiment Set this to 1 to analyze the sentiment towards each detected entity.
	 * @param showSourceText Check this to include the source text in the response.
	 * @param cquery A visual constraints query to apply to the web page. Required when <code>sourceText</code> is set
	 *            to cquery.
	 * @param xpath An XPath query to apply to the web page. Required when <code>sourceText</code> is set to one of the
	 *            XPath values.
	 * @param sourceText How to obtain the source text from the webpage.
	 * @return return {@link Keywords}
	 */
	@Processor
	public Keywords keywords(@Default("#[payload]") String source, @Optional Integer maxRetrieve,
			@Optional Integer knowledgeGraph, @Optional Integer sentiment, @Optional Boolean showSourceText,
			@Optional String cquery, @Optional String xpath, @Optional String sourceText) {
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
	 * @param source The text, html or url to process.
	 * @param showSourceText Check this to include the source text in the response.
	 * @return return {@link Microformats}
	 */
	@Processor
	public Microformats microformats(@Default("#[payload]") String source, @Optional Boolean showSourceText) {
		return new MicroformatsHandler(config.getService(), source).addShowSourceText(showSourceText).execute();
	}

	/**
	 * Extract Subject-Action-Object relations from a webpage, HTML, or plain text. Supported languages: English,
	 * Spanish
	 *
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#microformats}
	 * 
	 * @param source One of these is required. Pass HTML content in html, a public facing URL in url, or plain text in
	 *            text.
	 * @param maxRetrieve Maximum number of relations to return (default = 50, maximum = 100)
	 * @param showSourceText Check this to include the source text in the response.
	 * @param keywords Check this to identify keywords in detected relations. <b>This incurs an additional transaction
	 *            charge</b>
	 * @param entities Check this to identify named entities in detected relations. <b>This incurs an additional
	 *            transaction charge.</b>
	 * @param requireEntities Check this to restrict results to relations that contain at least one named entity.
	 * @param coreference Check this treat coreferences as separate entities (coreferences are resolved into detected
	 *            entities by default).
	 * @param disambiguate Check this to hide entity disambiguation information in the response.
	 * @param knowledgeGraph Check this to include knowledge graph information in the results. <b>This incurs an
	 *            additional transaction charge.</b>
	 * @param hideLinkedData Check this to hide Linked Data contents links in the response.
	 * @param analyzeSentiment Check this to analyze the sentiment towards each result.
	 * @param excludeEntityFromSentimentAnalysis Check this to exclude named entity text from sentiment analysis. For
	 *            exapmle, do not analyze "New" in "New York".
	 * @param showSourceTex Check this to include the source text in the response.
	 * @param cquery A visual constraints query to apply to the web page. Required when sourceText is set to cquery.
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values.
	 * @param sourceText How to obtain the source text from the web page.
	 * @return return an array of detected relations.
	 */
	@Processor
	public SAORelations relations(@Default("#[payload]") String source, @Optional Integer maxRetrieve,
			@Optional Boolean showSourceText, @Optional Boolean keywords, @Optional Boolean entities,
			@Optional Boolean requireEntities, @Optional Boolean coreference, @Optional Boolean disambiguate,
			@Optional Boolean knowledgeGraph, @Optional Boolean hideLinkedData, @Optional Boolean analyzeSentiment,
			@FriendlyName("Exclude entity from analysis") @Optional Boolean excludeEntityFromSentimentAnalysis,
			@Optional String cquery, @Optional String xpath, @Optional String sourceText) {
		return new RelationsHandler(config.getService(), source)
				.addMaxRetrieve(maxRetrieve)
				.addShowSourceText(showSourceText)
				.setKeywords(keywords)
				.setEntities(entities)
				.setRequireEntities(requireEntities)
				.setCoreferences(coreference)
				.setDisambiguate(disambiguate)
				.setKnowledgeGraph(knowledgeGraph)
				.hideLinkedData(hideLinkedData)
				.setSentiment(analyzeSentiment)
				.excludeEntityFromSentimentAnalysis(excludeEntityFromSentimentAnalysis)
				.addCquery(cquery).addXpath(xpath)
				.addSourceText(sourceText)
				.execute();

	}

	/**
	 * Get the publication date of a webpage or HTML document.
	 *
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#publication_date}
	 * 
	 * @param source The HTML or url to process
	 * @return return {@link DocumentPublicationDate}
	 */
	@Processor
	public DocumentPublicationDate publicationDate(@Default("#[payload]") String source) {
		return new PublicationDateHandler(config.getService(), source).execute();
	}

	/**
	 * Analyze the overall sentiment of a webpage, HTML, or plain text.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#sentiment}
	 *
	 * @param source The text, HTML document or url to process
	 * @param showSourceText Check this to include the source text in the response
	 * @param cquery A visual constraints query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText How to obtain the source text from the webpage
	 * 
	 * @return return {@link DocumentSentiment}
	 */
	@Processor
	public DocumentSentiment sentimentAnalysis(@Default("#[payload]") String source, @Optional Boolean showSourceText,
			@Optional String cquery, @Optional String xpath, @Optional String sourceText) {
		return new SentimentAnalysisHandler(config.getService(), source).addShowSourceText(showSourceText)
				.addCquery(cquery).addXpath(xpath).addSourceText(sourceText).execute();
	}

	/**
	 * Use custom models to identify typed relations between detected entities from a webpage, HTML, or plain text.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#typed_relations}
	 *
	 * @param source The text, HTML document or url to process
	 * @param model The unique alphanumeric identifier for your custom model
	 * @param showSourceText Check this to include the source text in the response
	 * 
	 * @return return {@link TypedRelations}
	 */
	@Processor
	public TypedRelations typedRelations(@Default("#[payload]") String source, @Optional String model,
			@Optional Boolean showSourceText) {
		return new TypedRelationsHandler(config.getService(), source).addModel(model)
				.addShowSourceText(showSourceText).execute();
	}

	/**
	 * Detect the language of a webpage, HTML, or plain text.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#language}
	 *
	 * @param source The text, HTML or URL to process.
	 * @param showSourceText Check this to include the source text in the response.
	 * @param cquery A visual constraints query to apply to the web page. Required when <code>sourceText</code> is set
	 *            to cquery.
	 * @param xpath An XPath query to apply to the web page. Required when <code>sourceText</code> is set to one of the
	 *            XPath values.
	 * @param sourceText How to obtain the source text from the webpage.
	 * 
	 * @return return {@link Language}
	 */
	@Processor
	public Language languageDetection(@Default("#[payload]") String source, @Optional Boolean showSourceText,
			@Optional String cquery, @Optional String xpath, @Optional String sourceText) {
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
	 * @param source The HTML or URL to process.
	 * @param showSourceText Check this to include the source text in the response.
	 * 
	 * @return return {@link DocumentTitle}
	 */
	@Processor
	public DocumentTitle titleExtraction(@Default("#[payload]") String source, @Optional Boolean showSourceText) {
		return new TitleExtractionHandler(config.getService(), source)
				.addShowSourceText(showSourceText)
				.execute();
	}

	/**
	 * Extract the main body text from a webpage or HTML.
	 * 
	 * API Doc: {@see https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#text_cleaned}
	 * 
	 * @param source The HTML or URL to process.
	 * @param cquery A visual constraint query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText Determines how to obtain the source text from the webpage
	 * @param extractLinks Set this to 1 to include hyperlinks in the extracted text
	 * @param useMetadata Set this to 0 to ignore description information in webpage metadata
	 * 
	 * @param useMetaData Comment for useMetaData
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
	 * Extract the main body raw text from a webpage or HTML.
	 * 
	 * API Doc: {@see https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#text_raw}
	 * 
	 * @param source The HTML or URL to process.
	 * 
	 * @return return {@link DocumentText}
	 */
	@Processor
	public DocumentText rawTextExtraction(String source) {
		return new TextExtractionHandler(config.getService(), source).execute();
	}

	/**
	 * Categorize a webpage into a 5-level taxonomy
	 * 
	 * API Doc: {@see https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#taxonomy}
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
	public Taxonomies taxonomies(String source, @Optional Boolean showSourceText,
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
	 * @param source The HTML or URL to process.
	 * @param cquery A visual constraint query to apply to the web page. Required when sourceText is set to cquery
	 * @param xpath An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * @param sourceText Determines how to obtain the source text from the webpage
	 * @param showSourceText Set this to 1 to include the source text in the response
	 * 
	 * @return return {@link DocumentEmotion}
	 */
	@Processor
	public DocumentEmotion emotionAnalysis(String source, @Optional Boolean showSourceText,
			@Optional String cquery, @Optional String xpath, @Optional String sourceText) {
		return new EmotionalAnalysisHandler(config.getService(), source)
				.addCquery(cquery)
				.addShowSourceText(showSourceText)
				.addSourceText(sourceText)
				.addXpath(xpath).execute();
	}

	/**
	 * Analyze text, HTML, or webpage content with multiple text analysis operations. Any parameters for the extract
	 * methods can also be passed.
	 * 
	 * API Doc: {@see http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#combined-call}
	 *
	 * @param source The text or url to process
	 * @param extract Comma separated list of any of the following methods: authors, concepts (default), dates,
	 *            doc-emotion, entities (default), feeds, keywords (default), pub-date, relations, typed-rels,
	 *            doc-sentiment, taxonomy (default), title
	 * @param maxRetrieve Maximum number of entities to return (default = 50)
	 * @param anchorDate The date to use as "today" when interpreting phrases in the text like "next tuesday.". Format:
	 *            yyyy-mm-dd hh:mm:ss
	 * @param keywords Check this to identify keywords in detected relations. <b>This incurs an additional transaction
	 *            charge</b>
	 * @param entities Check this to identify named entities in detected relations. <b>This incurs an additional
	 *            transaction charge.</b>
	 * @param requireEntities Check this to restrict results to relations that contain at least one named entity.
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
	 * @return return {@link CombinedResults}
	 */
	@Processor
	public CombinedResults combinedCall(@Default("#[payload]") String source, @Optional String extract,
			@Optional Integer maxRetrieve, @Optional Boolean keywords, @Optional Boolean entities,
			@Optional Boolean requireEntities, @Optional Integer coreference, @Optional Integer disambiguate,
			@Optional Integer knowledgeGraph, @Optional Integer linkedData, @Optional Integer quotations,
			@Optional Integer sentiment, @Optional Boolean showSourceText, @Optional Integer structuredEntities,
			@Optional String anchorDate, @Optional String cquery, @Optional String xpath, @Optional String sourceText) {

		return new CombinedCallHandler(config.getService(), source).addExtract(extract).addAnchorDate(anchorDate)
				.addMaxRetrieve(maxRetrieve).addCoreference(coreference).addDisambiguate(disambiguate)
				.setKeywords(keywords).setEntities(entities).setRequireEntities(requireEntities)
				.addKnowledgeGraph(knowledgeGraph).addLinkedData(linkedData).addQuotations(quotations)
				.addSentiment(sentiment).addShowSourceText(showSourceText).addStructuredEntities(structuredEntities)
				.addCquery(cquery).addXpath(xpath).addSourceText(sourceText).execute();
	}

}