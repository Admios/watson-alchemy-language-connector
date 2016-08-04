package com.admios.connector.watsonalchemylanguage.handler;

import static com.admios.connector.watsonalchemylanguage.util.Utils.intValue;

import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;

public abstract class URLCommonHandler<HandlerClass, result> extends CommonHandler<result> {

	public URLCommonHandler(AlchemyLanguage service, String source) {
		super(service, StringUtils.getType(source), source);
	}

	@SuppressWarnings("unchecked")
	public HandlerClass addShowSourceText(Boolean showSourceText) {
		return (HandlerClass) addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, intValue(showSourceText));
	}

	@SuppressWarnings("unchecked")
	public HandlerClass addCquery(String cquery) {
		return (HandlerClass) addParam(AlchemyLanguage.CQUERY, cquery);
	}

	@SuppressWarnings("unchecked")
	public HandlerClass addXpath(String xpath) {
		return (HandlerClass) addParam(AlchemyLanguage.XPATH, xpath);
	}

	@SuppressWarnings("unchecked")
	public HandlerClass addSourceText(String sourceText) {
		return (HandlerClass) addParam(AlchemyLanguage.SOURCE_TEXT, sourceText);
	}

}
