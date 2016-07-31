package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates;

public class DateExtractionHandler extends CommonHandler<Dates> {

	public DateExtractionHandler(AlchemyLanguage service, String text){
		super(service, StringUtils.getType(text), text);
	}
	
	public DateExtractionHandler addAnchorDate(String query) {
		return cast(addParam(AlchemyLanguage.ANCHOR_DATE, query));
	}
	
	public DateExtractionHandler addShowSourceText(Integer number) {
		return cast(addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, number));
	}
	
	private DateExtractionHandler cast(CommonHandler<Dates> addParam) {
		return (DateExtractionHandler) addParam;
	}

	@Override
	public Dates execute() {
		return service.getDates(params).execute();
	}

}
