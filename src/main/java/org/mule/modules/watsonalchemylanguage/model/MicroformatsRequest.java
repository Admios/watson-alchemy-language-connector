/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the microformats operation.
 * 
 * @author Admios
 */
public class MicroformatsRequest {

	/**
	 * The text, HTML or URL to process.
	 */
	@Optional
	private String source;

	/**
	 * Check this to include the source text in the response.
	 */
	@Optional
	private Boolean showSourceText;

	public MicroformatsRequest() {
	}

	public MicroformatsRequest(String source, Boolean showSourceText) {
		super();
		this.source = source;
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
	 * Flag value, check this to include the source text in the response.
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
