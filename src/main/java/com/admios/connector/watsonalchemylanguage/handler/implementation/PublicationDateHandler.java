package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentPublicationDate;

public class PublicationDateHandler extends CommonHandler<DocumentPublicationDate> {

	public PublicationDateHandler(AlchemyLanguage service, String source) {
		super(service, StringUtils.getHtmlOrUrlType(source), source);
	}

	@Override
	public DocumentPublicationDate execute() {
		return service.getPublicationDate(params).execute();
	}

}