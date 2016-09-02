package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the Typed Relations operation.
 * 
 * @author Admios
 */
public class TypedRelationsRequest {
	/**
	 * The text, HTML document or url to process
	 */
	@Default("#[payload]")
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
	 * The text, HTML document or url to process.
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
