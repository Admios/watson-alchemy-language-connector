package com.admios.connector.watsonalchemylanguage.handler.implementation;

import static com.admios.connector.watsonalchemylanguage.util.Utils.trueToIntValue;
import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.admios.connector.watsonalchemylanguage.util.StringUtils;
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
		return addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, trueToIntValue(number));
	}

	@Override
	public Dates execute() {
		return service.getDates(params).execute();
	}

}
