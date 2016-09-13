/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage;

import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.ReconnectOn;
import org.mule.api.annotations.licensing.RequiresEnterpriseLicense;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.param.RefOnly;
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
import org.mule.modules.watsonalchemylanguage.model.CombinedCallRequest;
import org.mule.modules.watsonalchemylanguage.model.ConceptsRequest;
import org.mule.modules.watsonalchemylanguage.model.DateExtractionRequest;
import org.mule.modules.watsonalchemylanguage.model.EmotionAnalysisRequest;
import org.mule.modules.watsonalchemylanguage.model.EntitiesRequest;
import org.mule.modules.watsonalchemylanguage.model.KeywordsRequest;
import org.mule.modules.watsonalchemylanguage.model.LanguageDetectionRequest;
import org.mule.modules.watsonalchemylanguage.model.MicroformatsRequest;
import org.mule.modules.watsonalchemylanguage.model.SAORelationsRequest;
import org.mule.modules.watsonalchemylanguage.model.SentimentAnalysisRequest;
import org.mule.modules.watsonalchemylanguage.model.TargetedSentimentRequest;
import org.mule.modules.watsonalchemylanguage.model.TaxonomiesRequest;
import org.mule.modules.watsonalchemylanguage.model.TextExtractionRequest;
import org.mule.modules.watsonalchemylanguage.model.TitleExtractionRequest;
import org.mule.modules.watsonalchemylanguage.model.TypedRelationsRequest;
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

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	/**
	 * Get author names from a web page or HTML content.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#authors">API Doc</a>
	 *
	 * @param source The HTML or URL to process
	 * @return A list of detected authors in a web page or HTML content.
	 */
	@Processor
	public DocumentAuthors authors(@Default("#[payload]") String source) {
		return new AuthorsHandler(config.getService(), source).execute();
	}

	/**
	 * Extract entities from a text, web page or HTML content.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#entities">API Doc</a>
	 *
	 * @param request Request with all the options for entities operation.
	 * 
	 * @return A list of detected entities in a text, web page or HTML content.
	 */
	@Processor
	public Entities entities(@RefOnly @Default("#[payload]") EntitiesRequest request) {

		return new EntitiesHandler(config.getService(), request.getSource())
				.addMaxRetrieve(request.getMaxRetrieve())
				.addCoreference(request.getCoreference())
				.addDisambiguate(request.getDisambiguate())
				.addKnowledgeGraph(request.getKnowledgeGraph())
				.addLinkedData(request.getLinkedData())
				.addQuotations(request.getQuotations())
				.addSentiment(request.getSentiment())
				.addShowSourceText(request.getShowSourceText())
				.addStructuredEntities(request.getStructuredEntities())
				.addCquery(request.getCquery())
				.addXpath(request.getXpath())
				.addSourceText(request.getSourceText())
				.execute();
	}

	/**
	 * Extract Dates from a text, web page or content in an URL.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#date-extraction">API Doc</a>
	 *
	 * @param request Request with all the options for a date extraction operation.
	 * 
	 * @return A list of detected dates in the text, web page or HTML content.
	 */
	@Processor
	public Dates dateExtraction(@RefOnly @Default("#[payload]") DateExtractionRequest request) {
		return new DateExtractionHandler(config.getService(), request.getSource())
				.addAnchorDate(request.getAnchorDate())
				.addShowSourceText(request.getShowSourceText())
				.execute();
	}

	/**
	 * Get feeds from a url.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#feed-detection">API Doc</a>
	 *
	 * @param url The <code>URL</code> to process.
	 * 
	 * @return A list of detected RSS/ATOM links in web page.
	 */
	@Processor
	public Feeds feedDetection(@Default("#[payload]") String url) {
		return new FeedDetectionHandler(config.getService(), url)
				.execute();
	}

	/**
	 * Extract concepts from a web page or plain text.
	 *
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#concepts">API Doc</a>
	 * 
	 * @param request Request with all the options for a concept operation.
	 * @return A list of detected high level concepts used in the text, web page or HTML content.
	 */
	@Processor
	public Concepts concepts(@RefOnly @Default("#[payload]") ConceptsRequest request) {
		return new ConceptsHandler(config.getService(), request.getSource())
				.addCquery(request.getCquery())
				.addKnowledgeGraph(request.getKnowledgeGraph())
				.addLinkedData(request.getLinkedData())
				.addMaxRetrieve(request.getMaxRetrieve())
				.addShowSourceText(request.getShowSourceText())
				.addSourceText(request.getSourceText())
				.addXpath(request.getXpath()).execute();
	}

	/**
	 * Analyze sentiment for targeted phrases in a web page, HTML, or plain text. Supported languages: Arabic, English,
	 * French, German, Italian, Portuguese, Russian, Spanish.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#targeted-sentiment">API Doc</a>
	 *
	 * @param request Request with all the options for the targeted sentiment operation.
	 * 
	 * @return The sentiment expressed in the targeted phrase in the text, web page or HTML content.
	 */
	@Processor
	public DocumentSentiment targetedSentiment(@RefOnly @Default("#[payload]") TargetedSentimentRequest request) {
		return new TargetedSentimentHandler(config.getService(), request.getSource())
				.addCquery(request.getCquery())
				.addShowSourceText(request.getShowSourceText())
				.addTarget(request.getTarget())
				.addXpath(request.getXpath())
				.addSourceText(request.getSourceText())
				.execute();
	}

	/**
	 * Extract keywords from a web pages, HTML or plain text.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#keywords">API Doc</a>
	 *
	 * @param request Request with all the options for the keywords operation.
	 * 
	 * @return A list of detected keywords in a text, web page or HTML content.
	 */
	@Processor
	public Keywords keywords(@RefOnly @Default("#[payload]") KeywordsRequest request) {
		return new KeywordsHandler(config.getService(), request.getSource())
				.addCquery(request.getCquery())
				.addKnowledgeGraph(request.getKnowledgeGraph())
				.addMaxRetrieve(request.getMaxRetrieve())
				.addSentiment(request.getSentiment())
				.addShowSourceText(request.getShowSourceText())
				.addXpath(request.getXpath())
				.execute();
	}

	/**
	 * Get Microformats from a text, web page or content in an URL.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#microformats">API Doc</a>
	 *
	 * @param request Request with all the options for the microformats operation.
	 * 
	 * @return A list of detected microformats in a text, web page or HTML content.
	 */
	@Processor
	public Microformats microformats(@RefOnly @Default("#[payload]") MicroformatsRequest request) {
		return new MicroformatsHandler(config.getService(), request.getSource())
				.addShowSourceText(request.getShowSourceText()).execute();
	}

	/**
	 * Extract Subject-Action-Object relations from a web page, HTML, or plain text. Supported languages: English,
	 * Spanish
	 *
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#microformats">API Doc</a>
	 * 
	 * @param request Request with all the options for the Subject-Action-Object relations operation.
	 * 
	 * @return A list of detected Subject-Action-Object relations in the text, web page or HTML content.
	 */
	@Processor
	public SAORelations relations(@RefOnly @Default("#[payload]") SAORelationsRequest request) {
		return new RelationsHandler(config.getService(), request.getSource())
				.addMaxRetrieve(request.getMaxRetrieve())
				.addShowSourceText(request.getShowSourceText())
				.setKeywords(request.getKeywords())
				.setEntities(request.getEntities())
				.setRequireEntities(request.getEntities())
				.setCoreferences(request.getCoreference())
				.setDisambiguate(request.getDisambiguate())
				.setKnowledgeGraph(request.getKnowledgeGraph())
				.hideLinkedData(request.getHideLinkedData())
				.setSentiment(request.getAnalyzeSentiment())
				.excludeEntityFromSentimentAnalysis(request.getExcludeEntityFromSentimentAnalysis())
				.addCquery(request.getCquery()).addXpath(request.getXpath())
				.addSourceText(request.getSourceText())
				.execute();

	}

	/**
	 * Get the publication date of a web page or HTML document.
	 *
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#publication_date">API Doc</a>
	 * 
	 * @param source The HTML or URL to process
	 * 
	 * @return The publication date of the web page or HTML content.
	 */
	@Processor
	public DocumentPublicationDate publicationDate(@Default("#[payload]") String source) {
		return new PublicationDateHandler(config.getService(), source).execute();
	}

	/**
	 * Analyze the overall sentiment of a web page, HTML, or plain text.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#sentiment">API Doc</a>
	 *
	 * @param request Request with all the options for the sentiment analysis operation.
	 * 
	 * @return The general sentiment expressed in the text, web page or HTML content.
	 */
	@Processor
	public DocumentSentiment sentimentAnalysis(@RefOnly @Default("#[payload]") SentimentAnalysisRequest request) {
		return new SentimentAnalysisHandler(config.getService(), request.getSource())
				.addShowSourceText(request.getShowSourceText())
				.addCquery(request.getCquery())
				.addXpath(request.getXpath())
				.addSourceText(request.getSourceText()).execute();
	}

	/**
	 * Use custom models to identify typed relations between detected entities from a web page, HTML, or plain text.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#typed_relations">API Doc</a>
	 *
	 * @param request Request with all the options for the typed relations operation.
	 * 
	 * @return A list of detected Subject-Action-Object relations in the text, web page or HTML content.
	 */
	@Processor
	public TypedRelations typedRelations(@RefOnly @Default("#[payload]") TypedRelationsRequest request) {
		return new TypedRelationsHandler(config.getService(), request.getSource())
				.addModel(request.getModel())
				.addShowSourceText(request.getShowSourceText()).execute();
	}

	/**
	 * Detect the language of a web page, HTML, or plain text.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#language">API Doc</a>
	 *
	 * @param request Request with all the options for the language detection operation.
	 * 
	 * @return The detected languages in a text, web page or HTML content.
	 */
	@Processor
	public Language languageDetection(@RefOnly @Default("#[payload]") LanguageDetectionRequest request) {
		return new LanguageDetectionHandler(config.getService(), request.getSource())
				.addShowSourceText(request.getShowSourceText())
				.addCquery(request.getCquery())
				.addXpath(request.getXpath())
				.addSourceText(request.getSourceText())
				.execute();
	}

	/**
	 * Extract the page title from a web page or HTML.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#title_extraction">API Doc</a>
	 *
	 * @param request Request with all the options for the title extraction operation.
	 * 
	 * @return The title of the web page or HTML content.
	 */
	@Processor
	public DocumentTitle titleExtraction(@RefOnly @Default("#[payload]") TitleExtractionRequest request) {
		return new TitleExtractionHandler(config.getService(), request.getSource())
				.addShowSourceText(request.getShowSourceText())
				.execute();
	}

	/**
	 * Extract the main body text from a web page or HTML.
	 * 
	 * <a href="https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#text_cleaned">API Doc</a>
	 * 
	 * @param request Request with all the options for the text extraction operation.
	 * 
	 * @return The extracted text.
	 */
	@Processor
	public DocumentText textExtraction(@RefOnly @Default("#[payload]") TextExtractionRequest request) {
		return new TextExtractionHandler(config.getService(), request.getSource())
				.addCquery(request.getCquery())
				.addSourceText(request.getSourceText())
				.addXpath(request.getXpath())
				.addExtractLinks(request.getExtractLinks())
				.addUseMetadata(request.getUseMetaData()).execute();
	}

	/**
	 * Extract the main body raw text from a web page or HTML.
	 * 
	 * <a href="https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#text_raw">API Doc</a>
	 * 
	 * @param source The HTML or URL to process.
	 * 
	 * @return The extracted text.
	 */
	@Processor
	public DocumentText rawTextExtraction(@Default("#[payload]") String source) {
		return new TextExtractionHandler(config.getService(), source).execute();
	}

	/**
	 * Categorize a web page into a 5-level taxonomy
	 * 
	 * <a href="https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#taxonomy">API Doc</a>
	 * 
	 * @param request Request with all the options for the taxonomies operation.
	 * 
	 * @return A list of detected taxonomies in the text, web page or HTML content.
	 */
	@Processor
	public Taxonomies taxonomies(@RefOnly @Default("#[payload]") TaxonomiesRequest request) {
		return new TaxonomyHandler(config.getService(), request.getSource())
				.addShowSourceText(request.getShowSourceText())
				.addCquery(request.getCquery())
				.addSourceText(request.getSourceText())
				.addXpath(request.getXpath())
				.addCquery(request.getCquery()).execute();
	}

	/**
	 * Detect emotions implied in the text of a web page
	 * 
	 * <a href="https://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#emotion_analysis">API Doc</a>
	 * 
	 * @param request Request with all the options for the emotion analysis operation.
	 * 
	 * @return A list of all the detected emotions in the text, web page or HTML content.
	 */
	@Processor
	public DocumentEmotion emotionAnalysis(@RefOnly @Default("#[payload]") EmotionAnalysisRequest request) {
		return new EmotionalAnalysisHandler(config.getService(), request.getSource())
				.addCquery(request.getCquery())
				.addShowSourceText(request.getShowSourceText())
				.addSourceText(request.getSourceText())
				.addXpath(request.getXpath()).execute();
	}

	/**
	 * Analyze text, HTML, or web page content with multiple text analysis operations. Any parameters for the extract
	 * methods can also be passed.
	 * 
	 * <a href="http://www.ibm.com/watson/developercloud/alchemy-language/api/v1/#combined-call">API Doc</a>
	 * 
	 * @param request Request with all the options for a combine call operation.
	 * 
	 * @return The combined results for all the operations specified in the extract parameter.
	 */
	@Processor
	public CombinedResults combinedCall(@RefOnly @Default("#[payload]") CombinedCallRequest request) {
		return new CombinedCallHandler(config.getService(), request.getSource())
				.addExtract(request.getExtract())
				.addAnchorDate(request.getAnchorDate())
				.addMaxRetrieve(request.getMaxRetrieve())
				.addCoreference(request.getCoreference())
				.addDisambiguate(request.getDisambiguate())
				.setEntities(request.getEntities())
				.setRequireEntities(request.getRequireEntities())
				.addKnowledgeGraph(request.getKnowledgeGraph())
				.addLinkedData(request.getLinkedData())
				.addQuotations(request.getQuotations())
				.addSentiment(request.getSentiment())
				.addStructuredEntities(request.getStructuredEntities())
				.addCquery(request.getCquery())
				.addShowSourceText(request.getShowSourceText())
				.addSourceText(request.getSourceText())
				.addXpath(request.getXpath())
				.execute();
	}
}