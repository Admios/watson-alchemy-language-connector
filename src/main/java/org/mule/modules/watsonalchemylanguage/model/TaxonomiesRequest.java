/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the taxonomies operation.
 * 
 * @author Admios
 */
public class TaxonomiesRequest {

	/**
	 * The HTML or URL to process.
	 */
	@Optional
	private String source;

	/**
	 * Set this to 1 to include the source text in the response.
	 */
	@Optional
	private Boolean showSourceText;

	/**
	 * A visual constraint query to apply to the web page. Required when sourceText is set to cquery.
	 */
	@Optional
	private String cquery;

	/**
	 * An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values.
	 */
	@Optional
	private String xpath;

	/**
	 * Determines how to obtain the source text from the web page
	 */
	@Optional
	private String sourceText;

	public TaxonomiesRequest() {
	}

	public TaxonomiesRequest(String source) {
		super();
		this.source = source;
	}

	/**
	 * The HTML or URL to process.
	 * 
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Flag value(0 - 1), set this to 1 to include the source text in the response.
	 * 
	 * @return the showSourceText
	 */
	public Boolean getShowSourceText() {
		return showSourceText;
	}

	/**
	 * A visual constraint query to apply to the web page. Required when sourceText is set to cquery.
	 * 
	 * @return the cquery
	 */
	public String getCquery() {
		return cquery;
	}

	/**
	 * An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 * 
	 * @return the xpath
	 */
	public String getXpath() {
		return xpath;
	}

	/**
	 * Determines how to obtain the source text from the web page.
	 * 
	 * @return the sourceText
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
