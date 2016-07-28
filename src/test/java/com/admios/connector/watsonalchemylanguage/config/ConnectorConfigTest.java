package com.admios.connector.watsonalchemylanguage.config;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.api.ConnectionException;

public class ConnectorConfigTest {

	private static String API_KEY;
	private static final String BAD_API_KEY = "123456789";

	private ConnectorConfig config;

	@BeforeClass
	public static void init() throws IOException {
		Properties testProperties = new Properties();
		testProperties.load(ConnectionException.class.getResourceAsStream("/automation-credentials.properties"));
		API_KEY = testProperties.getProperty("config-type.apiKey");
	}

	@Before
	public void setUp() throws Exception {
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

}
