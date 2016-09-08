/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for Subject-Action-Object relations operation.
 * 
 * @author Admios
 */
public class SAORelationsRequest {
	
	
	
	public SAORelationsRequest(String source, Integer maxRetrieve, Boolean showSourceText, Boolean disambiguate) {
		super();
		this.source = source;
		this.maxRetrieve = maxRetrieve;
		this.showSourceText = showSourceText;
		this.disambiguate = disambiguate;
	}

	/**
	 * Text or URL to process
	 */
	@Optional
	private String source;

	/**
	 * Maximum number of entities to return (default 50)
	 */
	@Optional 
	private Integer maxRetrieve;

	/**
	 * Set this to 1 to include the source text in the response
	 */
	@Optional 
	private Boolean showSourceText; 

	/**
	 * Check this to identify keywords in detected relations. <b> This incurs in additional 
	 * transaction charge </b>
	 */
	@Optional 
	private Boolean keywords; 

	/**
	 * Check this to identify named entities in detected relations. <b>This incurs in additional
	 * transaction charge</b>
	 */
	@Optional 
	private Boolean entities;

	/**
	 * Check this to restrict results to relations that contain at least one named entity
	 */
	@Optional 
	private Boolean requireEntities; 

	/**
	 * Set this to 0 to treat coreferences as separate entities (coreferences are resolved into
	 * detected default entities
	 */
	@Optional 
	private Boolean coreference; 

	/**
	 * Set this to 0 to hide entity disambiguation information in the response
	 */
	@Optional 
	private Boolean disambiguate;

	/**
	 * Set this to 1 to include knowledge graph information in the results. This incurs an
	 * additional transaction charge
	 */
	@Optional 
	private Boolean knowledgeGraph; 

	/**
	 * Check this to hide Linked Data contents links in the response.
	 */
	@Optional 
	private Boolean hideLinkedData; 

	/**
	 * Check this to analyze the sentiment towards each result.
	 */
	@Optional 
	private Boolean analyzeSentiment;

	/**
	 * Check this to exclude named entity text from sentiment analysis. For
	 *            example, do not analyze "New" in "New York".
	 */
	@FriendlyName("Exclude entity from analysis") 
	@Optional 
	private Boolean excludeEntityFromSentimentAnalysis;

	/**
	 * A visual constraints query to apply to the web page. Required when sourceText is set to cquery
	 */
	@Optional 
	private String cquery; 

	/**
	 * An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 */
	@Optional 
	private String xpath;

	/**
	 * How to obtain the source text from the web page
	 */
	@Optional 
	private String sourceText;

	/**
	 * Text or url to process
	 *
	 * @return Value of the source attribute
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Maximum number of entities to return (default 50)
	 * 
	 * @return Value of the maxRetrieve attribute
	 */
	public Integer getMaxRetrieve() {
		return maxRetrieve;
	}

	/**
	 * Flag value(Boolean) to verify the inclusion of the source text in the response
	 * 
	 * @return Value of the showSourceText attribute
	 */
	public Boolean getShowSourceText() {
		return showSourceText;
	}

	/**
	 * Flag value(Boolean) used to identify keywords in detected relations. <b> This incurs in additional 
	 * transaction charge </b>
	 * 
	 * @return Value of the keywords attribute
	 */
	public Boolean getKeywords() {
		return keywords;
	}

	/**
	 * Flag value(Boolean) used to identify named entities in detected relations. <b>This incurs in additional
	 * transaction charge</b>
	 * 
	 * @return Value of the entities attribute
	 */
	public Boolean getEntities() {
		return entities;
	}

	/**
	 * Flag value(Boolean) used to restrict results to relations that contain at least one named entity
	 * 
	 * @return Value of the requireEntities attribute
	 */
	public Boolean getRequireEntities() {
		return requireEntities;
	}

	/**
	 * Flag value(Boolean) used to the treatment of coreferences as separate entities (coreferences are resolved into
	 * detected default entities)
	 * 
	 * @return Value of the coreference attribute
	 */
	public Boolean getCoreference() {
		return coreference;
	}

	/**
	 * Flag value(boolean) used to hide entity disambiguation information in the response
	 * 
	 * @return Value of the disambiguate attribute
	 */
	public Boolean getDisambiguate() {
		return disambiguate;
	}

	/**
	 * Flag value(Boolean) used to include knowledge graph information in the results. This incurs an
	 * additional transaction charge
	 * 
	 * @return Value of the knowledgeGraph attribute
	 */
	public Boolean getKnowledgeGraph() {
		return knowledgeGraph;
	}

	/**
	 * Check this to hide Linked Data contents links in the response. This is a Boolean value
	 * 
	 * @return Value of the hideLinkedData attribute
	 */
	public Boolean getHideLinkedData() {
		return hideLinkedData;
	}

