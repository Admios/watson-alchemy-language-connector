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
	 * Check this to identify keywords in detected relations. <b> This incurs in additional transaction charge </b>
	 */
	@Optional
	private Boolean keywords;

	/**
	 * Check this to identify named entities in detected relations. <b>This incurs in additional transaction charge</b>
	 */
	@Optional
	private Boolean entities;

	/**
	 * Check this to restrict results to relations that contain at least one named entity
	 */
	@Optional
	private Boolean requireEntities;

	/**
	 * Set this to 0 to treat coreferences as separate entities (coreferences are resolved into detected default
	 * entities
	 */
	@Optional
	private Boolean coreference;

	/**
	 * Set this to 0 to hide entity disambiguation information in the response
	 */
	@Optional
	private Boolean disambiguate;

	/**
	 * Set this to 1 to include knowledge graph information in the results. This incurs an additional transaction charge
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
	 * Check this to exclude named entity text from sentiment analysis. For example, do not analyze "New" in "New York".
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

	public SAORelationsRequest() {
	}

	public SAORelationsRequest(String source, Integer maxRetrieve, Boolean showSourceText, Boolean disambiguate) {
		super();
		this.source = source;
		this.maxRetrieve = maxRetrieve;
		this.showSourceText = showSourceText;
		this.disambiguate = disambiguate;
	}

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
	 * Flag value(Boolean) used to identify keywords in detected relations. <b> This incurs in additional transaction
	 * charge </b>
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
	 * Flag value(Boolean) used to include knowledge graph information in the results. This incurs an additional
	 * transaction charge
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
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @param maxRetrieve the maxRetrieve to set
	 */
	public void setMaxRetrieve(Integer maxRetrieve) {
		this.maxRetrieve = maxRetrieve;
	}

	/**
	 * @param showSourceText the showSourceText to set
	 */
	public void setShowSourceText(Boolean showSourceText) {
		this.showSourceText = showSourceText;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Boolean keywords) {
		this.keywords = keywords;
	}

	/**
	 * @param entities the entities to set
	 */
	public void setEntities(Boolean entities) {
		this.entities = entities;
	}

	/**
	 * @param requireEntities the requireEntities to set
	 */
	public void setRequireEntities(Boolean requireEntities) {
		this.requireEntities = requireEntities;
	}

	/**
	 * @param coreference the coreference to set
	 */
	public void setCoreference(Boolean coreference) {
		this.coreference = coreference;
	}

	/**
	 * @param disambiguate the disambiguate to set
	 */
	public void setDisambiguate(Boolean disambiguate) {
		this.disambiguate = disambiguate;
	}

	/**
	 * @param knowledgeGraph the knowledgeGraph to set
	 */
	public void setKnowledgeGraph(Boolean knowledgeGraph) {
		this.knowledgeGraph = knowledgeGraph;
	}

	/**
	 * @param hideLinkedData the hideLinkedData to set
	 */
	public void setHideLinkedData(Boolean hideLinkedData) {
		this.hideLinkedData = hideLinkedData;
	}

	/**
	 * @param analyzeSentiment the analyzeSentiment to set
	 */
	public void setAnalyzeSentiment(Boolean analyzeSentiment) {
		this.analyzeSentiment = analyzeSentiment;
	}

	/**
	 * @param excludeEntityFromSentimentAnalysis the excludeEntityFromSentimentAnalysis to set
	 */
	public void setExcludeEntityFromSentimentAnalysis(Boolean excludeEntityFromSentimentAnalysis) {
		this.excludeEntityFromSentimentAnalysis = excludeEntityFromSentimentAnalysis;
	}

	/**
	 * @param cquery the cquery to set
	 */
	public void setCquery(String cquery) {
		this.cquery = cquery;
	}

	/**
	 * @param xpath the xpath to set
	 */
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	/**
	 * @param sourceText the sourceText to set
	 */
	public void setSourceText(String sourceText) {
		this.sourceText = sourceText;
	}

}
