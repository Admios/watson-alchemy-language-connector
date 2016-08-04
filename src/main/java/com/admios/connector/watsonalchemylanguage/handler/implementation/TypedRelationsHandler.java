package com.admios.connector.watsonalchemylanguage.handler.implementation;

import static com.admios.connector.watsonalchemylanguage.util.Utils.intValue;
import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;

public class TypedRelationsHandler extends CommonHandler<TypedRelations> {

	public TypedRelationsHandler(AlchemyLanguage service, String source) {
		super(service, StringUtils.getType(source), source);
	}

	public TypedRelationsHandler addModel(String model) {
		return addParam(AlchemyLanguage.MODEL_ID, model);
	}

	public TypedRelationsHandler addShowSourceText(Boolean showSourceText) {
		return addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, intValue(showSourceText));
	}

	@Override
	public TypedRelations execute() throws BadRequestException {
		return service.getTypedRelations(params).execute();
	}
}