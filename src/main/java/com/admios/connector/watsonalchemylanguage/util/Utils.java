package com.admios.connector.watsonalchemylanguage.util;

public class Utils {

	/**
	 * Return 1 only if <i>bool</i> is true. If <i>bool</i> is null return null.
	 * @param bool
	 * @return {@link Integer}
	 */
	public static Integer intValue(Boolean bool){
		return converter(bool, false);
	}
	
	/**
	 * Return 0 only if <i>bool</i> is true. If <i>bool</i> is null return null.
	 * @param bool
	 * @return {@link Integer}
	 */
	public static Integer deniedToIntValue(Boolean bool){
		return converter(bool, true);
	}
	
	private static Integer converter(Boolean bool,boolean negative){
		if (bool == null) return null;
		if (negative) bool = !bool;
		return bool? 1: 0;
	}
}
