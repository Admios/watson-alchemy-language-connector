package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;


/**
 * Class with all the options for Concept operation.
 * 
 * @author Admios
 */
public class ConceptsRequest {
	
	/**
	 * Text or URL to process
	 */
	@Default("[payload]")
	private String source;
	
	/**
	 * Maximum number of entities to return (default 50)
	 */
	@Optional
	private Integer maxRetrieve;
	
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
	 * Text or URL to process
	 *
	 * @return Value of the source attribute
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Basic setter for source attribute
	 * @param source 
	 */
	public void setSource(String source) {
		this.source = source;
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
	 * Basic setter for maxRetrieve attribute
	 * @param maxRetrieve 
	 */
	public void setMaxRetrieve(Integer maxRetrieve) {
		this.maxRetrieve = maxRetrieve;
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
	 * Basic setter for knowledgeGraph attribute
	 * @param knowledgeGraph 
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
	 * Basic setter for linkedData attribute
	 * @param linkedData 
	 */
	public void setLinkedData(Integer linkedData) {
		this.linkedData = linkedData;
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
	 * Basic setter for showSourceText attribute
	 * @param showSourceText 
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
	 * Basic setter for cquery attribute
	 * @param cquery 
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
	 * Basic setter for xpath attribute
	 * @param xpath 
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
	 * Basic setter for sourceText attribute
	 * @param sourceText 
	 */
	public void setSourceText(String sourceText) {
		this.sourceText = sourceText;
	}
	
	
}
