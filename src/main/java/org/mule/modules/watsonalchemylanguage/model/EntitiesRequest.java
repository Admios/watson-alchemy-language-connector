/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the entities operation.
 * 
 * @author Admios
 */
public class EntitiesRequest {

	/**
	 * The text or URL to process
	 */
	@Optional
	private String source; 

	/**
	 * Maximum number of entities to return (default = 50)
	 */
	@Optional
	private Integer maxRetrieve;

	/**
	 * Flag value(0-1). Set this to 0 to treat coreferences as separate entities (coreferences are resolved into
	 * detected entities by default)
	 */
	@Optional
	private Integer coreference;

	/**
	 * Flag value(0-1). Set this to 0 to hide entity disambiguation information in the response
	 */
	@Optional
	private Integer disambiguate;

	/**
	 * Flag value(0-1). Set this to 1 to include knowledge graph information in the results. This incurs an additional
	 * transaction charge
	 */
	@Optional
	private Integer knowledgeGraph;

	/**
	 * Flag value(0-1). Set this to 0 to hide Linked Data content links in the response
	 */
	@Optional
	private Integer linkedData;

	/**
	 * Flag value(0-1). Set this to 1 to include quotations that are linked to detected entities
	 */
	@Optional
	private Integer quotations;

	/**
	 * Flag value(0-1). Set this to 1 to analyze the sentiment towards each detected entity. This incurs an additional
	 * transaction charge
	 */
	@Optional
	private Integer sentiment;

	/**
	 * Flag value(0-1). Check this to include the source text in the response
	 */
	@Optional
	private Boolean showSourceText;

	/**
	 * Flag value(0-1). Set this to 0 to ignore structured entities, such as Quantity, EmailAddress, TwitterHandle,
	 * Hashtag, and IPAddress
	 */
	@Optional
	private Integer structuredEntities;

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
	 * Text or URL to process
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
	 * Flag value(0-1) used to the treatment of coreferences as separate entities (coreferences are resolved into
	 * detected default entities)
	 * 
	 * @return Value of the coreference attribute
	 */
	public Integer getCoreference() {
		return coreference;
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
	 * Flag value(0-1) used to include knowledge graph information in the results. This incurs an additional transaction
	 * charge
	 * 
	 * @return Value of the knowledgeGraph attribute
	 */
	public Integer getKnowledgeGraph() {
		return knowledgeGraph;
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
	 * Flag value(0-1) used to include quotations that are linked to detected entities
	 * 
	 * @return Value of the quotations attribute
	 */
	public Integer getQuotations() {
		return quotations;
	}

	/**
	 * Flag value(0-1) used to analyze the sentiment towards each detected entity. This incurs an additional transaction
	 * charge
	 * 
	 * @return Value of the sentiment attribute
	 */
	public Integer getSentiment() {
		return sentiment;
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
	 * Flag value(0-1) used to ignore or show structured entities, such as Quantity, EmailAddress, TwitterHandle,
	 * Hashtag, and IPAddress
	 * 
	 * @return Value of the structuredEntities attribute
	 */
	public Integer getStructuredEntities() {
		return structuredEntities;
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
	 * @param coreference the coreference to set
	 */
	public void setCoreference(Integer coreference) {
		this.coreference = coreference;
	}

	/**
	 * @param disambiguate the disambiguate to set
	 */
	public void setDisambiguate(Integer disambiguate) {
		this.disambiguate = disambiguate;
	}

	/**
	 * @param knowledgeGraph the knowledgeGraph to set
	 */
	public void setKnowledgeGraph(Integer knowledgeGraph) {
		this.knowledgeGraph = knowledgeGraph;
	}

	/**
	 * @param linkedData the linkedData to set
	 */
	public void setLinkedData(Integer linkedData) {
		this.linkedData = linkedData;
	}

	/**
	 * @param quotations the quotations to set
	 */
	public void setQuotations(Integer quotations) {
		this.quotations = quotations;
	}

	/**
	 * @param sentiment the sentiment to set
	 */
	public void setSentiment(Integer sentiment) {
		this.sentiment = sentiment;
	}

	/**
	 * @param showSourceText the showSourceText to set
	 */
	public void setShowSourceText(Boolean showSourceText) {
		this.showSourceText = showSourceText;
	}

	/**
	 * @param structuredEntities the structuredEntities to set
	 */
	public void setStructuredEntities(Integer structuredEntities) {
		this.structuredEntities = structuredEntities;
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
