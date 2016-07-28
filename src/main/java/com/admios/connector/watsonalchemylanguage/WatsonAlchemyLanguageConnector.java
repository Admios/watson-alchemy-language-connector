package com.admios.connector.watsonalchemylanguage;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import com.admios.connector.watsonalchemylanguage.config.ConnectorConfig;

@Connector(name="watson-alchemy-language", friendlyName="Watson AlchemyLanguage Service")
public class WatsonAlchemyLanguageConnector {

    @Config
    ConnectorConfig config;

    /**
     * Custom processor
     *
     * @param friend Name to be used to generate a greeting message.
     * @return A greeting message
     */
    @Processor
    public String greet(String friend) {
        return "";
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}