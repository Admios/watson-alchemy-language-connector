/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.util.Utils;

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
