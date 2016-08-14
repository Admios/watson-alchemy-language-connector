package org.mule.modules.watsonalchemylanguage.automation.system;

import static org.junit.Assert.*;

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

	@Test(expected = ConnectionException.class)
	public void testConnectFail() throws ConnectionException {
		config.connect(BAD_API_KEY);
		fail("Connect should fail due to bad Api Key");
	}

	@Test(expected = ConnectionException.class)
	public void testConnectWithNullKey() throws ConnectionException {
		config.connect(null);
		fail("Connect should fail due to bad Api Key");
	}

}
