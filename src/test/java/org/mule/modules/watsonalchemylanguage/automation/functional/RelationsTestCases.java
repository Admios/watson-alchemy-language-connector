package org.mule.modules.watsonalchemylanguage.automation.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.admios.connector.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import com.ibm.watson.developer_cloud.alchemy.v1.model.SAORelations;

public class RelationsTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	public RelationsTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

	@Test
	public void relationTestUsingURL() {

		String url = "http://www.admios.com/admios-blog/2016/7/20/build-fast-and-clean-uis-with-angular-material";
		SAORelations relations = getConnector().relations(url, 4, null, null, null, null, null, null, null, null, null,
				null, null, null, null);

		assertNotNull(relations);
		assertEquals("english", relations.getLanguage());
		assertEquals(url, relations.getUrl());
		assertEquals(4, relations.getRelations().size());
		assertEquals("Angular.js", relations.getRelations().get(0).getSubject().getText());
	}

	@Test
	public void relationTestUsingText() {

		String text = "Angular.js has been out there for a while now and is definitely a popular option to take into"
				+ " consideration when selecting a front end technology.";
		SAORelations relations = getConnector().relations(text, 10, true, null, null, null, null, null, null, null, null,
				null, null, null, null);

		assertNotNull(relations);
		assertEquals("english", relations.getLanguage());
		assertEquals(text + "\n", relations.getText());
		assertEquals(3, relations.getRelations().size());
		assertEquals("Angular.js", relations.getRelations().get(0).getSubject().getText());
		assertTrue(relations.getUrl().isEmpty());
	}
	
	@Test
	public void relationTestUsingTextAndDisambiguate() {
		String text = "Angular.js has been out there for a while now and is definitely a popular option to take into"
				+ " consideration when selecting a front end technology.";
		SAORelations relations = getConnector().relations(text, 10, true, null, null, null, null, true, null, true, null,
				null, null, null, null);

		assertNotNull(relations);
		assertEquals("english", relations.getLanguage());
		assertEquals(text + "\n", relations.getText());
		assertEquals(3, relations.getRelations().size());
		assertEquals("Angular.js", relations.getRelations().get(0).getSubject().getText());
		assertTrue(relations.getUrl().isEmpty());
	}
}
