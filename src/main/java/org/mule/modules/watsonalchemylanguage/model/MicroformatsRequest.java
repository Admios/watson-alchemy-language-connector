package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the microformats operation.
 * 
 * @author Admios
 */
public class MicroformatsRequest {

	/**
	 * The text, html or url to process.
	 */
	@Default("#[payload]")
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
	 * The text, html or url to process.
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
