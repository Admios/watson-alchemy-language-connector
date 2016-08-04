package com.admios.connector.watsonalchemylanguage.util;

public class Utils {

	/**
	 * Convert a true into 1. If null return null.
	 * @param bool
	 * @return {@link Integer}
	 */
	public static Integer trueToIntValue(Boolean bool){
		return intValue(bool, false);
	}
	
	/**
	 * Convert a false into 0. If null return null.
	 * @param bool
	 * @return {@link Integer}
	 */
	public static Integer falseToIntValue(Boolean bool){
		return intValue(bool, true);
	}
	
	private static Integer intValue(Boolean bool,boolean negative){
		if (bool == null) return null;
		if (negative) bool = !bool;
		return bool? 1: 0;
	}
}
