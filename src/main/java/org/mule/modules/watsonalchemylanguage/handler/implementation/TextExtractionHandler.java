/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import org.mule.modules.watsonalchemylanguage.handler.URLCommonHandler;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;
import com.ibm.watson.developer_cloud.service.exception.BadRequestException;

public class TextExtractionHandler extends URLCommonHandler<TextExtractionHandler, DocumentText>{


	public TextExtractionHandler(AlchemyLanguage service, String source) {
		super(service, source);
	}

	public TextExtractionHandler addExtractLinks(String extractLinks) {
		return addParam(AlchemyLanguage.EXTRACT_LINK, extractLinks);
	}
	
	public TextExtractionHandler addUseMetadata(String useMetaData) {
		return addParam(AlchemyLanguage.USE_METADATA, useMetaData);
	}
	
	
	@Override
	public DocumentText execute() throws BadRequestException {
		return service.getText(params).execute();
	}

}
