/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import org.mule.modules.watsonalchemylanguage.handler.URLCommonHandler;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;

public class TargetedSentimentHandler extends URLCommonHandler<TargetedSentimentHandler, DocumentSentiment> {

	public TargetedSentimentHandler (AlchemyLanguage service, String source) {
		super(service, source);
	}
	
	public TargetedSentimentHandler addTarget(String target) {
		return addParam(AlchemyLanguage.TARGET, target);
	}

	@Override
	public DocumentSentiment execute() {
		return service.getSentiment(params).execute();
	}

}
