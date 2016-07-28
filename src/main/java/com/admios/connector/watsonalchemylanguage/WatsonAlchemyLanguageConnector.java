package com.admios.connector.watsonalchemylanguage;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import com.admios.connector.watsonalchemylanguage.config.ConnectorConfig;
import com.admios.connector.watsonalchemylanguage.handler.implementation.EntitiesHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;

@Connector(name = "watson-alchemy-language", friendlyName = "Watson AlchemyLanguage Service")
public class WatsonAlchemyLanguageConnector {

	@Config
	ConnectorConfig config;

	/**
	 * Custom processor
	 *
	 * @param friend
	 *            Name to be used to generate a greeting message.
	 * @return A greeting message
	 */
	@Processor
	public String greet(String friend) {
		return "";
	}

	/**
	 * Retrieve the Entities inside a text or a page.
	 *
	 * {@sample.xml ../../../doc/watson-alchemy-language-connector.xml.sample
	 * watson-alchemy-language:getEntities}
	 *
	 * @param text
	 *            The text or url to process
	 * @return return Entities
	 */
	@Processor
	public Entities getEntities(String text) {
		return new EntitiesHandler(config.getService(), text).execute();
	}

	public ConnectorConfig getConfig() {
		return config;
	}

	public void setConfig(ConnectorConfig config) {
		this.config = config;
	}

}