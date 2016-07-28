package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;

public class CommonHandlerTest extends
AbstractTestCase<WatsonAlchemyLanguageConnector>{

	public CommonHandlerTest() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Before
	public void setup() {
		// TODO
	}

	@After
	public void tearDown() {
		// TODO
	}

	@Test
	public void verify() {
		java.lang.String expected = null;
		java.lang.String friend = null;
		assertEquals(getConnector().greet(friend), expected);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void parameterInvalid(){
		
		CommonHandlerMock mock = new CommonHandlerMock();
		
		try{
			mock.addParam(null, "Invalid object");
			fail();
		} catch (IllegalArgumentException e){
			
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void parameterEmpty(){
		
		CommonHandlerMock mock = new CommonHandlerMock();
		
		try{
			mock.addParam("", "Invalid object");
			fail();
		} catch (IllegalArgumentException e){
			
		}
	}
}

final class CommonHandlerMock extends CommonHandler{
	
	public CommonHandlerMock(){
		super(null, "Test", "object");
	}
	
	@Override
	public Object execute(){
		// nothing to test here.
		return "";
	}
	
	@Override
	public CommonHandler addParam(String param, Object value){
		return super.addParam(param, value);
	}
	
}