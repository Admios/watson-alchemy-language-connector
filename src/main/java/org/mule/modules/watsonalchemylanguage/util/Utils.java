/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.util;

public class Utils {

	private Utils() {}

	/**
	 * Return 1 only if <i>bool</i> is true. If <i>bool</i> is null return null.
	 * @param bool Boolean to convert.
	 * @return {@link Integer}
	 */
	public static Integer intValue(final Boolean bool){
		return converter(bool, false);
	}
	
	/**
	 * Return 0 only if <i>bool</i> is true. If <i>bool</i> is null return null.
	 * @param bool Boolean to convert.
	 * @return {@link Integer}
	 */
	public static Integer deniedToIntValue(final Boolean bool){
		return converter(bool, true);
	}
	
	private static Integer converter(final Boolean bool,boolean negative){
		if (bool == null) {
			return null;
		}
		if (negative) {
			return !bool? 1:0;
		}
		return bool? 1: 0;
	}
}
