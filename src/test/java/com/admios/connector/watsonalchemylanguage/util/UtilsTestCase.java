package com.admios.connector.watsonalchemylanguage.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilsTestCase {

	@Test
	public void trueToIntValueTest(){
		
		assertEquals(null, Utils.trueToIntValue(null));
		assertEquals(0, Utils.trueToIntValue(false).intValue());
		assertEquals(1, Utils.trueToIntValue(true).intValue());
		
	}

	@Test
	public void falseToIntValueTest(){
		
		assertEquals(null, Utils.falseToIntValue(null));
		assertEquals(1, Utils.falseToIntValue(false).intValue());
		assertEquals(0, Utils.falseToIntValue(true).intValue());
		
	}
}
