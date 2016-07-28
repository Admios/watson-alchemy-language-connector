package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;

public class EntitiesHandler extends CommonHandler<Entities> {

	public EntitiesHandler(AlchemyLanguage service, String text) {
		super(service, StringUtils.isURL(text) ? AlchemyLanguage.URL : AlchemyLanguage.TEXT, text);
	}

	@Override
	public Entities execute() {
		return service.getEntities(params).execute();
	}
}
