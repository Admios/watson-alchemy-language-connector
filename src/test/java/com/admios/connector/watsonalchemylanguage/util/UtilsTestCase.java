package com.admios.connector.watsonalchemylanguage.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilsTestCase {

	@Test
	public void intValueTest(){
		
		assertEquals(null, Utils.intValue(null));
		assertEquals(0, Utils.intValue(false).intValue());
		assertEquals(1, Utils.intValue(true).intValue());
		
	}

	@Test
	public void deniedToIntValueTest(){
		
		assertEquals(null, Utils.deniedToIntValue(null));
		assertEquals(1, Utils.deniedToIntValue(false).intValue());
		assertEquals(0, Utils.deniedToIntValue(true).intValue());
		
	}
}
