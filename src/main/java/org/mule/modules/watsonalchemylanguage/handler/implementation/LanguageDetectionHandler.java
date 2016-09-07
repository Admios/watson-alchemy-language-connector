/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import org.mule.modules.watsonalchemylanguage.handler.URLCommonHandler;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Language;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;

public class LanguageDetectionHandler extends URLCommonHandler<LanguageDetectionHandler, Language> {

	public LanguageDetectionHandler(AlchemyLanguage service, String text) {
		super(service, text);
	}

	@Override
	public Language execute() throws BadRequestException {
		return service.getLanguage(params).execute();
	}

}