	/**
	 * Check this to analyze the sentiment towards each result. This is a Boolean value
	 * 
	 * @return Value of the analyzeSentiment attribute
	 */
	public Boolean getAnalyzeSentiment() {
		return analyzeSentiment;
	}

	/**
	 * Check this to exclude named entity text from sentiment analysis. This is a Boolean value. 
	 * 
	 * @return Value of the excludeEntityFromSentimentAnalysis attribute  
	 */
	public Boolean getExcludeEntityFromSentimentAnalysis() {
		return excludeEntityFromSentimentAnalysis;
	}

	/**
	 * A visual constraints query to apply to the web page. Required when sourceText is set to cquery
	 * 
	 * @return Value of the cquery attribute
	 */
	public String getCquery() {
		return cquery;
	}

	/**
	 * An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * 
	 * @return Value of the xpath attribute
	 */
	public String getXpath() {
		return xpath;
	}

	/**
	 * This value describes how to obtain the source text from the web page
	 * 
	 * @return Value of the sourceText attribute
	 */
	public String getSourceText() {
		return sourceText;
	}

	/**
	 * General Setter for source parameter
	 * 
	 * @param String source as an actual parameter representation of the source attribute
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * General Setter for maxRetrieve parameter
	 * 
	 * @param Integer maxRetrieve as an actual parameter representation of the maxRetrieve attribute
	 */
	public void setMaxRetrieve(Integer maxRetrieve) {
		this.maxRetrieve = maxRetrieve;
	}

	/**
	 * General Setter for showSourceText parameter
	 * 
	 * @param Boolean showSourceText as an actual parameter representation of the showSourceText attribute
	 */
	public void setShowSourceText(Boolean showSourceText) {
		this.showSourceText = showSourceText;
	}

	/**
	 * General Setter for keywords parameter
	 * 
	 * @param Boolean keywords as an actual parameter representation of the keywords attribute
	 */
	public void setKeywords(Boolean keywords) {
		this.keywords = keywords;
	}

	/**
	 * General Setter for entities parameter
	 * 
	 * @param Boolean entities as an actual parameter representation of the entities attribute
	 */
	public void setEntities(Boolean entities) {
		this.entities = entities;
	}

	/**
	 * General Setter for requiereEntities parameter
	 * 
	 * @param Boolean requireEntities as an actual parameter representation of the requireEntities attribute
	 */
	public void setRequireEntities(Boolean requireEntities) {
		this.requireEntities = requireEntities;
	}

	/**
	 * General Setter for coreference parameter
	 * 
	 * @param Boolean coreference as an actual parameter representation of the coreference attribute
	 */
	public void setCoreference(Boolean coreference) {
		this.coreference = coreference;
	}

	/**
	 * General Setter for disambiguate parameter
	 * 
	 * @param Boolean disambiguate as an actual parameter representation of the disambiguate attribute
	 */
	public void setDisambiguate(Boolean disambiguate) {
		this.disambiguate = disambiguate;
	}

	/**
	 * General Setter for knowledgeGraph parameter
	 * 
	 * @param Boolean knowledgeGraph as an actual parameter representation of the knowledgeGraph attribute
	 */
	public void setKnowledgeGraph(Boolean knowledgeGraph) {
		this.knowledgeGraph = knowledgeGraph;
	}

	/**
	 * General Setter for hideLinkedData parameter
	 * 
	 * @param Boolean hideLinkedData as an actual parameter representation of the hideLinkedData attribute
	 */
	public void setHideLinkedData(Boolean hideLinkedData) {
		this.hideLinkedData = hideLinkedData;
	}

	/**
	 * General Setter for analyzeSentiment parameter
	 * 
	 * @param Boolean analyzeSentiment as an actual parameter representation of the analyzeSentiment attribute
	 */
	public void setAnalyzeSentiment(Boolean analyzeSentiment) {
		this.analyzeSentiment = analyzeSentiment;
	}

	/**
	 * General Setter for excludeEntityFromSentimentAnalysis parameter
	 * 
	 * @param Boolean excludeEntityFromSentimentAnalysis as an actual parameter representation of 
	 * the excludeEntityFromSentimentAnalysis attribute
	 */
	public void setExcludeEntityFromSentimentAnalysis(Boolean excludeEntityFromSentimentAnalysis) {
		this.excludeEntityFromSentimentAnalysis = excludeEntityFromSentimentAnalysis;
	}

	/**
	 * General Setter for cquery parameter
	 * 
	 * @param String cquery as an actual parameter representation of the cquery attribute
	 */
	public void setCquery(String cquery) {
		this.cquery = cquery;
	}

	/**
	 * General Setter for xpath parameter
	 * 
	 * @param String xpath as an actual parameter representation of the xpath attribute
	 */
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	/**
	 * General Setter for sourceText parameter
	 * 
	 * @param String sourceText as an actual parameter representation of the sourceText attribute
	 */
	public void setSourceText(String sourceText) {
		this.sourceText = sourceText;
	}
	
	
}
