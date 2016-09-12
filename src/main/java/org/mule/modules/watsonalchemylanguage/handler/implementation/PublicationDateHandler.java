/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import org.mule.modules.watsonalchemylanguage.handler.CommonHandler;
import org.mule.modules.watsonalchemylanguage.util.StringUtils;

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