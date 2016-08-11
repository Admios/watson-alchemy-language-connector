package org.mule.modules.watsonalchemylanguage.automation.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.admios.connector.watsonalchemylanguage.util.Utils;

public class UtilsTest {

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
