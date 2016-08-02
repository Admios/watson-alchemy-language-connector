/**
 * 
 */
package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.admios.connector.watsonalchemylanguage.util.StringUtils;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Microformats;

/**
 * @author AristidesMelendez
 *
 */
public class MicroformatsHandler extends CommonHandler<Microformats> {

	public MicroformatsHandler (AlchemyLanguage service, String text){
		super(service, StringUtils.getHtmlOrUrlType(text), text);
	}
	
	public MicroformatsHandler addShowSourceText(Integer number) {
		return addParam(AlchemyLanguage.SHOW_SOURCE_TEXT, number);
	}
	
	@Override
	public Microformats execute() {
		return service.getMicroformats(params).execute();
	}

}
