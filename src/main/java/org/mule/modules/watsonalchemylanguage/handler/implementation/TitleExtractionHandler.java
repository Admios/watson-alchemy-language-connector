/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import static org.mule.modules.watsonalchemylanguage.util.Utils.intValue;

import org.mule.modules.watsonalchemylanguage.handler.CommonHandler;
import org.mule.modules.watsonalchemylanguage.util.StringUtils;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentTitle;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;

public class TitleExtractionHandler extends CommonHandler<DocumentTitle> {

	public TitleExtractionHandler(AlchemyLanguage service, String source) {
		super(service, StringUtils.getHtmlOrUrlType(source), source);
	}

	public TitleExtractionHandler addShowSourceText(Boolean showSourceText) {
		return addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, intValue(showSourceText));
	}

	@Override
	public DocumentTitle execute() throws BadRequestException {
		return service.getTitle(params).execute();
	}
}