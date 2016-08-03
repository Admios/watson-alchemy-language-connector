package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentTitle;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;

public class TitleExtractionHandler extends CommonHandler<DocumentTitle> {

	public TitleExtractionHandler(AlchemyLanguage service, String source) {
		super(service, StringUtils.getHtmlOrUrlType(source), source);
	}

	public TitleExtractionHandler addShowSourceText(Integer showSourceText) {
		return addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, showSourceText);
	}

	@Override
	public DocumentTitle execute() throws BadRequestException {
		return service.getTitle(params).execute();
	}
}