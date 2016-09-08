/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the date extraction operation.
 * 
 * @author Admios
 */
public class DateExtractionRequest {

	/**
	 * The text, HTML or URL to process.
	 */
	@Optional
	private String source; 

	/**
	 * The date to use as "today" when interpreting phrases in the text like "next tuesday.". 
	 * Format: yyyy-mm-dd hh:mm:ss 
	 */
	@Optional
	private String anchorDate;

	/**
	 * Flag value, check this to include the source text in the response.
	 */
	@Optional 
	private Boolean showSourceText;

	/**
	 * Text or URL to process
	 *
	 * @return Value of the source attribute
	 */
	public String getSource() {
		return source;
	}

	/**
	 * The date to use as "today" when interpreting phrases in the text like "next tuesday.". 
	 * Format: yyyy-mm-dd hh:mm:ss 
	 * 
	 * @return Value of the anchorDate attribute
	 */
	public String getAnchorDate() {
		return anchorDate;
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
	 * General Setter for source attribute
	 * 
	 * @param String source as an actual parameter representation of the source attribute
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * General Setter for anchorDate attribute
	 * 
	 * @param String anchorDate as an actual parameter representation of the anchorDate attribute
	 */
	public void setAnchorDate(String anchorDate) {
		this.anchorDate = anchorDate;
	}

	/**
	 * General Setter for showSourceText attribute
	 * 
	 * @param Boolean showSourceText as an actual parameter representation of the showSourceText attribute
	 */
	public void setShowSourceText(Boolean showSourceText) {
		this.showSourceText = showSourceText;
	}
	
	
}
