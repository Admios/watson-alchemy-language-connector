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
}
