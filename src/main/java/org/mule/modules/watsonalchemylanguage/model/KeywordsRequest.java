/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the keywords operation.
 * 
 * @author Admios
 */
public class KeywordsRequest {

	/**
	 * Text or url to process
	 */
	@Optional
	private String source;

	/**
	 * Maximum number of entities to return (default 50)
	 */
	@Optional
	private Integer maxRetrieve;

	/**
	 * Set this to 1 to include knowledge graph information in the results. This incurs an additional transaction charge
	 */
	@Optional
	private Integer knowledgeGraph;

	/**
	 * Flag value(1-0) Whether to perform sentiment analysis for each keyword(default=0: disabled). This incurs an
	 * additional transaction charge.
	 */
	@Optional
	private Integer sentiment;

	/**
	 * Flag value(0-1) to verify the inclusion of the source text in the response
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
	 * Flag value(0-1) used to include knowledge graph information in the results. This incurs an additional transaction
	 * charge
	 * 
	 * @return Value of the knowledgeGraph attribute
	 */
	public Integer getKnowledgeGraph() {
		return knowledgeGraph;
	}

	/**
	 * Flag value(1-0) Whether to perform sentiment analysis for each keyword(default=0: disabled). This incurs an
	 * additional transaction charge.
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
	 * @param knowledgeGraph the knowledgeGraph to set
	 */
	public void setKnowledgeGraph(Integer knowledgeGraph) {
		this.knowledgeGraph = knowledgeGraph;
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
