package com.admios.connector.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates;

public class DateExtractionTestCase extends AbstractTestCase<WatsonAlchemyLanguageConnector>{
	
	public DateExtractionTestCase(){
		super(WatsonAlchemyLanguageConnector.class);
	}
	
	@Test
	public void getDatesUsingText() {
		Dates dates = getConnector().dateExtraction("The person was found alive on November 25, 2014 at a ranch on the outskirts of city light.", null, null);
		
		assertNotNull(dates);
		assertEquals("english", dates.getLanguage());
		assertEquals(1, dates.getTotalTransactions().intValue());
		assertEquals(1, dates.getDates().size());
		assertEquals("Tue Nov 25 00:00:00 EST 2014", dates.getDates().get(0).getDate().toString());
		assertEquals("november 25, 2014 at", dates.getDates().get(0).getText());
	}
	
	@Test
	public void getDatesUsingHTML() {
		Dates dates = getConnector().dateExtraction("<html><body><h1>Finally found it!!!</h1><p>The Person was found alive on November 10, 2014 in Marsella.</p><p>The last time was on a party was October 31, 2014 at a ranch outside the City Lights.</p></body></html>", null, true);
		
		assertNotNull(dates);
		assertEquals("english", dates.getLanguage());
		assertEquals(1, dates.getTotalTransactions().intValue());
		assertEquals(2, dates.getDates().size());
		assertEquals("Mon Nov 10 00:00:00 EST 2014", dates.getDates().get(0).getDate().toString());
		assertEquals("november 10, 2014", dates.getDates().get(0).getText());
		assertEquals("Fri Oct 31 00:00:00 EST 2014", dates.getDates().get(1).getDate().toString());
		assertEquals("october 31, 2014 at", dates.getDates().get(1).getText());
	}
}
