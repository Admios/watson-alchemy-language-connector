package org.mule.modules.watsonalchemylanguage.model;

import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

/**
 * Class with all the options for the text extraction operation.
 * 
 * @author Admios
 */
public class TextExtractionRequest {

	/**
	 * The HTML or URL to process.
	 */
	@Default("#[payload]")
	private String source;

	/**
	 * A visual constraint query to apply to the web page. Required when sourceText is set to cquery
	 */
	@Optional
	private String cquery;

	/**
	 * An XPath query to apply to the web page. Required when sourceText is set to one of the XPath values
	 */
	@Optional
	private String xpath;

	/**
	 * Determines how to obtain the source text from the webpage.
	 */
	@Optional
	private String sourceText;

	/**
	 * Set this to 1 to include hyperlinks in the extracted text.
	 */
	@Optional
	private String extractLinks;

	/**
	 * Set this to 0 to ignore description information in webpage metadata.
	 */
	@Optional
	private String useMetaData;

	public TextExtractionRequest() {
	}

	public TextExtractionRequest(String source) {
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
	 * A visual constraint query to apply to the web page. Required when sourceText is set to cquery
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
	 * Determines how to obtain the source text from the webpage.
	 * 
	 * @return the sourceText
	 */
	public String getSourceText() {
		return sourceText;
	}

	/**
	 * Flag value(0 - 1), set this to 1 to include hyperlinks in the extracted text.
	 * 
	 * @return the extractLinks
	 */
	public String getExtractLinks() {
		return extractLinks;
	}

	/**
	 * Flag value(0 - 1), set this to 0 to ignore description information in webpage metadata.
	 * 
	 * @return the useMetaData
	 */
	public String getUseMetaData() {
		return useMetaData;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
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

	/**
	 * @param extractLinks the extractLinks to set
	 */
	public void setExtractLinks(String extractLinks) {
		this.extractLinks = extractLinks;
	}

	/**
	 * @param useMetaData the useMetaData to set
	 */
	public void setUseMetaData(String useMetaData) {
		this.useMetaData = useMetaData;
	}
}
