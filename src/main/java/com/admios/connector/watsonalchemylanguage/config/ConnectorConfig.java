package com.admios.connector.watsonalchemylanguage.config;

import java.util.HashMap;
import java.util.Map;

import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.param.ConnectionKey;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.service.exception.UnauthorizedException;

@ConnectionManagement(friendlyName = "Configuration", configElementName = "watson-alchemylanguage-config")
public class ConnectorConfig {

	private AlchemyLanguage service;

	/**
	 * Connect, this method will use one api call to validate the api key
	 *
	 * @param username
	 *            A apiKey
	 * @throws ConnectionException
	 */
	@Connect
	@TestConnectivity
	public void connect(@ConnectionKey String apiKey) throws ConnectionException {
		setService(new AlchemyLanguage(apiKey));
		testConnectivity();
	}

	/**
	 * Disconnect
	 */
	@Disconnect
	public void disconnect() {
		setService(null);
	}

	/**
	 * Are we connected
	 */
	@ValidateConnection
	public boolean isConnected() {
		return getService() != null;
	}

	/**
	 * Are we connected
	 */
	@ConnectionIdentifier
	public String connectionId() {
		return "001";
	}

	private void testConnectivity() throws ConnectionException {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put(AlchemyLanguage.TEXT, "Connection Test Request");
			getService().getLanguage(params).execute();
		} catch (UnauthorizedException e) {
			throw new ConnectionException(ConnectionExceptionCode.INCORRECT_CREDENTIALS, "", e.getMessage(), e);
		}
	}

	public AlchemyLanguage getService() {
		return service;
	}

	public void setService(AlchemyLanguage service) {
		this.service = service;
	}
}