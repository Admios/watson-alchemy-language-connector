/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the title extraction operation.
 * 
 * @author Admios
 */
public class TitleExtractionRequest {

	/**
	 * The HTML or URL to process.
	 */
	@Default("#[payload]")
	private String source;

	/**
	 * Check this to include the source text in the response.
	 */
	@Optional
	private Boolean showSourceText;

	public TitleExtractionRequest() {
	}

	public TitleExtractionRequest(String source, Boolean showSourceText) {
		super();
		this.source = source;
		this.showSourceText = showSourceText;
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
	 * Flag to include the source text in the response.
	 * 
	 * @return the showSourceText
	 */
	public Boolean getShowSourceText() {
		return showSourceText;
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
}
