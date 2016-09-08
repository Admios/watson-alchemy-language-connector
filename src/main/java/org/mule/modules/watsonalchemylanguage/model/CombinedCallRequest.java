/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Optional;


/**
 * Class with all the options for a combine call operation.
 * 
 * @author Admios
 */
public class CombinedCallRequest {

	/**
	 * Text or URL to process
	 */
	@Optional
	private String source;
	
	/**
	 * Set this to 1 to include the source text in the response
	 */
	@Optional
	private Boolean showSourceText;
	
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
	 * Comma separated list of any of the following methods: authors, concepts (default),
	 * dates, doc-emotion, entities (default), pub-date, relations, typed-relations, doc sentiment,
	 * taxonomy (default), title
	 */
	@Optional
	private String extract;
	
	/**
	 * Maximum number of entities to return (default 50)
	 */
	@Optional
	private Integer maxRetrieve;
	
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
	private Integer coreference;
	
	/**
	 * Set this to 0 to hide entity disambiguation information in the response
	 */
	@Optional
	private Integer disambiguate;
	
	/**
	 * Set this to 1 to include knowledge graph information in the results. This incurs an
	 * additional transaction charge
	 */
	@Optional
	private Integer knowledgeGraph;
	
	/**
	 * Set this to 0 to hide Linked Data content links in the response
	 */
	@Optional
	private Integer linkedData;
	
	/**
	 * Set this to 1 to include quotations that are linked to detected entities
	 */
	@Optional
	private Integer quotations;
	
	/**
	 * Set this to 1 to analyze the sentiment towards each detected entity. This incurs an additional
	 * transaction charge
	 */
	@Optional 
	private Integer sentiment;
	
	/**
	 * Set this to 0 to ignore structured entities, such as Quantity, EmailAddress,
	 * TwitterHandle, Hashtag, and IPAddress
	 */
	@Optional 
	private Integer structuredEntities;
	
	/**
	 * The date to use as "today" when interpreting phrases in the text like "next tuesday.". 
	 * Format: yyyy-mm-dd hh:mm:ss 
	 */
	@Optional
	private String anchorDate;

