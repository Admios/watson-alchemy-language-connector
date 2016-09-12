/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import static org.mule.modules.watsonalchemylanguage.util.Utils.intValue;

import org.mule.modules.watsonalchemylanguage.handler.CommonHandler;
import org.mule.modules.watsonalchemylanguage.util.StringUtils;

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