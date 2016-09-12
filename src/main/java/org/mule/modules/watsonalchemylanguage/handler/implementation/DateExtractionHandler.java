/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.handler.implementation;

import static org.mule.modules.watsonalchemylanguage.util.Utils.intValue;

import org.mule.modules.watsonalchemylanguage.handler.CommonHandler;
import org.mule.modules.watsonalchemylanguage.util.StringUtils;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates;

public class DateExtractionHandler extends CommonHandler<Dates> {

	public DateExtractionHandler(AlchemyLanguage service, String text){
		super(service, StringUtils.getType(text), text);
	}
	
	public DateExtractionHandler addAnchorDate(String query) {
		return addParam(AlchemyLanguage.ANCHOR_DATE, query);
	}
	
	public DateExtractionHandler addShowSourceText(Boolean number) {
		return addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, intValue(number));
	}

	@Override
	public Dates execute() {
		return service.getDates(params).execute();
	}

}
