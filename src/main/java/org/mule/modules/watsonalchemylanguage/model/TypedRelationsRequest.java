/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the Typed Relations operation.
 * 
 * @author Admios
 */
public class TypedRelationsRequest {
	/**
	 * The text, HTML document or URL to process
	 */
	@Optional
	private String source;

	/**
	 * The unique alphanumeric identifier for your custom model
	 */
	@Optional
	private String model;

	/**
	 * Check this to include the source text in the response
	 */
	@Optional
	private Boolean showSourceText;

	public TypedRelationsRequest() {
	}

	public TypedRelationsRequest(String source, String model, Boolean showSourceText) {
		super();
		this.source = source;
		this.model = model;
		this.showSourceText = showSourceText;
	}

	/**
	 * The text, HTML document or URL to process.
	 * 
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * The unique alphanumeric identifier for your custom model
	 * 
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Check this to include the source text in the response
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
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @param showSourceText the showSourceText to set
	 */
	public void setShowSourceText(Boolean showSourceText) {
		this.showSourceText = showSourceText;
	}
}
