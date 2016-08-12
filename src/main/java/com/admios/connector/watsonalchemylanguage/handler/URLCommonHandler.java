package com.admios.connector.watsonalchemylanguage.handler;

import static com.admios.connector.watsonalchemylanguage.util.Utils.intValue;

import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;

public abstract class URLCommonHandler<H, R> extends CommonHandler<R> {

	public URLCommonHandler(AlchemyLanguage service, String source) {
		super(service, StringUtils.getType(source), source);
	}

	@SuppressWarnings("unchecked")
	public H addShowSourceText(Boolean showSourceText) {
		return (H) addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, intValue(showSourceText));
	}

	@SuppressWarnings("unchecked")
	public H addCquery(String cquery) {
		return (H) addParam(AlchemyLanguage.CQUERY, cquery);
	}

	@SuppressWarnings("unchecked")
	public H addXpath(String xpath) {
		return (H) addParam(AlchemyLanguage.XPATH, xpath);
	}

	@SuppressWarnings("unchecked")
	public H addSourceText(String sourceText) {
		return (H) addParam(AlchemyLanguage.SOURCE_TEXT, sourceText);
	}

}