	/**
	 * Text or URL to process
	 *
	 * @return Value of the source attribute
	 */
	public String getSource() {
		return source;
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
	 * Comma separated list of any of the following methods: authors, concepts (default),
	 * dates, doc-emotion, entities (default), pub-date, relations, typed-relations, doc sentiment,
	 * taxonomy (default), title
	 * 
	 * @return Value of the extract attribute
	 */
	public String getExtract() {
		return extract;
	}

	/**
	 * General Setter for extract parameter
	 * 
	 * @param String extract is an actual parameter representation of the extract attribute
	 */
	public void setExtract(String extract) {
		this.extract = extract;
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
	 * General Setter for maxRetrieve parameter
	 * 
	 * @param Integer maxRetrieve as an actual parameter representation of the maxRetrieve attribute
	 */
	public void setMaxRetrieve(Integer maxRetrieve) {
		this.maxRetrieve = maxRetrieve;
	}

	/**
	 * Flag value(0-1) used to identify keywords in detected relations. <b> This incurs in additional 
	 * transaction charge </b>
	 * 
	 * @return Value of the keywords attribute
	 */
	public Boolean getKeywords() {
		return keywords;
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
	 * Flag value(0-1) used to identify named entities in detected relations. <b>This incurs in additional
	 * transaction charge</b>
	 * 
	 * @return Value of the entities attribute
	 */
	public Boolean getEntities() {
		return entities;
	}

	/**
	 * General Setter for entities parameter
	 * @param Boolean entities as an actual parameter representation of the entities attribute
	 */
	public void setEntities(Boolean entities) {
		this.entities = entities;
	}

	/**
	 * Flag value(0-1) used to restrict results to relations that contain at least one named entity
	 * 
	 * @return Value of the requireEntities attribute
	 */
	public Boolean getRequireEntities() {
		return requireEntities;
	}

	/**
	 * General Setter for requireEntities parameter
	 * 
	 * @param Boolean requireEntities as an actual parameter representation of the requireEntities attribute
	 */
	public void setRequireEntities(Boolean requireEntities) {
		this.requireEntities = requireEntities;
	}

	/**
	 * Flag value(0-1) used to the treatment of coreferences as separate entities (coreferences are resolved into
	 * detected default entities)
	 * 
	 * @return Value of the coreference attribute
	 */
	public Integer getCoreference() {
		return coreference;
	}

	/**
	 * General Setter for coreference parameter
	 * @param Integer coreference as an actual parameter representation of the coreference attribute
	 */
	public void setCoreference(Integer coreference) {
		this.coreference = coreference;
	}

	/**
	 * Flag value(0-1) used to hide entity disambiguation information in the response
	 * 
	 * @return Value of the disambiguate attribute
	 */
	public Integer getDisambiguate() {
		return disambiguate;
	}

	/**
	 * General Setter for disambiguate parameter
	 * 
	 * @param Integer disambiguate as an actual parameter representation of the disambiguate attribute
	 */
	public void setDisambiguate(Integer disambiguate) {
		this.disambiguate = disambiguate;
	}

	/**
	 * Flag value(0-1) used to include knowledge graph information in the results. This incurs an
	 * additional transaction charge
	 * 
	 * @return Value of the knowledgeGraph attribute
	 */
	public Integer getKnowledgeGraph() {
		return knowledgeGraph;
	}

	/**
	 * General Setter for knowledgeGraph parameter
	 * 
	 * @param Integer knowledgeGraph as an actual parameter representation of the knowledgeGraph attribute
	 */
	public void setKnowledgeGraph(Integer knowledgeGraph) {
		this.knowledgeGraph = knowledgeGraph;
	}

	/**
	 * Flag value(0-1) used to hide Linked Data content links in the response
	 * 
	 * @return Value of the linkedData attribute
	 */
	public Integer getLinkedData() {
		return linkedData;
	}

	/**
	 * General Setter for linkedData parameter
	 * 
	 * @param Integer linkedData as an actual parameter representation of the linkedData attribute
	 */
	public void setLinkedData(Integer linkedData) {
		this.linkedData = linkedData;
	}

	/**
	 * Flag value(0-1) used to include quotations that are linked to detected entities
	 * 
	 * @return Value of the quotations attribute
	 */
	public Integer getQuotations() {
		return quotations;
	}

	/**
	 * General Setter for quotations parameter
	 * 
	 * @param Integer quotations as an actual parameter representation of the quotations attribute
	 */
	public void setQuotations(Integer quotations) {
		this.quotations = quotations;
	}

	/**
	 * Flag value(0-1) used to analyze the sentiment towards each detected entity. This incurs an additional
	 * transaction charge
	 * 
	 * @return Value of the sentiment attribute
	 */
	public Integer getSentiment() {
		return sentiment;
	}

	/**
	 * General Setter for sentiment parameter
	 * 
	 * @param Integer sentiment as an actual parameter representation of the sentiment attribute
	 */
	public void setSentiment(Integer sentiment) {
		this.sentiment = sentiment;
	}

	/**
	 * Flag value(0-1) used to ignore or show structured entities, such as Quantity, EmailAddress,
	 * TwitterHandle, Hash-tag, and IPAddress
	 * 
	 * @return Value of the structuredEntities attribute
	 */
	public Integer getStructuredEntities() {
		return structuredEntities;
	}

	/**
	 * General Setter for structuredEntities parameter
	 * 
	 * @param Integer structuredEntities as an actual parameter representation of the structuredEntities attribute
	 */
	public void setStructuredEntities(Integer structuredEntities) {
		this.structuredEntities = structuredEntities;
	}

	/**
	 * The date to use as "today" when interpreting phrases in the text like "nest tuesday.". 
	 * Format: yyyy-mm-dd hh:mm:ss 
	 * 
	 * @return Value of the anchorDate attribute
	 */
	public String getAnchorDate() {
		return anchorDate;
	}

	/**
	 * General Setter for anchorDate parameter
	 * @param String anchorDate as an actual parameter representation of the anchorDate attribute
	 */
	public void setAnchorDate(String anchorDate) {
		this.anchorDate = anchorDate;
	}

	/**
	 * Flag value(0-1) to verify the inclusion of the source text in the response
	 * 
	 * @return Value of the showSourceText attribute
	 */
	public Boolean getShowSourceText() {
		return showSourceText;
	}

	/**
	 * General Setter for showSourceText parameter
	 * @param Boolean showSourceText as an actual parameter representation of the showSourceText attribute
	 */
	public void setShowSourceText(Boolean showSourceText) {
		this.showSourceText = showSourceText;
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
	 * General Setter for cquery parameter
	 * @param String cquery as an actual parameter representation of the cquery attribute
	 */
	public void setCquery(String cquery) {
		this.cquery = cquery;
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
	 * General Setter for xpath parameter
	 * 
	 * @param String xpath as an actual parameter representation of the xpath attribute
	 */
	public void setXpath(String xpath) {
		this.xpath = xpath;
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
	 * General Setter for sourceText parameter
	 * @param String sourceText as an actual parameter representation of the sourceText attribute
	 */
	public void setSourceText(String sourceText) {
		this.sourceText = sourceText;
	}
}
