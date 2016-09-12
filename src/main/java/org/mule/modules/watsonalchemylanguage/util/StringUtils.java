/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;

public class StringUtils {

	private StringUtils() {}

	public static boolean isURL(final String text) {
		try {
			new URL(text);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}
	}

	public static String getType(final String text) {

		if (isURL(text)) {
			return AlchemyLanguage.URL;
		} else if (Jsoup.isValid(text, Whitelist.relaxed())) {
			return AlchemyLanguage.HTML;
		} else {
			return AlchemyLanguage.TEXT;
		}
	}

	public static String getHtmlOrUrlType(final String text) {
		return StringUtils.isURL(text) ? AlchemyLanguage.URL : AlchemyLanguage.HTML;
	}
}
