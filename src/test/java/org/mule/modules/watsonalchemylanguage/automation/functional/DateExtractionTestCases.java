/**
 * (c) Copyright 2016 Admios. The software in this package is published under the terms of the Apache License Version 2.0, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.mule.modules.watsonalchemylanguage.model.DateExtractionRequest;

import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates;

public class DateExtractionTestCases extends AbstractTestCases {

	private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");

	@Test
	public void getDatesUsingText() {

		Dates dates = getConnector().dateExtraction(buildDateExtractionRequest(false));

		assertNotNull(dates);
		assertEquals("english", dates.getLanguage());
		assertEquals(1, dates.getTotalTransactions().intValue());
		assertEquals(1, dates.getDates().size());
		assertEquals("25/11/2014 12:00:00 AM", formatter.format(dates.getDates().get(0).getDate()));
	}

	@Test
	public void getDatesUsingHTML() {
		Dates dates = getConnector()
				.dateExtraction(buildDateExtractionRequest(true));

		assertNotNull(dates);
		assertEquals("english", dates.getLanguage());
		assertEquals(1, dates.getTotalTransactions().intValue());
		assertEquals(2, dates.getDates().size());
		assertEquals("10/11/2014 12:00:00 AM", formatter.format(dates.getDates().get(0).getDate()));
		assertEquals("31/10/2014 12:00:00 AM", formatter.format(dates.getDates().get(1).getDate()));
	}
	
	/**
	 * This method builds a DateExtractionRequest object
	 * @param isHtml true If source is using html format, false otherwise.
	 * @return Instance of DateExtractionRequest class
	 */
	public DateExtractionRequest buildDateExtractionRequest(boolean isHtml) {
		
		DateExtractionRequest dateExtractionRequest = new DateExtractionRequest();
		
		dateExtractionRequest.setShowSourceText(true);
		dateExtractionRequest.setSource("<html><body><h1>Finally found it!!!</h1><p>The Person was found alive on November 10,"
					+ " 2014 in Marsella.</p><p>The last time was on a party was October 31, 2014 at a ranch outside the City Lights.</p></body></html>");
		dateExtractionRequest.setAnchorDate(null);
		
		if(!isHtml) {		
			dateExtractionRequest.setSource("The person was found alive on November 25, 2014 at a ranch on the outskirts of city light.");
		}
		
		return dateExtractionRequest;
	}
}
