/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler;

import static org.mule.modules.watsonalchemylanguage.util.Utils.intValue;

import org.mule.modules.watsonalchemylanguage.util.StringUtils;

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
