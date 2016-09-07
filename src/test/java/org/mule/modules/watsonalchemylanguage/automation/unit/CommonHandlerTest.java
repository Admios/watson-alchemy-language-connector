/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.handler.CommonHandler;

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

@SuppressWarnings("rawtypes")
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