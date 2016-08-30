package org.mule.modules.watsonalchemylanguage.automation.functional;

import org.mule.modules.watsonalchemylanguage.WatsonAlchemyLanguageConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public abstract class AbstractTestCases extends AbstractTestCase<WatsonAlchemyLanguageConnector> {

	protected AbstractTestCases() {
		super(WatsonAlchemyLanguageConnector.class);
	}

}
