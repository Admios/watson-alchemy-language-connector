package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the language detection operation.
 * 
 * @author Admios
 */
public class LanguageDetectionRequest {

	/**
	 * The text, HTML or URL to process.
	 */
	@Default("#[payload]")
	private String source;

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

	public LanguageDetectionRequest() {
	}

	public LanguageDetectionRequest(String source) {
		super();
		this.source = source;
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
