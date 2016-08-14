package com.admios.connector.watsonalchemylanguage.handler.implementation;

import com.admios.connector.watsonalchemylanguage.handler.URLCommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;

public class TaxonomyHandler extends URLCommonHandler<TaxonomyHandler, Taxonomies>{

	public TaxonomyHandler(AlchemyLanguage service, String source) {
		super(service, source);
	}

	@Override
	public Taxonomies execute() {
		return service.getTaxonomy(params).execute();
	}

}
