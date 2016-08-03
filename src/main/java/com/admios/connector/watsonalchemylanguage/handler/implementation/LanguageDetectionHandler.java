package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
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
