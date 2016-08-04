package com.admios.connector.watsonalchemylanguage.util;

public class Utils {

	public static Integer intValue(Boolean bool){
		if (bool == null) return null;
		return bool? 1: 0;
	}
}
