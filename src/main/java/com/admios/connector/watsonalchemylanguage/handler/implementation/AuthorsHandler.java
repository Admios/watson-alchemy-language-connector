package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentAuthors;

public class AuthorsHandler extends CommonHandler<DocumentAuthors> {

	public AuthorsHandler(AlchemyLanguage service, String source) {
		super(service, StringUtils.isURL(source) ? AlchemyLanguage.URL : AlchemyLanguage.HTML, source);
	}

	@Override
	public DocumentAuthors execute() {
		return service.getAuthors(params).execute();
	}

}
