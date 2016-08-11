package org.mule.modules.watsonalchemylanguage.automation.system;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.tools.devkit.ctf.configuration.util.ConfigurationUtils;

import com.admios.connector.watsonalchemylanguage.config.ConnectorConfig;

public class ConnectorConfigTestCases {

	private Properties validCredentials;
	private static String API_KEY;
	private static final String BAD_API_KEY = "123456789";

	private ConnectorConfig config;

	@Before
	public void setup() throws Exception {
		validCredentials = ConfigurationUtils.getAutomationCredentialsProperties();
		API_KEY = validCredentials.getProperty("watson-alchemylanguage-config.apiKey");
		config = new ConnectorConfig();
	}

	@Test
	public void testConnect() throws ConnectionException {
		config.connect(API_KEY);
		assertTrue("Connect should success", true);
	}

	@Test
	public void testConnectFail() {
		try {
			config.connect(BAD_API_KEY);
			assertTrue("Connect should fail due to bad Api Key", false);
		} catch (ConnectionException e) {
		}
	}

	@Test
	public void testConnectWithNullKey() {
		try {
			config.connect(null);
			assertTrue("Connect should fail due to bad Api Key", false);
		} catch (ConnectionException e) {
		}
	}

}
