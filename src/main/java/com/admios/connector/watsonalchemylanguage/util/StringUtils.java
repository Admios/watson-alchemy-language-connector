package com.admios.connector.watsonalchemylanguage.util;

import java.net.MalformedURLException;
import java.net.URL;

public class StringUtils {

	public static boolean isURL(String text) {
		try {
			new URL(text);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}
	}
}
