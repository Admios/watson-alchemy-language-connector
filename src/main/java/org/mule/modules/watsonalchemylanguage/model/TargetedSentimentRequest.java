/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the targeted sentiment operation.
 * 
 * @author Admios
 */
public class TargetedSentimentRequest {

	/**
	 * The text, HTML or URL to process.
	 */
	@Optional
	private String source;

	/**
	 * Target phrase. The service will return sentiment information for the phrase that is found in the source text.
	 */
	private String target;

	/**
	 * Check this to include the source text in the response.
	 */
	@Optional
	private Boolean showSourceText;

	/**
	 * A visual constraints query to apply to the web page. Required when <code>sourceText</code> is set to cquery.
	 */
	@Optional
	private String cquery;

	/**
	 * An XPath query to apply to the web page. Required when <code>sourceText</code> is set to one of the XPath values.
	 */
	@Optional
	private String xpath;

	/**
	 * How to obtain the source text from the webpage.
	 */
	@Optional
	private String sourceText;

	public TargetedSentimentRequest() {
	}

	public TargetedSentimentRequest(String source, String target, Boolean showSourceText) {
		super();
		this.source = source;
		this.target = target;
		this.showSourceText = showSourceText;
	}

	/**
	 * The text, HTML or URL to process.
	 * 
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Target phrase. The service will return sentiment information for the phrase that is found in the source text.
	 * 
	 * @return the targe
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * Flag value, check this to include the source text in the response.
	 * 
	 * @return the showSourceText
	 */
	public Boolean getShowSourceText() {
		return showSourceText;
	}

	/**
	 * A visual constraints query to apply to the web page. Required when <code>sourceText</code> is set to cquery.
	 * 
	 * @return the cquery
	 */
	public String getCquery() {
		return cquery;
	}

	/**
	 * An XPath query to apply to the web page. Required when <code>sourceText</code> is set to one of the XPath values.
	 * 
	 * @return the xpath
	 */
	public String getXpath() {
		return xpath;
	}

	/**
	 * How to obtain the source text from the webpage.
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
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
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
