package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.admios.connector.watsonalchemylanguage.handler.CommonHandler;

public class CommonHandlerTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void parameterInvalid(){
		CommonHandlerMock mock = new CommonHandlerMock();
		mock.addParam(null, "Invalid object");
		fail();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void parameterEmpty(){
		CommonHandlerMock mock = new CommonHandlerMock();
		mock.addParam("", "Invalid object");
		fail();
	}
	
	@Test
	public void parameterWithNullValue(){
		CommonHandlerMock mock = new CommonHandlerMock();
		assertEquals(1,mock.parametersSize().intValue());
		mock.addParam("maxTime", null);
		assertEquals(1,mock.parametersSize().intValue());
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